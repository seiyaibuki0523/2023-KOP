package frc.lib.controllers;

import edu.wpi.first.wpilibj.XboxController;

@SuppressWarnings("unused")
public class LogitechGamepad extends XboxController {
    public LogitechGamepad(final int port) {
        super(port);
    }

    public int getDPad() {
        return this.getPOV();
    }
}
