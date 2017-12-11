package org.firstinspires.ftc.teamcode.Subsytems;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Josh on 11/6/2017.
 */

public class Drivetrain {

    //Motors Declared
    public BBMotor leftFrontDrive;
    public BBMotor leftBackDrive;
    public BBMotor rightFrontDrive;
    public BBMotor rightBackDrive; 

    //Wheel Circumfrence
    private final double wheelCircumfrence = Math.PI * 3.875; //Meters

    public Drivetrain(BBMotor lF, BBMotor lB, BBMotor rF, BBMotor rB) {
        this.leftFrontDrive = lF;
        this.leftBackDrive = lB;
        this.rightFrontDrive = rF;
        this.rightBackDrive =  rB;
    }

    public void meterDrive(double meters, double speed) {
        leftFrontDrive.revolutionRun(meters / wheelCircumfrence, speed);
        rightFrontDrive.revolutionRun(meters / wheelCircumfrence, speed);
        leftBackDrive.setPower(leftFrontDrive.getPower());
        rightBackDrive.setPower(rightBackDrive.getPower());
    }

    public void drive(double lP, double rP) {
        leftFrontDrive.setPower(lP);
        leftBackDrive.setPower(-lP);
        rightFrontDrive.setPower(rP);
        rightBackDrive.setPower(-rP);

    }
}
