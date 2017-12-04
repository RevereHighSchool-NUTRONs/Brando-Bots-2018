package org.firstinspires.ftc.teamcode.Supreme;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.BBMotor;

/**
 * Created by Josh on 11/6/2017.
 */

public class SupremeElevator {

    //Motors declared
    private BBMotor elevator;
    private Servo leftGrabber;
    private Servo rightGrabber;
    private Servo jewel;

    /**
     * Cool elevator
     */
    public SupremeElevator(BBMotor elevator, Servo leftGrabber, Servo rightGrabber, Servo jewel) {
        this.elevator = elevator;
        this.leftGrabber = leftGrabber;
        this.rightGrabber = rightGrabber;
        this.jewel = jewel;
    }

    /**
     * Sets power to the elevator
     */
    public void drive(double pow) {
        elevator.setPower(pow);
    }

    public void controlGrabber(boolean close) {
        if(!close) {
            leftGrabber.setPosition(1.0);
            rightGrabber.setPosition(0.0);
        }
        else {
            leftGrabber.setPosition(0.0);
            rightGrabber.setPosition(1.0);
        }
    }

    public void controlJewel(boolean down) {
        if(!down) {
            jewel.setPosition(0.0);
        }
        else{
            jewel.setPosition(1.0);
        }
    }
}
