package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.NEOMotorModule;


public class ControlCmd extends CommandBase {

    private final NEOMotorModule neoMotorIntake;
    private final NEOMotorModule neoMotorQuadrupleRodA;
    private final NEOMotorModule neoMotorQuadrupleRodB;
    private final NEOMotorModule neoMotorElevatorA;
    private final NEOMotorModule neoMotorElevatorB;


    public ControlCmd() {
        this.neoMotorIntake = new NEOMotorModule(RobotMap.DrivePort.INTAKE_MOTOR, false);
        this.neoMotorQuadrupleRodA = new NEOMotorModule(RobotMap.DrivePort.QUADRUPLE_ROD_A, false);
        this.neoMotorQuadrupleRodB = new NEOMotorModule(RobotMap.DrivePort.QUADRUPLE_ROD_B, false);
        this.neoMotorElevatorA = new NEOMotorModule(RobotMap.DrivePort.ELEVATOR_A, false);
        this.neoMotorElevatorB = new NEOMotorModule(RobotMap.DrivePort.ELEVATOR_B, false);

    }

    public Command NeoQuadrupleRod(double speed) {
        this.neoMotorQuadrupleRodA.setDesiredState(speed);
        this.neoMotorQuadrupleRodB.setDesiredState(speed);
        return null;
    }


    public Command NeoElevator(double speed) {
        this.neoMotorElevatorA.setDesiredState(speed);
        this.neoMotorElevatorB.setDesiredState(speed);
        return null;
    }

    public Command NeoIntake(double speed) {
        this.neoMotorIntake.setDesiredState(speed);
        return null;
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

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
