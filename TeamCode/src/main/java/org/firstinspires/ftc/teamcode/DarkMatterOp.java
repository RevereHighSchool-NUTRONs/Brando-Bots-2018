package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Darkn on 9/14/2017.
 */

public class DarkMatterOp extends OpMode {
     DarkMatterMap robot =  new DarkMatterMap();


    @Override
    public void init() {
    robot.init(hardwareMap);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void loop() {
        if (gamepad1.x){
            strafeLeft();
        }
        if (gamepad1.b){


        }

    }
    public void strafeLeft(){
    robot.leftFrontDrive.setPower(1.0);
        robot.rightBackDrive.setPower(1.0);


    }
}
