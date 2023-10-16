package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;


public class NEOMotorSubsysteam extends SubsystemBase {

    private static NEOMotorModule NEOMotorIntake;
    private static NEOMotorModule NEOMotorArm;

    public NEOMotorSubsysteam() {
        NEOMotorIntake = new NEOMotorModule(RobotMap.DrivePort.INTAKE_MOTOR,false);
        NEOMotorArm = new NEOMotorModule(RobotMap.DrivePort.INTAKE_MOTOR,false);
    }
    public void intakeMove(Double speed) {
        NEOMotorIntake.setDesiredState(speed);
    }
    public void ArmMove(Double speed){
        NEOMotorArm.setDesiredState(speed);
    }
    public void stop(){
        NEOMotorIntake.stop();
        NEOMotorArm.stop();
    }
}

