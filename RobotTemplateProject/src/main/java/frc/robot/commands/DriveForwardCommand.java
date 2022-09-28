package frc.robot.commands;
import frc.robot.subsystems.DriveTrainSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
public class DriveForwardCommand extends CommandBase {

    private final DriveTrainSystem driveTrainSubsystem;
    double startTime = 0;
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
 