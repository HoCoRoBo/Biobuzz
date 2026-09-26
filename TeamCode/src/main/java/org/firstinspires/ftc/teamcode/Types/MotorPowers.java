package org.firstinspires.ftc.teamcode.Types;

public class MotorPowers {

    public double frontLeft;
    public double frontRight;
    public double backLeft;
    public double backRight;

    public MotorPowers(
            double frontLeft,
            double frontRight,
            double backLeft,
            double backRight) {

        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    public void multiply(double value){

        frontLeft *= value;
        frontRight *= value;
        backLeft *= value;
        backRight *= value;
    }

    public void normalize() {

        double max = Math.max(
                1.0,
                Math.max(
                        Math.abs(frontLeft),
                        Math.max(
                                Math.abs(frontRight),
                                Math.max(
                                        Math.abs(backLeft),
                                        Math.abs(backRight)
                                )
                        )
                )
        );

        multiply(1/max);
    }
}

