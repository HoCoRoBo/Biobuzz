package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants.MotorConstants;
import org.firstinspires.ftc.teamcode.Hardware;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Types.MotorPowers;
import org.firstinspires.ftc.teamcode.Utils.MecanumDrivetrainUtils;


public class MecanumDrivetrain {

    private final DcMotor frontLeftMotor;
    private final DcMotor frontRightMotor;
    private final DcMotor backLeftMotor;
    private final DcMotor backRightMotor;

    private final IMU imu;


    private double powerScale = MotorConstants.NORMAL_MODE_POWER_SCALE;


    //Mode

    public boolean SlowMode = false;


    public MecanumDrivetrain(Hardware hardware){




        this.frontLeftMotor = hardware.frontLeftMotor;
        this.frontRightMotor = hardware.frontRightMotor;
        this.backLeftMotor = hardware.backLeftMotor;
        this.backRightMotor = hardware.backRightMotor;

        this.imu = hardware.imu;

        resetHeading();
        setSlowMode(false);
        setBrakeMode(true);

    }

    public void robotCentricDrive(double x, double y, double turn) {


        MotorPowers motorPowers = MecanumDrivetrainUtils.robotCentricPowers(x, y, turn);
        motorPowers.multiply(powerScale);

        setMotorPowers(
                motorPowers
        );
    }

    public void fieldCentricDrive(double x, double y, double turn) {

        double heading = imu.getRobotYawPitchRollAngles()
                .getYaw(AngleUnit.RADIANS);
        MotorPowers motorPowers = MecanumDrivetrainUtils.fieldCentricPowers(x, y, turn, heading);
        motorPowers.multiply(powerScale);

        setMotorPowers(
                motorPowers
        );
    }



    public void resetHeading() {
        if (imu == null) return;
        imu.resetYaw();
    }

    public void setSlowMode(boolean slowMode){
        if (slowMode) setPowerScale(MotorConstants.SLOW_MODE_POWER_SCALE);
        else setPowerScale(MotorConstants.NORMAL_MODE_POWER_SCALE);
    }

    public void stop() {
        setMotorPowers(new MotorPowers(0, 0, 0, 0));
    }

    public void setPowerScale(double power) {
        powerScale = power;
    }



    public void setMotorPowers(
            MotorPowers motorPowers) {


        frontLeftMotor.setPower(motorPowers.frontLeft);
        frontRightMotor.setPower(motorPowers.frontRight);
        backLeftMotor.setPower(motorPowers.backLeft);
        backRightMotor.setPower(motorPowers.backRight);
    }


    public void setBrakeMode(boolean brake) {
        DcMotor.ZeroPowerBehavior behavior =
                brake
                        ? DcMotor.ZeroPowerBehavior.BRAKE
                        : DcMotor.ZeroPowerBehavior.FLOAT;

        frontLeftMotor.setZeroPowerBehavior(behavior);
        frontRightMotor.setZeroPowerBehavior(behavior);
        backLeftMotor.setZeroPowerBehavior(behavior);
        backRightMotor.setZeroPowerBehavior(behavior);
    }




}
