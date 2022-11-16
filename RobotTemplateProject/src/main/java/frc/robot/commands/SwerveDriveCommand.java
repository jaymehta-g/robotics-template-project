// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class SwerveDriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSystem m_subsystem;
    private final OI oi;
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public SwerveDriveCommand(DriveTrainSystem subsystem) {
        m_subsystem = subsystem;
        oi = new OI();
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_subsystem.stop();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double rawX=oi.getAxis(1, Constants.Axes.LEFT_STICK_X);
        double rawY=oi.getAxis(1, Constants.Axes.LEFT_STICK_Y);

        double angle = Math.atan2(rawY, rawX);
        double speed = Math.min(1, Math.sqrt(rawX*rawX+rawY*rawY));

        m_subsystem.setAllModules(angle,speed);

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
