package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class NEOMotorSubsysteam extends SubsystemBase {
    private final NEOMotorModule NEOMotorIntake;
    private final NEOMotorModule NEOMotorArm;
    private final NEOMotorModule neoMotorQuadrupleRodA;
    private final NEOMotorModule neoMotorQuadrupleRodB;
    private final NEOMotorModule neoMotorElevatorA;
    private final NEOMotorModule neoMotorElevatorB;

    public NEOMotorSubsysteam() {
        this.NEOMotorIntake = new NEOMotorModule(RobotMap.MotorPort.INTAKE_MOTOR, false);
        this.NEOMotorArm = new NEOMotorModule(RobotMap.MotorPort.INTAKE_MOTOR, false);
        this.neoMotorQuadrupleRodA = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_A, false);
        this.neoMotorQuadrupleRodB = new NEOMotorModule(RobotMap.MotorPort.QUADRUPLE_ROD_B, false);
        this.neoMotorElevatorA = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_A, false);
        this.neoMotorElevatorB = new NEOMotorModule(RobotMap.MotorPort.ELEVATOR_B, false);

    }

    public void intakeMove(double speed) {
        this.NEOMotorIntake.setDesiredState(speed);
    }

    public void ArmMove(double speed) {
        this.NEOMotorArm.setDesiredState(speed);
    }



    public void stop() {
        this.NEOMotorIntake.stop();
        this.NEOMotorArm.stop();
    }
}

