package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBGyro;
import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;
import org.firstinspires.ftc.teamcode.Subsytems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsytems.Intake;

/**
 * Created by Josh on 10/12/2017.
 */

public class BB18 {

    //Declaring drivetrain motors and objects
    public BBMotor leftFrontDrive;
    public BBMotor leftBackDrive;
    public BBMotor rightFrontDrive;
    public BBMotor rightBackDrive;
    public Drivetrain BBDrive;

    //Declaring intake motors and onject
    public BBMotor leftTake;
    public  BBMotor rightTake;
    public Intake BBTake;
    //IMU
    public BBGyro gyro;


    BB18Map robotMap;

    /**
     * BB18 Robot class
     * @param hardwareMap hardwareMap from op-mode class
     */
    public BB18(HardwareMap hardwareMap) {

        robotMap = new BB18Map(); //Declaring map class
        robotMap.init(hardwareMap); //Receiving passed through map class for creating custom hardware

        //Assigning Drivetrain Motors and Object
        leftFrontDrive = new BBMotor(robotMap.leftFrontDrive, BBMotor.MotorType.RevHDHex);
        leftBackDrive = new BBMotor(robotMap.leftBackDrive, BBMotor.MotorType.RevHDHex);
        rightFrontDrive = new BBMotor(robotMap.rightFrontDrive, BBMotor.MotorType.RevHDHex);
        rightBackDrive = new BBMotor(robotMap.rightBackDrive, BBMotor.MotorType.RevHDHex);
        gyro = new BBGyro(robotMap.gyro); // Assigning IMU
        BBDrive = new Drivetrain(leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive, gyro);

        //Assigning Intake Motors and Object
        leftTake = new BBMotor(robotMap.leftTake, BBMotor.MotorType.NeveRest);
        rightTake = new BBMotor(robotMap.rightTake, BBMotor.MotorType.NeveRest);
        BBTake = new Intake(leftTake, rightTake);


    }

}
