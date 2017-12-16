package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BB18;

/**
 * Created by josh on 11/28/17.
 */

@TeleOp(name="BB Tele-Op 2.0", group="Gamecode")
public class BBOpMode extends OpMode
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
        /* Driver Control */
        double dtLeftPow = gamepad1.left_stick_y;
        double dtRightPow = gamepad1.right_stick_y;
        robot.BBDrive.drive(dtLeftPow, dtRightPow, false);
        if(gamepad1.a) {
            robot.BBDrive.jewelArmDown();
        }
        if(gamepad1.b) {
            robot.BBDrive.jewelArmUp();
        }

        /* Operator Control */
        double stagePow = gamepad2.left_stick_y;
        double elevatorPow = gamepad2.right_stick_y;
        robot.BBElevator.directElevate(elevatorPow);
        robot.BBElevator.directPivot(stagePow);
        if(gamepad2.right_bumper) {
            robot.BBTake.intake(false);
        }
        else {
            robot.BBTake.stopIntake();
        }
        if(gamepad2.left_bumper) {
            robot.BBTake.intake(true);
        }
        else {
            robot.BBTake.stopIntake();
        }
        if(gamepad2.a) {
            robot.BBElevator.openGrabbers();
        }
        if(gamepad2.b) {
            robot.BBElevator.closeGrabbers();
        }
        telemetry.addData("Gyro Angle:", robot.BBDrive.gyro.getAngle());
    }

    @Override
    public void stop() {

    }

}
