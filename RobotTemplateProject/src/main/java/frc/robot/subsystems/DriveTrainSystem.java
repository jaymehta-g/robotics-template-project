// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    private final SwerveModuleSubsystem s1,s2,s3,s4;
    private final SwerveModuleSubsystem[] modules;
    public DriveTrainSystem() {
        s1 = new SwerveModuleSubsystem();
        s2 = new SwerveModuleSubsystem();
        s3 = new SwerveModuleSubsystem();
        s4 = new SwerveModuleSubsystem();
        modules = new SwerveModuleSubsystem[] {s1,s2,s3,s4};
        
        // frontLeft.setNeutralMode(NeutralMode.Brake);
        // backLeft.setNeutralMode(NeutralMode.Brake);
        // frontRight.setNeutralMode(NeutralMode.Brake);
        // backRight.setNeutralMode(NeutralMode.Brake);

        // differentialDrive = new DifferentialDrive(frontLeft,frontRight);


    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    
    public void stop() {
        for (SwerveModuleSubsystem swerveModuleSubsystem : modules) {
            swerveModuleSubsystem.setWheelSpeed(0);
        }
    }
    public void setAllModules(double angle, double speed) {
        for (SwerveModuleSubsystem swerveModuleSubsystem : modules) {
            swerveModuleSubsystem.setWheelSpeed(speed);
            swerveModuleSubsystem.setDirection(angle);
        }
    }
}
