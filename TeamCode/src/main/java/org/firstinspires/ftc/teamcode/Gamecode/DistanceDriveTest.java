package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BB18;

/**
 * Created by josh on 11/28/17.
 */

@TeleOp(name="Auto Testing", group="Gamecode")
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

        switch (autoState) {
            case 0:
                if(robot.BBDrive.distanceDrive(10.0)){
                    autoState = 1;
                    robot.BBDrive.resetDriveDistance();
                }
                break;
            case 1:
                if(robot.BBDrive.turnToAngle(90.0)) {
                    autoState = 2;
                    robot.BBDrive.setAngleToHold(90.0);
                }
                break;
            case 2:
                if(robot.BBDrive.distanceDrive(5.0)) {
                    autoState = 3;
                    robot.BBDrive.resetDriveDistance();
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
