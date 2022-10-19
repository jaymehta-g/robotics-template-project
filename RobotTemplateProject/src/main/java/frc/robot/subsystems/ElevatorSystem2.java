package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSystem2 extends SubsystemBase {
    private final WPI_VictorSPX motor;
    private final PIDController pid;
    private final CANCoder encoder;
    public ElevatorSystem2() {
        motor = new WPI_VictorSPX(13);
        motor.configFactoryDefault();
        motor.setNeutralMode(NeutralMode.Brake);
        encoder = new CANCoder(14);
        pid = new PIDController(0.01, 0, 0);
        
    }

    public void setPosition(double pos) {
        pid.setSetpoint(pos);
    }

    @Override
    public void periodic() {
        double voltage = pid.calculate(encoder.getPosition());
        motor.set(voltage);

    }
}
