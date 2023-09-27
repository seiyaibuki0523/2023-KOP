package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class CIMMotorModule {
    private VictorSPX Motor;
    private double speed_input;

    public CIMMotorModule(int Motor_Port, boolean reverse) {
        Motor = new VictorSPX(Motor_Port);
        Motor.setInverted(reverse);

    }
    public void setDesiredState(Double speed) {
        this.speed_input = speed * Constants.DriveConstants.kSpeed;
        Motor.set(ControlMode.PercentOutput, this.speed_input);
        SmartDashboard.putNumber("Speed: ", this.speed_input);

    }

    public void stop() {
        Motor.set(ControlMode.PercentOutput, 0);
    }

}