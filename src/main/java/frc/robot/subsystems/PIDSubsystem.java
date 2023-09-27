package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;


public class PIDSubsystem extends edu.wpi.first.wpilibj2.command.PIDSubsystem {

    private final static PIDSubsystem a = new PIDSubsystem();

    public static PIDSubsystem getInstance() {
        return a;
    }

    private PIDSubsystem() {
        super(new PIDController(1.0,1.0,1.0));
    }

    @Override
    public double getMeasurement() {
        return 0.0;
    }

    @Override
    protected void useOutput(double output, double setpoint) {
    }
}
