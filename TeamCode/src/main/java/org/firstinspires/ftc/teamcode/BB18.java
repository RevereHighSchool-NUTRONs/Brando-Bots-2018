package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBGyro;
import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBMotor;
import org.firstinspires.ftc.teamcode.Subsytems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsytems.Elevator;
import org.firstinspires.ftc.teamcode.Subsytems.Intake;

/**
 * Created by Josh on 10/12/2017.
 */

public class BB18 {

    //Declaring drivetrain motors and objects
    private BBMotor leftFrontDrive;
    private BBMotor leftBackDrive;
    private BBMotor rightFrontDrive;
    private BBMotor rightBackDrive;
    private BBGyro gyro; //IMU
    private Servo jewelArm;

    public Drivetrain BBDrive;

    //Declaring intake motors and objects
    private BBMotor leftTake;
    private BBMotor rightTake;

    public Intake BBTake;

    //Declaring elevator motors and objects
    private BBMotor stageMotor;
    private BBMotor pivotArm;
    private Servo leftGrabber;
    private Servo rightGrabber;

    public Elevator BBElevator;

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
        jewelArm = robotMap.jewelArm;
        gyro = new BBGyro(robotMap.gyro); // Assigning IMU
        BBDrive = new Drivetrain(leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive, gyro, jewelArm);

        //Assigning Intake Motors and Object
        leftTake = new BBMotor(robotMap.leftTake, BBMotor.MotorType.NeveRest);
        rightTake = new BBMotor(robotMap.rightTake, BBMotor.MotorType.NeveRest);
        BBTake = new Intake(leftTake, rightTake);


        //Assigning Elevator Motors and Object
        stageMotor = new BBMotor(robotMap.stageMotor, BBMotor.MotorType.CoreHex);
        pivotArm = new BBMotor(robotMap.pivotArm, BBMotor.MotorType.CoreHex);
        leftGrabber = robotMap.leftGrabber;
        rightGrabber = robotMap.rightGrabber;
        BBElevator = new Elevator(pivotArm, stageMotor, leftGrabber, rightGrabber);

    }

}
