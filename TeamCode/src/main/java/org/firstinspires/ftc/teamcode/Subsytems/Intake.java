package org.firstinspires.ftc.teamcode.Subsytems;

import org.firstinspires.ftc.teamcode.BB18;
import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/6/2017.
 */

public class Intake {
   public static BBMotor intake;
    // wheel circumference
    private final double wheelCircumfrence = Math.PI * 3.875;
    // intake constructor
    public Intake (BBMotor inatke){


    }
    // used for intaking the cube
    public static void drive(int Power) {
        intake.setPower(Power);
    }
    // used to reverse the direction of the intake to spit the cube.
    public static void siit(int power){
        drive(-power);
    }

}
