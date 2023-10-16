package frc.robot.commands;

import frc.robot.subsystems.ChassisSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Autos extends CommandBase {

    private final ChassisSubsystem AutoSubsystem;

    public Autos(ChassisSubsystem subsystem){
        AutoSubsystem = subsystem;
        addRequirements(AutoSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        AutoSubsystem.move(0.6, 0.6);
    }

    @Override
    public void end(boolean interrupted) {
        this.AutoSubsystem.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}