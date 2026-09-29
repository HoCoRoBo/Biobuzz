package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotTelemetry {

    private final Telemetry telemetry;

    public RobotTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void add(String caption, Object value) {
        telemetry.addData(caption, value);
    }

    public void update() {
        telemetry.update();
    }
}