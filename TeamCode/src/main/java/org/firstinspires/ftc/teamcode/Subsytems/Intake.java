package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;

/**
 * Created by josh on 12/1/17.
 */

public class Intake {

    //Motors Declared
    BBMotor leftTake = null;
    BBMotor rightTake = null;

    //Timing
    ElapsedTime timer = new ElapsedTime();

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

    public boolean timeRun(double seconds) {
        timer.reset();
        while(timer.seconds() < seconds) {

        }
        return true; //TODO: this
    }
}
