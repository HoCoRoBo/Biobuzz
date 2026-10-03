package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.IntakeHardware;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

public class Intake {

    private final DcMotor intakeMotor;

    public Intake(IntakeHardware hardware, RobotTelemetry telemetry){
        intakeMotor = hardware.intakeMotor;
    }



}
