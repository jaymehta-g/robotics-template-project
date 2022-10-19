package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterOnCommand extends CommandBase {
    final ShooterSubsystem shooterSubsystem;
    private final OI oi;
    public ShooterOnCommand(ShooterSubsystem shooterSubsystem, OI oi) {
        this.oi=oi;
        this.shooterSubsystem=shooterSubsystem;
        addRequirements(shooterSubsystem);
    }
    @Override
    public void initialize() {
        shooterSubsystem.stop();
    }

    @Override
    public void execute() {
        shooterSubsystem.setMotors(Math.abs (oi.getAxis(1, Constants.Axes.LEFT_STICK_X)) );
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
