package org.firstinspires.ftc.teamcode.Supreme;

/**
 * Created by Josh on 10/12/2017.
 */

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * The purpose of the BB18Map class is to work together with a Robot class to add easy implementation across op-modes and auto.
 * Holds named concurrent to that of the robot controller.
 */
public class SupremeMap {

    //Motors
    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor elevator;

    Servo leftGrab;
    Servo rightGrab;
    Servo jewel;


    /**
     * Map class used for easy implementation of custom motor classes and BB18 robot class
     */
    public SupremeMap() {
        //Empty on purpose
    }

    /**
     * Initializes custom map class with passed through hardwareMap from op-mode class
     * @param hardwareMap hardware map from op-mode class
     */
    public void init(HardwareMap hardwareMap) {
        // Motors
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftF");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightF");
        elevator = hardwareMap.get(DcMotor.class, "elevator");

        //Servos
        leftGrab = hardwareMap.get(Servo.class, "leftG");
        rightGrab = hardwareMap.get(Servo.class, "rightG");
        jewel = hardwareMap.get(Servo.class, "jewel");
    }

}
