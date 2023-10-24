package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import frc.robot.module.NEOMotorModule;

public class NEOMotorSubsysteam extends SubsystemBase {
    private final NEOMotorModule NEOMotorIntake;
    private final NEOMotorModule NEOMotorArm;

    public NEOMotorSubsysteam() {
        this.NEOMotorIntake = new NEOMotorModule(RobotMap.MotorPort.INTAKE_MOTOR, false);
        this.NEOMotorArm = new NEOMotorModule(RobotMap.MotorPort.INTAKE_MOTOR, false);

    }



    public void ArmMove(double speed) {
        this.NEOMotorArm.setDesiredState(speed);
    }



    public void stop() {
        this.NEOMotorIntake.stop();
        this.NEOMotorArm.stop();
    }
}

