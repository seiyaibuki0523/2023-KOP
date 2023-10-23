package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.RobotMap;
import frc.robot.subsystems.NEOMotorModule;

public class ControlCommand extends CommandBase {
    private final NEOMotorModule neoMotorIntake;
    private final NEOMotorModule neoMotorQuadrupleRodA;
    private final NEOMotorModule neoMotorQuadrupleRodB;
    private final NEOMotorModule neoMotorElevatorA;
    private final NEOMotorModule neoMotorElevatorB;


    public ControlCommand() {
        this.neoMotorIntake = new NEOMotorModule(RobotMap.MotorPort.INTAKE_MOTOR, false);
        this.neoMotorQuadrupleRodA = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_A, false);
        this.neoMotorQuadrupleRodB = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_B, false);
        this.neoMotorElevatorA = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_A, false);
        this.neoMotorElevatorB = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_B, false);
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
