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
    private double startL;
    private double startR;

    public Elevator(BBMotor pivotL ,BBMotor lead, Servo lServo ,Servo rServo ){
        this.armLPivot = pivotL;
        this.leadScrew = lead;
        this.leftServo = lServo;
        this.rightServo = rServo;
        armLPivot.setMode(DcMotor.RunMode.RESET_ENCODERS);
        armRPivot.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }

    public void pivotToUp(double angle){
        armRPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armLPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        startL = armLPivot.getCurrentPos();
        startR = armRPivot.getCurrentPos();
        
        armLPivot.setPower(0.5);
        armRPivot.setPower(0.5);


    }

}
