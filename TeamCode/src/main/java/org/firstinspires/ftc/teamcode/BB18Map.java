package org.firstinspires.ftc.teamcode;

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
public class BB18Map {

    //Motors
    DcMotor leftFrontDrive;
    DcMotor leftBackDrive;
    DcMotor rightFrontDrive;
    DcMotor rightBackDrive;
    DcMotor leftTake;
    DcMotor rightTake;
    DcMotor stageMotor;
    DcMotor pivotArm;

    //Servos
    Servo leftGrabber;
    Servo rightGrabber;
    Servo jewelArm;

    //IMU
    BNO055IMU gyro;

    /**
     * Map class used for easy implementation of custom motor classes and BB18 robot class
     */
    public BB18Map() {
        //Empty on purpose
    }

    /**
     * Initializes custom map class with passed through hardwareMap from op-mode class
     * @param hardwareMap hardware map from op-mode class
     */
    public void init(HardwareMap hardwareMap) {
        /* Drivetrain */
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftF");
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftB");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightF");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightB");
        jewelArm = hardwareMap.get(Servo.class, "jewel");
        gyro = hardwareMap.get(BNO055IMU.class, "gyro");


        /* Intake */
        leftTake = hardwareMap.get(DcMotor.class, "leftT");
        rightTake = hardwareMap.get(DcMotor.class, "rightT");


        /* Elevator */
        stageMotor = hardwareMap.get(DcMotor.class, "stage");
        pivotArm = hardwareMap.get(DcMotor.class, "pivot");
        leftGrabber = hardwareMap.get(Servo.class, "leftG");
        rightGrabber = hardwareMap.get(Servo.class, "rightG");


    }

}
