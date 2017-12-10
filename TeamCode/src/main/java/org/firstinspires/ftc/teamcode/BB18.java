package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;
import org.firstinspires.ftc.teamcode.Subsytems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsytems.Elevator;
import org.firstinspires.ftc.teamcode.Subsytems.Intake;

/**
 * Created by Josh on 10/12/2017.
 */

public class BB18 {

    //Motors Declared
    public BBMotor leftFrontDrive;
    public BBMotor leftBackDrive;
    private BBMotor rightFrontDrive;
    private BBMotor rightBackDrive;
    private BBMotor intakeL;
    private BBMotor intakeR;
    private BBMotor elevatorL;
    private BBMotor lead;
    private Servo leftServ;
    private Servo rightServ;
    DigitalChannel intakeLimit;
    //Wheel Circumfrence
    private double wheelCircumfrence = Math.PI * 3.875; //Inches

    BB18Map hardware = new BB18Map();
    Drivetrain Dt =  new Drivetrain(leftBackDrive,leftFrontDrive,rightBackDrive,rightFrontDrive);
    Elevator Elevator;
    public BB18(HardwareMap hardwareMap) {
        hardware.init(hardwareMap);
        //Motors Init
        leftFrontDrive = new BBMotor(hardware.leftFrontDrive, BBMotor.MotorType.RevHDHex);
        leftBackDrive = new BBMotor(hardware.leftBackDrive, BBMotor.MotorType.RevHDHex);
        rightFrontDrive = new BBMotor(hardware.rightFrontDrive, BBMotor.MotorType.RevHDHex);
        rightBackDrive = new BBMotor(hardware.rightBackDrive, BBMotor.MotorType.RevHDHex);
        // intake initialization
        intakeL = new BBMotor(hardware.intakeL, BBMotor.MotorType.NeveRest);
        intakeR = new BBMotor(hardware.intakeR, BBMotor.MotorType.NeveRest);
        //elevator init
        elevatorL = new BBMotor(hardware.pivotL, BBMotor.MotorType.RevCoreHex);
        lead =  new BBMotor(hardware.lead, BBMotor.MotorType.RevCoreHex);
        //
        Elevator =  new Elevator(elevatorL,lead,leftServ,rightServ);

        Dt =  new Drivetrain(leftFrontDrive,leftBackDrive, rightFrontDrive,rightBackDrive);
      }

       public void inchDrive(double inches, double speed) {
        leftFrontDrive.revolutionRun(inches / wheelCircumfrence, speed);
        rightFrontDrive.revolutionRun(inches / wheelCircumfrence, speed);
        leftBackDrive.setPower(leftFrontDrive.getPower());
        rightBackDrive.setPower(rightBackDrive.getPower());

    }

}
