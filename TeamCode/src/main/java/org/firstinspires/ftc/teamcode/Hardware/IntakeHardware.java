package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeHardware {

    public final DcMotor intakeMotor;

    public IntakeHardware(HardwareMap hardwareMap){

        intakeMotor = hardwareMap.get(DcMotor.class, "intake");

    }

}
