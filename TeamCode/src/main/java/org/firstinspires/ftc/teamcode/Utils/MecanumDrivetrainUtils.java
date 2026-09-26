package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.teamcode.Types.MotorPowers;

public class MecanumDrivetrainUtils {

    public static MotorPowers robotCentricPowers(double x, double y, double turn){
        MotorPowers motorPowers = new MotorPowers(
                y + x + turn,
                y - x - turn,
                y - x + turn,
                y + x - turn
        );

        motorPowers.normalize();
        return motorPowers;
    }

    public static MotorPowers fieldCentricPowers(double x, double y, double turn, double heading){
        double rotatedX = x * Math.cos(-heading) - y * Math.sin(-heading);
        double rotatedY = x * Math.sin(-heading) + y * Math.cos(-heading);

        MotorPowers motorPowers = new MotorPowers(

                rotatedY + rotatedX + turn,
                rotatedY - rotatedX - turn,
                rotatedY - rotatedX + turn,
                rotatedY + rotatedX - turn


        );

        motorPowers.normalize();
        return motorPowers;
    }


}
