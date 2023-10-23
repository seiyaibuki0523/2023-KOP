package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChassisSubsystem;

public class DriveJoystickCommand extends CommandBase{
    private final ChassisSubsystem chassisSubsystem;
    private final Supplier<Double> turnFunction, speedFunction;


    public DriveJoystickCommand(ChassisSubsystem subsystem, Supplier<Double> turnFunction,
                                Supplier<Double> speedFunction) {
        this.chassisSubsystem = subsystem;
        this.turnFunction = turnFunction;
        this.speedFunction = speedFunction;
        this.addRequirements(this.chassisSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        // 1. Get real-time joystick inputs
        double Speed = this.turnFunction.get();
        double Speed2 = -this.speedFunction.get();
        double L_Speed = Speed + Speed2;
        double R_Speed = Speed - Speed2;
        this.chassisSubsystem.move(L_Speed, R_Speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.chassisSubsystem.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
