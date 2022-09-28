package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSystem;

public class ElevatorDownCommand extends ElevatorUpCommand {
    public ElevatorDownCommand(ElevatorSystem elevatorSystem) {
        super(elevatorSystem);
    }
    
    @Override
    public void execute() {
        elevatorSystem.moveDown();

    }

    @Override
    public boolean isFinished() {
        return elevatorSystem.atBottom();
    }
}
