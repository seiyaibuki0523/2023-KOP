package frc.robot;

public final class Constants {
    public static class Operator {
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }

    public static final class Drive {
        public static final double SPEED_COEFFICIENT = 0.3; // 0 < kSpeed <= 1
    }

    public static final class Auto{
        public static final double speed = 1.0;
        public static final double P = 0.25;
        public static final double I = 5;
        public static final double D = 0.2;
    }
}
