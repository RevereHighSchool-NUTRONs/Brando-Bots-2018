package org.firstinspires.ftc.teamcode;

/**
 * Created by Josh on 10/12/2017.
 */

import android.hardware.camera2.DngCreator;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsytems.Elevator;
import org.firstinspires.ftc.teamcode.Subsytems.Intake;

/**
 * The purpose of the BB18Map class is to work together with a Robot class to add easy implementation across op-modes and auto.
 * Holds named concurrent to that of the robot controller.
 */
public class BB18Map {

    //Motors
    DcMotor leftFrontDrive;
    DcMotor leftBackDrive;
    DcMotor rightFrontDrive;
    DcMotor rightBackDrive;
    DcMotor intakeR;
    DcMotor intakeL;
    DcMotor pivotL;
    DcMotor pivotR;
    DcMotor lead;
    Servo   leftServ;
    Servo   rightServ;
    DigitalChannel intakeLimit;

    // Class Map
    HardwareMap hwMap;


    public BB18Map() {
        //Empty on purpose
    }

    public void init(HardwareMap hardwareMap) {
        this.hwMap = hardwareMap;

        //Elevator
       /* pivotL = hwMap.get(DcMotor.class, "pivotL");
        pivotR =  hwMap.get(DcMotor.class,"pivotR");
        lead = hwMap.get(DcMotor.class,"lead");
        leftServ = hwMap.get(Servo.class, "leftServ");
        rightServ = hwMap.get(Servo.class, "rightServ");
        // intake
        intakeL = hwMap.get(DcMotor.class, "intakeL");
        intakeR = hwMap.get(DcMotor.class,"intakeR");
        intakeLimit  = hwMap.get(DigitalChannel.class ,"intakeLimit");
        */
        // DriveTrain Motors
        leftFrontDrive = hwMap.get(DcMotor.class, "leftF");
        leftBackDrive = hwMap.get(DcMotor.class, "leftB");
        rightFrontDrive = hwMap.get(DcMotor.class, "rightF");
        rightBackDrive = hwMap.get(DcMotor.class, "rightB");
    }
}
