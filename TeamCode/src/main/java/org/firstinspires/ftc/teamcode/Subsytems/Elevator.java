package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;

import java.util.concurrent.TimeUnit;

/**
 * Created by josh on 12/12/17.
 */

public class Elevator {

    //Motors Declared
    private BBMotor pivotArm;
    private BBMotor stageMotor;

    //Servos Declared
    private Servo leftGrabber;
    private Servo rightGrabber;
    // PID constants
    private final double Kp = 0;
    private final double Kd = 0;
    private double relativeticks = 0;
    //motor specs
    private double pPR;
    private double degreepertick;
    private double preError = 0;
    private double pretime = 0;
    private double tolerance = 0;

    //Timing
    ElapsedTime timer = new ElapsedTime();
    double relativeTime = 0;

    public Elevator(BBMotor pivotArm, BBMotor stageMotor, Servo lG, Servo rG) {
        this.pivotArm = pivotArm;
        this.stageMotor = stageMotor;
        this.leftGrabber = lG;
        this.rightGrabber = rG;
        pPR = pivotArm.getCountsPerRev();
        degreepertick = pPR / 360;
    }

    public void resetTiming() {
        relativeTime = timer.time(TimeUnit.SECONDS);
    }

    public void elevate(boolean down) {
        if (!down) {
            stageMotor.setPower(1.0);
        } else {
            stageMotor.setPower(-1.0);
        }

    }
    public Boolean pivotPID(double tAngle) {
        double setpoint = tAngle / degreepertick;
        double error = setpoint - (pivotArm.getCurrentPos()+ relativeticks) ;
        double currentTime = timer.seconds();
        double dt = currentTime - pretime;
        pretime  = currentTime;
        double output =  (Kp * error)+( dt / (error - preError)) * Kd;
        pivot(output, true);
        error = setpoint - (pivotArm.getCurrentPos() + relativeticks ) ;
        return tolerance  > error ;
    }

    public void pivot(double angle, Boolean Pid) {
            if (Pid){
                pivotArm.setPower(angle);
            }else{
                pivotArm.setPower(0);
            }
    }

    public void stopElevate() {
        stageMotor.setPower(0.0);
    }

    public void stopPivot() {
        pivotArm.setPower(0.0);
    }

    public void openGrabbers() {
        leftGrabber.setPosition(0.0);
        rightGrabber.setPosition(0.0);
    }

    public void closeGrabbers() {
        leftGrabber.setPosition(1.0);
        rightGrabber.setPosition(1.0);
    }

    public boolean timeRunElevator(double seconds, boolean down) {
        double goal = relativeTime + seconds;
        elevate(down);
        return timer.time(TimeUnit.SECONDS) >= goal;
    }

    public boolean timeRunPivot(double seconds, boolean down) {
        double goal = relativeTime + seconds;
        pivot(down);
        return timer.time(TimeUnit.SECONDS) >= goal;
    }

}

