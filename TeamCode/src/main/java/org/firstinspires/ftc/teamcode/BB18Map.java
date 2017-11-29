package org.firstinspires.ftc.teamcode;

/**
 * Created by Josh on 10/12/2017.
 */

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * The purpose of the BB18Map class is to work together with a Robot class to add easy implementation across op-modes and auto.
 * Holds named concurrent to that of the robot controller.
 */
public class BB18Map {

    //Motors
    DcMotor leftFrontDrive;
    //DcMotor leftBackDrive;
    DcMotor rightFrontDrive;
    //DcMotor rightBackDrive;

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
        // Motors
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftF");
        //leftBackDrive = hwMap.get(DcMotor.class, "leftB");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightF");
        //rightBackDrive = hwMap.get(DcMotor.class, "rightB");
        gyro = hardwareMap.get(BNO055IMU.class, "gyro"); //IMU
    }

}
