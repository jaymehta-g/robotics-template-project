package frc.robot.commands;
import frc.robot.subsystems.DriveTrainSystem;
public class DriveForwardCommand {
    private final DriveTrainSubsystem driveTrainSubsystem;
    public DriveForwardCommand(DriveTrainSystem
    public DriveForwardCommand(DriveTrainSystem driveTrainSubsystem) {
        this.driveTrainSubsystem=driveTrainSubsystem;
        startTime = Timer.getFPGATimestamp();
        addRequirements(driveTrainSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveTrainSubsystem.arcadeDrive(0d,0.5d);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrainSubsystem.stop();
    }    

    @Override
    public boolean isFinished() {
        double currentTime = Timer.getFPGATimestamp();
        return (startTime+.5) <= currentTime;
    }
}
 