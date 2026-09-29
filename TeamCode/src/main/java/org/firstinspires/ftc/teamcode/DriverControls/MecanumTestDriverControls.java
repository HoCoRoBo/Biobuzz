package org.firstinspires.ftc.teamcode.DriverControls;

import com.qualcomm.robotcore.hardware.Gamepad;

public class MecanumTestDriverControls {

    private final Gamepad gamepad;

    public MecanumTestDriverControls(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public double driveX() {
        return gamepad.left_stick_x;
    }

    public double driveY() {
        return -gamepad.left_stick_y * 1.1;
    }

    public double turn() {
        return gamepad.right_stick_x;
    }

    public boolean slowMode() {
        return gamepad.rightBumperWasPressed();
    }

}

