package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class NEOMotorModule {
    private CANSparkMax Motor;
    private double speed_input;

    public NEOMotorModule(int Motor_Port, boolean reverse) {

        Motor = new CANSparkMax(Motor_Port, MotorType.kBrushless);
        Motor.setSmartCurrentLimit(30);

        // kBrake
        // kCoast
        Motor.setIdleMode(IdleMode.kBrake);
        Motor.setInverted(reverse);

    }
    public void setDesiredState(Double speed){
        this.speed_input = speed * Constants.DriveConstants.kSpeed;
        Motor.set(this.speed_input);
        SmartDashboard.putNumber("Speed: ",this.speed_input);

    }
public void stop() {
        Motor.set(0);
}
}

