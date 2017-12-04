package org.firstinspires.ftc.teamcode.Supreme;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.BBGyro;
import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Josh on 11/6/2017.
 */

public class SupremeDrivetrain {

    //Motors declared
    private BBMotor leftFrontDrive;
    private BBMotor rightFrontDrive;


    /**
     * Drivetrain class used for controlling BB18 robot drivebase
     * @param lF left front motor of the drivetrain
     * @param rF right front motor of the drivetrain
     */
    public SupremeDrivetrain(BBMotor lF, BBMotor rF) {
        this.leftFrontDrive = lF;
        this.rightFrontDrive = rF;
    }

    /**
     * Sets power to the drivetrain thus driving it
     * @param lP power to the left side of the drivetrain
     * @param rP power to the right side of the drivetrain
     */
    public void drive(double lP, double rP) {
        leftFrontDrive.setPower(lP);
        rightFrontDrive.setPower(-rP);
    }
}
