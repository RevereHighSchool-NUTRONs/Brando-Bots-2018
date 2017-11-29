package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/26/2017.
 */

public class Elevator {
    private BBMotor armLPivot;
    private BBMotor armRPivot;
    private BBMotor leadScrew;
    // Servo that clamp the cube
    private  Servo leftServo;
    private  Servo rightServo;

    public Elevator(BBMotor pivotL , BBMotor pivotR , BBMotor lead, Servo lServo ,Servo rServo ){
        this.armLPivot = pivotL;
        this.armRPivot = pivotR;
        this.leadScrew = lead;
        this.leftServo = lServo;
        this.rightServo = rServo;
    }


}
