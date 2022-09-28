package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSystem;

public class ElevatorUpCommand extends CommandBase {
    protected final ElevatorSystem elevatorSystem;
    public ElevatorUpCommand(ElevatorSystem elevatorSystem) {
        this.elevatorSystem=elevatorSystem;
        addRequirements(elevatorSystem);
    }

    @Override
    public void initialize() {
        elevatorSystem.stop();
    }

    @Override
    public void execute() {
        elevatorSystem.moveUp();
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSystem.stop();
    }

    @Override
    public boolean isFinished() {
        return elevatorSystem.atTop();
    }
}
