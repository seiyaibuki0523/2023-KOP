// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ControlCmd;
import frc.robot.commands.DriveJoystickCmd;
import frc.robot.commands.ahrsCmd;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.NEOMotorSubsysteam;

public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final ChassisSubsystem CIMSubsystem = new ChassisSubsystem();
    private final NEOMotorSubsysteam NEOSubsysteam = new NEOMotorSubsysteam();

    //** Replace with CommandPS4Controller or CommandJoystick if neede
    private final GamepadJoystick driverJoystick1 = new GamepadJoystick(0);
    private final GamepadJoystick driverJoystick2 = new GamepadJoystick(1);
    private final ControlCmd controlCmd = new ControlCmd();
    private final ahrsCmd ahrsCmd = new ahrsCmd();

    public RobotContainer() {
        // Configure the trigger bindings
        CIMSubsystem.setDefaultCommand(new DriveJoystickCmd(CIMSubsystem, () -> driverJoystick1.getRightX(), () -> driverJoystick1.getLeftY()));


        configureBindings();
    }

    private void configureBindings() {
        new Trigger(this.driverJoystick2::getRightBumper).whileTrue(controlCmd.NeoQuadrupleRod(0.5));
        new Trigger(this.driverJoystick2::getLeftBumper).whileTrue(controlCmd.NeoQuadrupleRod(-0.5));
        new Trigger(this.driverJoystick2::getXButtonPressed).whileTrue(controlCmd.NeoIntake(0.5));
        new Trigger(this.driverJoystick2::getBButtonPressed).whileTrue(controlCmd.NeoIntake(-0.5));
        new Trigger(this.driverJoystick2::getYButtonPressed).whileTrue(controlCmd.NeoElevator(0.5));
        new Trigger(this.driverJoystick2::getAButtonPressed).whileTrue(controlCmd.NeoElevator(-0.5));

    }

    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.CIMSubsystem.move(0.6, 0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCmd.NeoQuadrupleRod(-0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCmd.NeoIntake(-0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.controlCmd.NeoQuadrupleRod(0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1)
                ),
                new ParallelRaceGroup(
                        Commands.runEnd(() -> this.CIMSubsystem.move(0.6, 0.6),
                                this.CIMSubsystem::stopModules, this.CIMSubsystem),
                        new WaitCommand(1)
                ),
                new ahrsCmd()
        );
    }
}
