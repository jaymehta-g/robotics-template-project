package frc.robot.commands;
import frc.robot.subsystems.DriveTrainSubsystem;
public class DriveForwardCommand {
    private final DriveTrainSubsystem driveTrainSubsystem;
    public DriveForwardCommand(DriveTrainSubsystem driveTrainSubsystem) {
        this.driveTrainSubsystem=driveTrainSubsystem;
        addRequirements(driveTrainSubsystem);
    }
}
