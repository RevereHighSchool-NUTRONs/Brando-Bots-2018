package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;

import java.util.concurrent.TimeUnit;

/**
 * Created by josh on 12/1/17.
 */

public class Intake {

    //Motors Declared
    BBMotor leftTake = null;
    BBMotor rightTake = null;

    //Timing
    ElapsedTime timer = new ElapsedTime();
    double relativeTime = 0;

    /**
     * Intake class used for intaking glyphs
     * @param lTake left BBMotor of the intake
     * @param rTake right BBMotor of the intake
     */
    public Intake(BBMotor lTake, BBMotor rTake) {
        leftTake = lTake;
        rightTake = rTake;
    }

    /**
     * runs the intake
     * @param spit true if you want to spit the cube instead of pull it in
     */
    public void intake(boolean spit) {
        if(!spit) {
            leftTake.setPower(1.0);
            rightTake.setPower(-1.0);
        }
        else {
            leftTake.setPower(-1.0);
            rightTake.setPower(1.0);
        }
    }

    public void resetTiming() {
        relativeTime = timer.time(TimeUnit.SECONDS);

    }

    /**
     * runs the intake for the given amount of time in seconds
     * @param seconds given amount of time in seconds
     * @return if the intake has been running for that amount of time
     */
    public boolean timeRun(double seconds) {
        double goal = relativeTime + seconds;
        intake(false);
        return timer.time(TimeUnit.SECONDS) >= goal;
    }
}
