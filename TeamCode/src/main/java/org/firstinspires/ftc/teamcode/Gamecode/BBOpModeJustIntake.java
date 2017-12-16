package org.firstinspires.ftc.teamcode.Gamecode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BB18;

/**
 * Created by josh on 11/28/17.
 */

@TeleOp(name="BB Tele-Op 1.0 I", group="Gamecode")
public class BBOpModeJustIntake extends OpMode
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
        /* Operator Control */
        if(gamepad2.a) {
            robot.BBTake.intake(false);
        }
        else {
            robot.BBTake.stopIntake();
        }
        if(gamepad2.b) {
            robot.BBTake.intake(true);
        }
        else {
            robot.BBTake.stopIntake();
        }
    }

    @Override
    public void stop() {

    }

}
