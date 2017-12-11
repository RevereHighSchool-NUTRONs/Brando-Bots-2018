package org.firstinspires.ftc.teamcode.Subsytems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Darkn on 11/26/2017.
 */

public class Elevator {
    private BBMotor armLPivot;
    private BBMotor leadScrew;
    // Servo that clamp the cube
    private  Servo leftServo;
    private  Servo rightServo;
    private double startL;
    private double startR;

    public Elevator(BBMotor pivotL ,BBMotor lead, Servo lServo ,Servo rServo ){
        this.armLPivot = pivotL;
        this.leadScrew = lead;
        this.leftServo = lServo;
        this.rightServo = rServo;
        armLPivot.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }

    public void pivot(double angle){
        armLPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        startL = armLPivot.getCurrentPos();



    }

}
