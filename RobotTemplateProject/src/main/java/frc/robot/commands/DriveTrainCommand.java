package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSubsystem;

import frc.robot.Constants.Axes;
import frc.robot.Constants.Buttons;

public class DriveTrainCommand extends CommandBase {
    private final DriveTrainSubsystem m_subsystem;
    private final OI m_oi;
    public DriveTrainCommand(DriveTrainSubsystem sub, OI oi) {
        m_subsystem = sub;
        addRequirements(m_subsystem);

        m_oi=oi;
    }
    @Override
    public void initialize() {
        m_subsystem.stop();
    }
    @Override
    public void execute() {
        m_subsystem.arcadeDrive(m_oi.getAxis(0, Axes.LEFT_STICK_Y), m_oi.getAxis(0, Axes.LEFT_STICK_X));
    }
    @Override
    public void end(boolean interrupted) {
        m_subsystem.stop();
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
