package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.SerialPort;
import frc.robot.module.DifferentialDriveMotorGroup;

public class ChassisSubsystem extends SubsystemBase {
    private final DifferentialDriveMotorGroup leftMotorGroup;
    private final DifferentialDriveMotorGroup rightMotorGroup;
    private final AHRS gyro = new AHRS(SerialPort.Port.kUSB);


    public ChassisSubsystem() {
        this.leftMotorGroup = new DifferentialDriveMotorGroup(
                RobotMap.MotorPort.LEFT_MOTOR_A,
                RobotMap.MotorPort.LEFT_MOTOR_B,
                false, false
        );

        this.rightMotorGroup = new DifferentialDriveMotorGroup(
                RobotMap.MotorPort.RIGHT_MOTOR_A,
                RobotMap.MotorPort.RIGHT_MOTOR_B,
                false, false
        );

        this.gyro.reset();
    }

    public void move(double leftSpeed, double rightSpeed) {
        this.leftMotorGroup.setDesiredState(leftSpeed);
        this.rightMotorGroup.setDesiredState(rightSpeed);
    }

    public void autoMove(double seconds, double leftSpeed, double rightSpeed) {
        this.leftMotorGroup.setDesiredState(seconds * leftSpeed);
        this.rightMotorGroup.setDesiredState(seconds * rightSpeed);
    }

    public void stopModules() {
        this.leftMotorGroup.stop();
        this.rightMotorGroup.stop();
    }

    public double getPitch() {
        return this.gyro.getPitch();
    }
}