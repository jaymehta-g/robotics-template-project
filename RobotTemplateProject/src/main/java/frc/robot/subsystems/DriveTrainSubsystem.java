package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.commands.DriveTrainCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrainSubsystem extends SubsystemBase{
    private final WPI_VictorSPX FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT;
    private final DifferentialDrive DIFFERENTIAL_DRIVE;
    public DriveTrainSubsystem() {
        FRONT_LEFT  = new WPI_VictorSPX(Constants.DRIVE_TRAIN_FRONT_LEFT);
        FRONT_RIGHT = new WPI_VictorSPX(Constants.DRIVE_TRAIN_FRONT_RIGHT);
        BACK_LEFT   = new WPI_VictorSPX(Constants.DRIVE_TRAIN_BACK_LEFT);
        BACK_RIGHT  = new WPI_VictorSPX(Constants.DRIVE_TRAIN_BACK_RIGHT);

        FRONT_LEFT  .setNeutralMode(NeutralMode.Brake);
        FRONT_RIGHT .setNeutralMode(NeutralMode.Brake);
        BACK_LEFT   .setNeutralMode(NeutralMode.Brake);
        BACK_RIGHT  .setNeutralMode(NeutralMode.Brake);

        BACK_LEFT.follow(FRONT_LEFT);
        BACK_RIGHT.follow(FRONT_RIGHT);

        DIFFERENTIAL_DRIVE = new DifferentialDrive(FRONT_LEFT,FRONT_RIGHT);
    }
    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {
        
    }
    public void stop() {
        FRONT_LEFT  .set(0);
        FRONT_RIGHT .set(0);
        BACK_LEFT   .set(0);
        BACK_RIGHT  .set(0);
    }
    public void arcadeDrive(double s, double r) {
        DIFFERENTIAL_DRIVE.arcadeDrive(s, r);
    }

    //TODO fix this
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainCommand(this, null));
    }
}
