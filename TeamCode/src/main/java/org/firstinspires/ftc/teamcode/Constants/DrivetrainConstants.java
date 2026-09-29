package org.firstinspires.ftc.teamcode.Constants;

import com.acmerobotics.dashboard.config.Config;

@Config // Allows tuning via FTC Dashboard if used
public class DrivetrainConstants {
    public static final double SLOW_MODE_POWER_SCALE = 0.4;
    public static final double NORMAL_MODE_POWER_SCALE = 1;

    public enum DriveType {
        FieldCentric,
        RobotCentric
    }

    public static final DriveType currentDriveType = DriveType.RobotCentric;
}











































