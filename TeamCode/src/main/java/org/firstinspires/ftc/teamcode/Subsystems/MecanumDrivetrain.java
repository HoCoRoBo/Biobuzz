package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants.MotorConstants;
import org.firstinspires.ftc.teamcode.Hardware;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;




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

    }

    public void mecanumDrive(double x, double y, double turn) {

        double frontLeft  = y + x + turn;
        double frontRight = y - x - turn;
        double backLeft   = y - x + turn;
        double backRight  = y + x - turn;

        double max = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turn), 1);

        frontLeft /= max;
        frontRight /= max;
        backLeft /= max;
        backRight /= max;

        frontLeft *= powerScale;
        frontRight *= powerScale;
        backLeft *= powerScale;
        backRight *= powerScale;


        setMotorPowers(
                frontLeft,
                frontRight,
                backLeft,
                backRight
        );
    }

    public void fieldCentricDrive(double x, double y, double turn) {

        double heading = imu.getRobotYawPitchRollAngles()
                .getYaw(AngleUnit.RADIANS);

        // Rotate joystick input by the robot's heading
        double rotatedX = x * Math.cos(-heading) - y * Math.sin(-heading);
        double rotatedY = x * Math.sin(-heading) + y * Math.cos(-heading);

        double frontLeft  = rotatedY + rotatedX + turn;
        double frontRight = rotatedY - rotatedX - turn;
        double backLeft   = rotatedY - rotatedX + turn;
        double backRight  = rotatedY + rotatedX - turn;


        double max = Math.max(Math.abs(rotatedY) + Math.abs(rotatedX) + Math.abs(turn), 1);

        frontLeft /= max;
        frontRight /= max;
        backLeft /= max;
        backRight /= max;

        frontLeft *= powerScale;
        frontRight *= powerScale;
        backLeft *= powerScale;
        backRight *= powerScale;

        setMotorPowers(
                frontLeft,
                frontRight,
                backLeft,
                backRight
        );
    }



    public void resetHeading() {
        imu.resetYaw();
    }

    public void setSlowMode(boolean slowMode){
        if (slowMode) setPowerScale(MotorConstants.SLOW_MODE_POWER_SCALE);
        else setPowerScale(MotorConstants.NORMAL_MODE_POWER_SCALE);
    }

    public void stop() {
        setMotorPowers(0, 0, 0, 0);
    }

    public void setPowerScale(double power) {
        powerScale = power;
    }



    public void setMotorPowers(
            double frontLeft,
            double frontRight,
            double backLeft,
            double backRight) {


        frontLeftMotor.setPower(frontLeft);
        frontRightMotor.setPower(frontRight);
        backLeftMotor.setPower(backLeft);
        backRightMotor.setPower(backRight);
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
