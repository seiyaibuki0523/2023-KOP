package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.RobotMap;
import frc.robot.module.NEOMotorModule;
import frc.robot.subsystems.TalonSrxSubsystem;

public class ControlCommand extends CommandBase {
    private final NEOMotorModule Arm;
    private final NEOMotorModule neoMotorQuadrupleRodB;
    private final NEOMotorModule neoMotorElevatorA;
    private final NEOMotorModule neoMotorElevatorB;


    public ControlCommand() {
        this.Arm = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_A, false);
        this.neoMotorQuadrupleRodB = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_B, false);
        this.neoMotorElevatorA = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_A, false);
        this.neoMotorElevatorB = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_B, false);
    }

    public Command Arm(double speed) {
        this.Arm.setDesiredState(speed);
        this.neoMotorQuadrupleRodB.setDesiredState(speed);
        return null;
    }

    public Command NeoElevator(double speed) {
        this.neoMotorElevatorA.setDesiredState(speed);
        this.neoMotorElevatorB.setDesiredState(speed);
        return null;
    }

    public Command Intake(double speed) {
        TalonSrxSubsystem.inTake.setDesiredState(speed);
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
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
