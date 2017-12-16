package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBGyro;
import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;

/**
 * Created by Josh on 11/6/2017.
 */

public class Drivetrain {

    //PD constants for control g is for Gyro, k is for Drivetrain
    private final double kP = 1.0;
    private final double kD = 0.5;
    private final double gP = 0.25;


    //Motors declared
    private BBMotor leftFrontDrive;
    private BBMotor leftBackDrive;
    private BBMotor rightFrontDrive;
    private BBMotor rightBackDrive;

    private Servo jewelArm;

    //Gyro declared
    public BBGyro gyro;


    //Declaring drivetrain specifics for driving distance
    private double wheelCircumfrence;
    private double ticksPerRev;
    private double feetPerTick;

    //Timing for control
    ElapsedTime timer = new ElapsedTime();

    //Auto Constants
    private double lastError = 0.0;
    private double lastTime = 0.0;
    private double relativeClicks = 0.0;
    private double headingToHold = 0.0;
    private double driveDistanceTolerance = 224.0;
    private double turnToAngleTolerance = 36.0;


    /**
     * Drivetrain class used for controlling BB18 robot drivebase
     * @param lF left front motor of the drivetrain
     * @param rF right front motor of the drivetrain
     * @param gyro gyro used for heading
     */
    public Drivetrain(BBMotor lF, BBMotor lB, BBMotor rF, BBMotor rB, BBGyro gyro, Servo jewelArm) {
        this.leftFrontDrive = lF;
        this.rightFrontDrive = rF;
        this.leftBackDrive = lB;
        this.rightBackDrive = rB;
        this.leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.jewelArm = jewelArm;

        //Drivetrain specifics initialized
        wheelCircumfrence = 1.0144725; // Feet
        ticksPerRev = leftFrontDrive.getCountsPerRev();
        feetPerTick = wheelCircumfrence/ticksPerRev;

        this.gyro = gyro;
    }

    private double getRelativeEncoderPos() {
        return leftFrontDrive.getCurrentPos() + relativeClicks;
    }

    public boolean distanceDrive(double ftDistance) { // REQUIRES HOLD HEADING!!!
        double setpoint = ftDistance / feetPerTick;
        double error = setpoint - getRelativeEncoderPos();
        double now = timer.seconds();
        double dt = now - lastTime;
        lastTime = now;
        double output = (kP * error) + ((kD * ((error - lastError)) / dt));
        drive(output, output, true);
        lastError = error;
        return driveDistanceTolerance > Math.abs(error);
    }


    public void resetDriveDistance() {
        relativeClicks = leftFrontDrive.getCurrentPos();
        lastError = 0.0;
        lastTime = 0.0;
        timer.reset();
    }

    public void setAngleToHold(double angleToHold) {
        headingToHold = angleToHold;
    }

    public void grabAngleToHold() {
        headingToHold = gyro.getAngle();
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
       return turnToAngleTolerance > Math.abs(angleDifference);
   }

   public double getLastError() {
       return lastError;
   }

   public double getLfEnc() {
       return leftFrontDrive.getCurrentPos();
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
            lP -= turn;
            rP += turn;
        }
        leftFrontDrive.setPower(-lP);
        leftBackDrive.setPower(-lP);
        rightFrontDrive.setPower(rP);
        rightBackDrive.setPower(rP);
    }

    public void stopDrive() {
        leftFrontDrive.setPower(0.0);
        leftBackDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        rightBackDrive.setPower(0.0);
    }

    public void jewelArmUp() {
        jewelArm.setPosition(0.0);
    }

    public void jewelArmDown() {
        jewelArm.setPosition(1.0);
    }

    public void stopDT() {
        drive(0.0, 0.0, false);
    }
}
