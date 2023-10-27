package frc.robot;

import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.BalanceRobotCommand;
import frc.robot.commands.ControlCommand;
import frc.robot.commands.DriveJoystickCommand;
import frc.robot.subsystems.ChassisSubsystem;

public class RobotContainer {
    private final ChassisSubsystem CIMSubsystem = new ChassisSubsystem();
    private final GamepadJoystick driverJoystick1 = new GamepadJoystick(0);
    private final GamepadJoystick driverJoystick2 = new GamepadJoystick(1);
    private final ControlCommand controlCommand = new ControlCommand();


    public RobotContainer() {
        this.CIMSubsystem.setDefaultCommand(new DriveJoystickCommand(
                this.CIMSubsystem, this.driverJoystick1::getRightX, this.driverJoystick1::getLeftY)
        );

        this.configureBindings();
    }

    private void configureBindings() {
        new Trigger(this.driverJoystick2::getRightBumper).whileTrue(controlCommand.Arm(0.5));
        new Trigger(this.driverJoystick2::getLeftBumper).whileTrue(controlCommand.Arm(-0.5));
        new Trigger(this.driverJoystick2::getXButtonPressed).whileTrue(controlCommand.Intake(0.5));
        new Trigger(this.driverJoystick2::getBButtonPressed).whileTrue(controlCommand.Intake(-0.5));
        new Trigger(this.driverJoystick2::getYButtonPressed).whileTrue(controlCommand.NeoElevator(0.5));
        new Trigger(this.driverJoystick2::getAButtonPressed).whileTrue(controlCommand.NeoElevator(-0.5));
    }

    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.CIMSubsystem.move(0.6, 0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1.0)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCommand.Arm(-0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1.0)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCommand.Intake(-0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1.0)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCommand.Arm(0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1.0)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.CIMSubsystem.move(0.6, 0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1.0)
                ),
                new BalanceRobotCommand(this.CIMSubsystem)
        );
    }
}
