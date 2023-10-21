package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class NEOMotorSubsysteam extends SubsystemBase {
    private final NEOMotorModule NEOMotorIntake;
    private final NEOMotorModule NEOMotorArm;
    private final NEOMotorModule neoMotorQuadrupleRodA;
    private final NEOMotorModule neoMotorQuadrupleRodB;
    private final NEOMotorModule neoMotorElevatorA;
    private final NEOMotorModule neoMotorElevatorB;

    public NEOMotorSubsysteam() {
        this.NEOMotorIntake = new NEOMotorModule(RobotMap.DrivePort.INTAKE_MOTOR, false);
        this.NEOMotorArm = new NEOMotorModule(RobotMap.DrivePort.INTAKE_MOTOR, false);
        this.neoMotorQuadrupleRodA = new NEOMotorModule(RobotMap.DrivePort.QUADRUPLE_ROD_A, false);
        this.neoMotorQuadrupleRodB = new NEOMotorModule(RobotMap.DrivePort.QUADRUPLE_ROD_B, false);
        this.neoMotorElevatorA = new NEOMotorModule(RobotMap.DrivePort.ELEVATOR_A, false);
        this.neoMotorElevatorB = new NEOMotorModule(RobotMap.DrivePort.ELEVATOR_B, false);

    }

    public void intakeMove(double speed) {
        this.NEOMotorIntake.setDesiredState(speed);
    }

    public void ArmMove(double speed) {
        this.NEOMotorArm.setDesiredState(speed);
    }

    public void NeoQuadrupleRodAhead(){
        this.neoMotorQuadrupleRodA.setDesiredState(0.5);
        this.neoMotorQuadrupleRodB.setDesiredState(0.5);
    }

    public void NeoQuadrupleRodBack(){
        this.neoMotorQuadrupleRodA.setDesiredState(-e0.5);
        this.neoMotorQuadrupleRodB.setDesiredState(-0.5);
    }

    public void NeoElevatorUp(){
        this.neoMotorElevatorA.setDesiredState(0.5);
        this.neoMotorElevatorB.setDesiredState(0.5);
    }

    public void NeoElevatorDown(){
        this.neoMotorElevatorA.setDesiredState(-0.5);
        this.neoMotorElevatorB.setDesiredState(-0.5);
    }

    public void stop() {
        this.NEOMotorIntake.stop();
        this.NEOMotorArm.stop();
    }
}

