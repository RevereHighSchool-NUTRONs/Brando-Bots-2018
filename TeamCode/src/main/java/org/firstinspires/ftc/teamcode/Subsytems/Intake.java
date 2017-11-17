package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.BB18;
import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/6/2017.
 */

public class Intake {
    public static BBMotor intake;
    public static DigitalChannel Touchsensor;
    // intake constructor
    public Intake (BBMotor inatke){


    }
    // used for intaking the cube
    public static void drive(int Power) {
        intake.setPower(Power);
    }
    // used to reverse the direction of the intake to spit the cube.
    public static void spit(int Power){
        drive(-Power);
    }

}
