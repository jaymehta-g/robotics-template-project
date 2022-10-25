package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrainSubsystem extends SubsystemBase{
    public static final WPI_VictorSPX FRONT_LEFT; 
    public static final WPI_VictorSPX FRONT_RIGHT;
    public static final WPI_VictorSPX BACK_LEFT; 
    public static final WPI_VictorSPX BACK_RIGHT;
    public DriveTrainSubsystem() {
        FRONT_LEFT = new WPI_VictorSPX(Constants.DRIVE_TRAIN_FRONT_LEFT);
    }
}