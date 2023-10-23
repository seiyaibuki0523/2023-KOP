package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChassisSubsystem;

public class BalanceRobotCommand extends CommandBase {
    private final ChassisSubsystem chassisSubsystem;
    private boolean isFinished = false;

    public BalanceRobotCommand(ChassisSubsystem chassisSubsystem) {
        this.chassisSubsystem = chassisSubsystem;
    }

    @Override
    public void initialize() {
        this.chassisSubsystem.stopModules();
    }

    @Override
    public void execute() {
        double pitch = this.chassisSubsystem.getPitch();

        if (pitch > 45.0) {
            this.chassisSubsystem.move(0.1, 0.1);
        } else if (pitch < -45.0) {
            this.chassisSubsystem.move(-0.1, -0.1);
        } else if (Math.abs(pitch) < 1.0) {
            this.chassisSubsystem.move(1.0, -1.0);
            this.isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override
    public void end(boolean interrupted) {
        this.chassisSubsystem.stopModules();
    }
}
