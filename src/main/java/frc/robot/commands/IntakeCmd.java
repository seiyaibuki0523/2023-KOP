package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NEOMotorSubsysteam;

public class IntakeCmd extends CommandBase {
    public double speed;
    private static NEOMotorSubsysteam motorSubsysteam;
    public IntakeCmd(NEOMotorSubsysteam subsysteam, double speed) {
        this.speed = speed;
        motorSubsysteam = subsysteam;
        addRequirements(motorSubsysteam);
    }


    @Override
    public void initialize() {

    }


    @Override
    public void execute() {
        motorSubsysteam.intakeMove(this.speed);
    }

    @Override
    public boolean isFinished() {

        return false;
    }


    @Override
    public void end(boolean interrupted) {
        motorSubsysteam.stop();
    }
}
