package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainCommand extends CommandBase {
    private final DriveTrainSubsystem m_subsystem;
    public DriveTrainCommand(DriveTrainSubsystem sub) {
        m_subsystem = sub;
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {

    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
