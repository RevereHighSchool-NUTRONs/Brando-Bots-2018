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
    BBMotor pivotArm;
    BBMotor stageMotor;

    //Servos Declared
    Servo leftGrabber;
    Servo rightGrabber;

    //Timing
    ElapsedTime timer = new ElapsedTime();
    double relativeTime = 0;

    public Elevator(BBMotor pivotArm, BBMotor stageMotor, Servo lG, Servo rG) {
        this.pivotArm = pivotArm;
        this.stageMotor = stageMotor;
        this.leftGrabber = lG;
        this.rightGrabber = rG;
    }

    public void resetTiming() {
        relativeTime = timer.time(TimeUnit.SECONDS);
    }

    public void elevate(boolean down) {
        if (!down) {
            stageMotor.setPower(1.0);
        }
        else {
            stageMotor.setPower(-1.0);
        }
    }

    public void pivot(boolean down) {
        if (!down) {
            pivotArm.setPower(1.0);
        }
        else {
            pivotArm.setPower(-1.0);
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

