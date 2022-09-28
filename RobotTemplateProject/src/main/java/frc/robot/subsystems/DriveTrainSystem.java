// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_VictorSPX frontLeft, frontRight, backLeft, backRight;
  private final DifferentialDrive differentialDrive;
  public DriveTrainSystem() {
    frontLeft = new WPI_VictorSPX(0);
    backLeft = new WPI_VictorSPX(1);
    frontRight = new WPI_VictorSPX(2);
    backRight = new WPI_VictorSPX(3);
    frontLeft.configFactoryDefault();
    backLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    backRight.configFactoryDefault();

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);

    differentialDrive = new DifferentialDrive(frontLeft,frontRight);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void stop() {
    frontLeft.set(0);
    backLeft.set(0);
    frontRight.set(0);
    backRight.set(0);
  }
  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }
}
