package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSystem;

public class ElevatorUpCommand extends CommandBase {
    private final ElevatorSystem elevatorSystem;
    public ElevatorUpCommand(ElevatorSystem elevatorSystem) {
        this.elevatorSystem=elevatorSystem;
    }

    @Override
    public void initialize() {
        elevatorSystem.moveUp();
    }

    @Override
    public void execute() {

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
