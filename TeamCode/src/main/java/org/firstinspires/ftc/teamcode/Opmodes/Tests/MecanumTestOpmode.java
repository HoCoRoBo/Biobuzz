package org.firstinspires.ftc.teamcode.Opmodes.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriverControls.MecanumTestDriverControls;
import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.Utils.RobotTelemetry;

@TeleOp(name="My First OpMode", group="LinearOpMode")
public class MecanumTestOpmode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


        // Initialize

        RobotTelemetry robotTelemetry = new RobotTelemetry(telemetry);

        RobotHardware robotHardware = new RobotHardware(hardwareMap);

        MecanumDrivetrain drivetrain = new MecanumDrivetrain(robotHardware, robotTelemetry);

        MecanumTestDriverControls driverControls = new MecanumTestDriverControls(gamepad1);

        robotTelemetry.add(
                "Status",
                "Initialized"
        );
        robotTelemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            drivetrain.drive(
                    driverControls.driveX(),
                    driverControls.driveY(),
                    driverControls.turn()
            );

            drivetrain.setSlowMode(driverControls.slowMode());

            drivetrain.addTelemetry();

            robotTelemetry.update();

        }
    }
}
