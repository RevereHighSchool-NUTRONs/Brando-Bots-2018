package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;


/**
 * Created by Darkn on 9/13/2017.
 */

public class DarkMatterMap{
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive =  null;
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive  =  null;




    HardwareMap hMap = null;

    public void DarkMatterMap(){}

    public void init(HardwareMap darkMap){
        hMap =  darkMap;
        rightFrontDrive  = hMap.get(DcMotor.class, "Right_Front_Drive");
        rightBackDrive = hMap.get(DcMotor.class ,"Right_Back_Drive");
        leftFrontDrive =  hMap.get(DcMotor.class,"Left_Front_Drive");
        leftBackDrive =  hMap.get(DcMotor.class,"Left_Back_Drive");

        leftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }
}
