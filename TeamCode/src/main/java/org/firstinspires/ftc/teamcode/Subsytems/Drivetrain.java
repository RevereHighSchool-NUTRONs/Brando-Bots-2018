package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.BBGyro;
import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Josh on 11/6/2017.
 */

public class Drivetrain {

    //PD constants for control
    private final double kP = 1.0;
    private final double kD = 0.5;
    private final double gP = 1.0;
    private final double gD = 0.5;

    //Motors declared
    private BBMotor leftFrontDrive;
    //public BBMotor leftBackDrive;
    private BBMotor rightFrontDrive;
    //public BBMotor rightBackDrive;

    //IMU declared
    private BBGyro gyro;


    //Declaring drivetrain specifics
    private double wheelCircumfrence;
    private double ticksPerRev;
    private double feetPerTick;

    //Timing for control
    ElapsedTime timer = new ElapsedTime();

    //Auto Constants
    private double lastError = 0.;
    private double lastTime = 0.;
    private double relativeClicks = 0.;
    private double headingToHold = 0.;
    private double driveDistanceTolerance = 20;
    private double turnToAngleTolerance = 5;


    /**
     * Drivetrain class used for controlling BB18 robot drivebase
     * @param lF left front motor of the drivetrain
     * @param rF right front motor of the drivetrain
     * @param gyro gyro used for heading
     */
    public Drivetrain(BBMotor lF, BBMotor rF, BBGyro gyro) {
        this.leftFrontDrive = lF;
        this.rightFrontDrive = rF;

        //Drivetrain specifics initialized
        wheelCircumfrence = Math.PI * (1/3); // Feet
        ticksPerRev = leftFrontDrive.getCountsPerRev();
        feetPerTick = wheelCircumfrence / ticksPerRev;
    }

    private double getRelativeEncoderPos() {
        return leftFrontDrive.getCurrentPos() + relativeClicks;
    }

    public boolean distanceDrive(double ftDistance) { // REQUIRES HOLD HEADING!!!
        double setpoint = ftDistance / feetPerTick;
        double error = setpoint - getRelativeEncoderPos();
        double now = timer.now(TimeUnit.SECONDS);
        double dt = now - lastTime;
        lastTime = now;
        double output = (kP * error) + ((kD * (error - lastError)) / dt);
        drive(output, output, true);
        lastError = error;
        error = setpoint - getRelativeEncoderPos();
        return driveDistanceTolerance > error;
    }

    public void resetDriveDistance() {
        relativeClicks = leftFrontDrive.getCurrentPos();
        lastError = 0.;
        lastTime = 0.;
    }

    public void setAngleToHold(double angleToHold) {
        headingToHold = angleToHold;
    }

    /**
     * Turns robot to specified angle using simple P loop
     * @param angleSetpoint specified angle
     */
   public boolean turnToAngle(double angleSetpoint) {
       double gyroHeading = gyro.getAngle();
       double angleDifference = angleSetpoint - gyroHeading;
       double turn = gP * angleDifference;
       drive(turn, -turn, false);
       return turnToAngleTolerance > angleDifference;
   }

    /**
     * Sets power to the drivetrain thus driving it
     * @param lP power to the left side of the drivetrain
     * @param rP power to the right side of the drivetrain
     */
    public void drive(double lP, double rP, boolean holdHeading) {
        if(holdHeading) {
            double gyroHeading = gyro.getAngle();
            double angleDifference = headingToHold - gyroHeading;
            double turn = gP * angleDifference;
            lP += turn;
            rP -= turn;
        }
        leftFrontDrive.setPower(lP);
        //leftBackDrive(lP);
        rightFrontDrive.setPower(rP);
        //rightBackDrive(rP);
    }
}
