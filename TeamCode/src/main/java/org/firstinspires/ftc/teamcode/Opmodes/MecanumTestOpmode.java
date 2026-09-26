package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriverControls.MecanumTestDriverControls;
import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrivetrain;

@TeleOp(name="My First OpMode", group="LinearOpMode")
public class MecanumTestOpmode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


        // Initialize

        Hardware hardware = new Hardware(hardwareMap);

        MecanumDrivetrain drivetrain = new MecanumDrivetrain(hardware);

        MecanumTestDriverControls driverControls = new MecanumTestDriverControls(gamepad1);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            drivetrain.fieldCentricDrive(
                    driverControls.driveX(),
                    driverControls.driveY(),
                    driverControls.turn()
            );



        }
    }
}
