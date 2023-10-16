package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DifferentialDriveMotorGroup {
    private final VictorSPX motorA;
    private final VictorSPX motorB;

    public DifferentialDriveMotorGroup(int motorPortA, int motorPortB, boolean isInvertedA, boolean isInvertedB) {
        this.motorA = new VictorSPX(motorPortA);
        this.motorA.setInverted(isInvertedA);
        this.motorB = new VictorSPX(motorPortB);
        this.motorB.setInverted(isInvertedB);
    }

    public void setDesiredState(double speed) {
        double speedOutput = speed * Constants.Drive.SPEED_COEFFICIENT;
        this.motorA.set(ControlMode.PercentOutput, speedOutput);
        this.motorB.set(ControlMode.PercentOutput, speedOutput);
        SmartDashboard.putNumber("Speed: ", speedOutput);
    }

    public void stop() {
        this.motorA.set(ControlMode.PercentOutput, 0.0);
        this.motorB.set(ControlMode.PercentOutput, 0.0);
    }
}