package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.CIMMotorModule;
import frc.robot.robotMap;

public class CIMMotorSubSystem extends SubsystemBase {

    private static CIMMotorModule L_Motor1;
    private static CIMMotorModule L_Motor2;
    private static CIMMotorModule R_Motor1;
    private static CIMMotorModule R_Motor2;

    public CIMMotorSubSystem() {
        L_Motor1 = new CIMMotorModule(robotMap.DrivePort.L_MotorPort1,
                false); //PWM1
        L_Motor2 = new CIMMotorModule(robotMap.DrivePort.L_MotorPort2,
                false); //PWM2
        R_Motor1 = new CIMMotorModule(robotMap.DrivePort.R_MotorPort1,
                false); //PWM3
        R_Motor2 = new CIMMotorModule(robotMap.DrivePort.R_MotorPort2,
                false); //PWM4
    }



    public void move(Double L_Speed,Double R_Speed) {
        L_Motor1.setDesiredState(L_Speed);
        L_Motor2.setDesiredState(L_Speed);
        R_Motor1.setDesiredState(R_Speed);
        R_Motor2.setDesiredState(R_Speed);
    }

    public void stopModules() {
        L_Motor1.stop();
        L_Motor2.stop();
        R_Motor1.stop();
        R_Motor2.stop();
    }
}