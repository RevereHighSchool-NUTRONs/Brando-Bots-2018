package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Josh on 10/12/2017.
 */

public class BB18 {

    //Motors Declared
    public BBMotor leftFrontDrive;
    //public BBMotor leftBackDrive;
    public BBMotor rightFrontDrive;
    //public BBMotor rightBackDrive;

    //Wheel Circumfrence
    private double wheelCircumfrence = Math.PI * 3.875; //Inches

    BB18Map hardware = new BB18Map();

    public BB18(HardwareMap hardwareMap) {
        hardware.init(hardwareMap);
        //Motors Init
        leftFrontDrive = new BBMotor(hardware.leftFrontDrive, BBMotor.MotorType.RevHDHex);
        //leftBackDrive = new BBMotor(hardware.leftBackDrive, BBMotor.MotorType.RevHDHex);
        rightFrontDrive = new BBMotor(hardware.rightFrontDrive, BBMotor.MotorType.RevHDHex);
        //rightBackDrive = new BBMotor(hardware.rightBackDrive, BBMotor.MotorType.RevHDHex);
    }

    public void inchDrive(double inches, double speed) {
        leftFrontDrive.revolutionRun(inches / wheelCircumfrence, speed);
        rightFrontDrive.revolutionRun(inches / wheelCircumfrence, speed);
        //leftBackDrive.setPower(leftFrontDrive.getPower());
        //rightBackDrive.setPower(rightBackDrive.getPower());

    }

}
