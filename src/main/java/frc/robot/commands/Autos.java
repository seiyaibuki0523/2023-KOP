package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;
import frc.robot.subsystems.ChassisSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import static frc.robot.Constants.Auto.speed;


public class Autos extends CommandBase {
    private final PIDController  controller= new PIDController(Constants.Auto.P, Constants.Auto.I, Constants.Auto.D);
    private final ChassisSubsystem AutoSubsystem;
    private static final Timer time = new Timer();
    private final double seconds;

    public Autos(ChassisSubsystem subsystem){
        this.AutoSubsystem = subsystem;
        this.seconds = Constants.Auto.speed;
        addRequirements(AutoSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        this.AutoSubsystem.autoMove(seconds,controller.calculate(time.get()),controller.calculate(time.get()));
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