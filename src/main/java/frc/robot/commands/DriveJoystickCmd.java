package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChassisSubsystem;


public class DriveJoystickCmd extends CommandBase{
    private final ChassisSubsystem MotorSubsystem;
    private final Supplier<Double> turnFunction, speedFunction;
    public DriveJoystickCmd(ChassisSubsystem subsystem, Supplier<Double> turnFunction, Supplier<Double> speedFunction) {
        this.MotorSubsystem = subsystem;
        this.turnFunction = turnFunction;
        this.speedFunction = speedFunction;
        this.addRequirements(this.MotorSubsystem);
    }
    @Override
    public void initialize() {}

    @Override
    public void execute() {
        // 1. Get real-time joystick inputs
        double Speed = turnFunction.get();
        double Speed2 = -speedFunction.get();
        double L_Speed = Speed + Speed2;
        double R_Speed = Speed - Speed2;
        MotorSubsystem.move(L_Speed,R_Speed);
    }

    @Override
    public void end(boolean interrupted) {
        MotorSubsystem.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
