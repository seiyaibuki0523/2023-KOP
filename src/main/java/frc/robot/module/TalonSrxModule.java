package frc.robot.module;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class TalonSrxModule {
    private final TalonSRX motorIntake;

    public TalonSrxModule(int Motor_port, boolean isInverted) {
        this.motorIntake = new TalonSRX(Motor_port);
        this.motorIntake.setInverted(isInverted);
    }

    public void setDesiredState(double speed) {
        double speedOutput = speed * Constants.Drive.SPEED_COEFFICIENT;
        this.motorIntake.set(ControlMode.PercentOutput, speedOutput);
        SmartDashboard.putNumber("Speed: ", speedOutput);
    }

    public void stop() {
        this.motorIntake.set(ControlMode.PercentOutput, 0.0);
    }
}
