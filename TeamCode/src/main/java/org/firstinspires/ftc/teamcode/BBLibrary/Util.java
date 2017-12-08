package org.firstinspires.ftc.teamcode.BBLibrary;

/**
 * Created by josh on 11/28/17.
 */

public class Util {

    /**
     * Applys a deadband to joystick values making all values outside of the allowed deadband 0
     * @param value the value given back by a joystick
     * @param deadband deadband threshold
     * @param center center of the joystick, usually 0.0
     * @return Actual value, or 0 if out of deadband threshold
     */
    public static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

}
