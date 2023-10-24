package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import frc.robot.module.TalonSrxModule;

public class TalonSrxSubsystem extends SubsystemBase {

    public static TalonSrxModule inTake;

    public TalonSrxSubsystem() {
        inTake = new TalonSrxModule(RobotMap.MotorPort.INTAKE_MOTOR, false);
    }

    public void stop(double speed) {
        inTake.setDesiredState(0.0);
    }
}

