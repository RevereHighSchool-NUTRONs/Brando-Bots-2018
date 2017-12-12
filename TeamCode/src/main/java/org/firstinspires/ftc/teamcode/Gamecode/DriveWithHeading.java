package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BB18;

/**
 * Created by josh on 11/28/17.
 */

@TeleOp(name="Driver", group="Gamecode")
public class DriveWithHeading extends OpMode
{
    BB18 robot;

    @Override
    public void init() {
        robot = new BB18(hardwareMap);
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start(){

    }


    @Override
    public void loop() {
        double leftPow = gamepad1.left_stick_y;
        double rightPow = gamepad1.right_stick_y;

        robot.BBDrive.drive(leftPow, rightPow, false);

        if(gamepad1.right_bumper) {
            robot.BBDrive.grabAngleToHold();
        }
        if(gamepad1.left_bumper) {
            robot.BBDrive.drive(leftPow, rightPow, true);
        }
    }

    @Override
    public void stop() {

    }

}
