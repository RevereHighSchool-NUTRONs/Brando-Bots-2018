package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/26/2017.
 */

public class Elevator {
    public static BBMotor pivotL;
    public static BBMotor pivotR;

    // Servo that clamp the cube
    public static Servo leftServo;
    public static Servo rightServo;

    public Elevator(BBMotor pivotL , BBMotor pivotR , Servo lServo ,Servo rServo ){}


}
