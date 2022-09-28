package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSystem extends SubsystemBase{
    private WPI_VictorSPX leftMotor, rightMotor;
    private DigitalInput bottomLimitSwitch, topLimitSwitch;

    public ElevatorSystem() {
        leftMotor = new WPI_VictorSPX(Constants.elevatorLeftMotor);
        rightMotor = new WPI_VictorSPX(Constants.elevatorRightMotor);

        leftMotor.configFactoryDefault();
        rightMotor.configFactoryDefault();

        leftMotor.setNeutralMode(NeutralMode.Brake);
        leftMotor.setNeutralMode(NeutralMode.Brake);

        bottomLimitSwitch = new DigitalInput(Constants.elevatorBottomLimitSwitch);
        topLimitSwitch = new DigitalInput(Constants.elevatorTopLimitSwitch);
    }
    public void moveUp() {
        if (atTop()) return;
        leftMotor.set(1);
        rightMotor.set(1);
    }
    public void moveDown() {
        if (atBottom()) return;
        leftMotor.set(-1);
        rightMotor.set(-1);
    }
    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }
    public boolean atTop() { return topLimitSwitch.get(); }
    public boolean atBottom() { return bottomLimitSwitch.get(); }
}
