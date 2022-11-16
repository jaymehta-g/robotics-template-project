// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModuleSubsystem extends SubsystemBase {
    final double tau = Math.PI*2;
    boolean shouldReverseSpeed = false;
    private final WPI_VictorSPX rotationMotor, driveMotor;
        private final PIDController pid;
        public final CANCoder encoder;

        
        public SwerveModuleSubsystem() {
        rotationMotor = new WPI_VictorSPX    (Constants.driveTrainFrontLeftMotor);
        driveMotor = new WPI_VictorSPX       (Constants.driveTrainBackLeftMotor);

        driveMotor.setNeutralMode(NeutralMode.Brake);
        rotationMotor.setNeutralMode(NeutralMode.Brake);

        encoder = new CANCoder(12345);

        pid = new PIDController(.01, .01, .01);

    }
    @Override
    public void periodic() {
        double rawAngle = encoder.getPosition();
        double tau = Math.PI*2;
        double angle = (rawAngle%tau+tau) % tau;
        double voltage = pid.calculate(angle);
        rotationMotor.set(voltage);
    }

    public void setDirection(double angle) {
        pid.setSetpoint(correctAngle(angle, encoder.getPosition()));
    }
    public void setWheelSpeed(double speed) {
        driveMotor.set(speed);
    }
    private double correctAngle(double targetAngle, double currentAngle) {
        double a1 = targetAngle + tau;
        double a2 = targetAngle;
        double a3 = targetAngle - tau;
        double d1 = Math.abs(a1-currentAngle);
        double d2 = Math.abs(a2-currentAngle);
        double d3 = Math.abs(a3-currentAngle);
        var minDist = Math.min(Math.min(d1, d2), d3);
        if (minDist == d1)
            return a1;
        else if (minDist==d2)
            return a2;
        else
            return a3;
    }
    private double correctAngleOrOpposite(double targetAngle, double currentAngle) {
        double a1 = correctAngle(targetAngle, currentAngle);
        double a2 = correctAngle((targetAngle+Math.PI) % tau, currentAngle);
        double d1 = Math.abs(a1-currentAngle);
        double d2 = Math.abs(a2-currentAngle);
        var minDist = Math.min(d1, d2);
        double out = a2;
        if (minDist == d1) {
            out = a1;
            return out;
        }
        shouldReverseSpeed = true;
        return out;
        
    }
}
