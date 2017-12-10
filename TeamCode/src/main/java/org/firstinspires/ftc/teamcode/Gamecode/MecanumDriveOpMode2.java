package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorBNO055IMU;
import org.firstinspires.ftc.teamcode.BBLibrary.Hardware.BBGyro;

/**
 * Created by josh on 11/28/17.
 */

@TeleOp(name="Mecanum 2", group="Gamecode")
public class MecanumDriveOpMode2 extends OpMode
{
    DcMotor leftFront = null;
    DcMotor rightFront = null;
    DcMotor leftBack = null;
    DcMotor rightBack = null;

    BBGyro gyro = null;
    double initialAngle;
    double headingToHold;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotor.class, "leftF");
        rightFront = hardwareMap.get(DcMotor.class, "rightF");
        leftBack = hardwareMap.get(DcMotor.class, "leftB");
        rightBack = hardwareMap.get(DcMotor.class, "rightB");

        gyro = new BBGyro(hardwareMap.get(BNO055IMU.class, "imu"));
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start(){
        initialAngle = gyro.getAngle();
    }


    @Override
    public void loop() {

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        double angleError = gyro.getAngle() - initialAngle;

        float lfPow = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float lbPow = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float rfPow = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float rbPow = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        rfPow = Range.clip(rfPow, -1, 1);
        lfPow = Range.clip(lfPow, -1, 1);
        lbPow = Range.clip(lbPow, -1, 1);
        rbPow = Range.clip(rbPow, -1, 1);

        leftFront.setPower(lfPow);
        leftBack.setPower(lbPow);
        rightFront.setPower(rfPow);
        rightBack.setPower(rbPow);

    }

    @Override
    public void stop() {

    }

}
