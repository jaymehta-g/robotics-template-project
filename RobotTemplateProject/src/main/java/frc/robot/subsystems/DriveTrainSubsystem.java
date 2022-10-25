package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrainSubsystem extends SubsystemBase{
    private final WPI_VictorSPX FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT;
    private final DifferentialDrive DIFFERENTIAL_DRIVE;
    public DriveTrainSubsystem() {
        FRONT_LEFT  = new WPI_VictorSPX(Constants.DRIVE_TRAIN_FRONT_LEFT);
        FRONT_RIGHT = new WPI_VictorSPX(Constants.DRIVE_TRAIN_FRONT_RIGHT);
        BACK_LEFT   = new WPI_VictorSPX(Constants.DRIVE_TRAIN_BACK_LEFT);
        BACK_RIGHT  = new WPI_VictorSPX(Constants.DRIVE_TRAIN_BACK_RIGHT);
        BACK_LEFT.follow(FRONT_LEFT);
        BACK_RIGHT.follow(FRONT_RIGHT);
        DIFFERENTIAL_DRIVE = new DifferentialDrive(FRONT_LEFT,FRONT_RIGHT);
    }
    
}
