package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SerialPort;

public class ChassisSubsystem extends SubsystemBase {
    private final DifferentialDriveMotorGroup leftMotorGroup;
    private final DifferentialDriveMotorGroup rightMotorGroup;

    public ChassisSubsystem() {
        this.leftMotorGroup = new DifferentialDriveMotorGroup(
                RobotMap.DrivePort.LEFT_MOTOR_A,
                RobotMap.DrivePort.LEFT_MOTOR_B,
                false, false
        );

        this.rightMotorGroup = new DifferentialDriveMotorGroup(
                RobotMap.DrivePort.RIGHT_MOTOR_A,
                RobotMap.DrivePort.RIGHT_MOTOR_B,
                false, false
        );
    }

    public void move(double leftSpeed, double rightSpeed) {
        this.leftMotorGroup.setDesiredState(leftSpeed);
        this.rightMotorGroup.setDesiredState(rightSpeed);
    }
    public void autoMove(double seconds,double leftSpeed, double rightSpeed) {
        this.leftMotorGroup.setDesiredState(seconds*leftSpeed);
        this.rightMotorGroup.setDesiredState(seconds*rightSpeed);
    }

    public void stopModules() {
        this.leftMotorGroup.stop();
        this.rightMotorGroup.stop();
    }
}