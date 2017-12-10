package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.BB18;
import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/6/2017.
 */

public class Intake {
    private BBMotor intake;
    private DigitalChannel touchsensor;
    // intake constructor
    public Intake (BBMotor succ, DigitalChannel button){
        this.intake = succ;
        this.touchsensor = button;

    }
    // used for intaking the cube
    public void drive(int power) {
        if(touchsensor.getState()== true){
            intake.setPower(0);
        }
        intake.setPower(power);
    }
    // used to reverse the direction of the intake to spit the cube.
    public void spit(int Power){
        drive(-Power);
    }

}
