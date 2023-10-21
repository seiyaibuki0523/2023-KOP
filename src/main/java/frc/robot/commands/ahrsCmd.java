package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChassisSubsystem;


public class ahrsCmd extends CommandBase {
    ChassisSubsystem ahrsSubsysteam = new ChassisSubsystem();
    double pitch = ahrsSubsysteam.ahrs();

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        while (pitch < 45.0) {
            ahrsSubsysteam.move(0.3, 0.3);
        }
        while (pitch < -45.0) {
            ahrsSubsysteam.move(-0.3, -0.3);
        }
        while (pitch < 1.0 && pitch > 0.0) {
            ahrsSubsysteam.move(1, 0.5);
        }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
