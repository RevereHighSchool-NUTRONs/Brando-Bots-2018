package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BB18;

/**
 * Created by Josh on 11/28/17.
 */

@TeleOp(name="Auto Testing 9", group="Gamecode")
public class DistanceDriveTest extends OpMode
{
    BB18 robot;
    int autoState;

    @Override
    public void init() {
        robot = new BB18(hardwareMap);
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start(){
        autoState = 0;
        robot.BBDrive.resetDriveDistance();
        robot.BBDrive.setAngleToHold(0.0);
    }


    @Override
    public void loop() {
        telemetry.addData("lastError", robot.BBDrive.getLastError());
        telemetry.addData("leftEnc", robot.BBDrive.getLfEnc());
        switch (autoState) {
            case 0:
                if(robot.BBDrive.distanceDrive(-3.0)) {
                    robot.BBDrive.stopDrive();
                    autoState = 1;
                    robot.BBDrive.resetDriveDistance();
                }
                break;
            case 1:
                if(robot.BBDrive.turnToAngle(90.0)){
                    robot.BBDrive.stopDrive();
                    autoState = 2;
                    robot.BBDrive.setAngleToHold(90.0);
                }
                break;

            case 2:
                if(robot.BBTake.timeRun(2.0)) {
                    autoState = 3;
                    robot.BBTake.stopIntake();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void stop() {

    }

}
