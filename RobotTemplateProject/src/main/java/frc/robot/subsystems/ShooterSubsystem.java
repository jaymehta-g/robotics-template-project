
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  //4 motors
  //neutral mode is brake
  private final WPI_VictorSPX TOP_MOTOR = new WPI_VictorSPX(9);
  private final WPI_VictorSPX BOTTOM_MOTOR = new WPI_VictorSPX(10);
  private final WPI_VictorSPX LEFT_MOTOR = new WPI_VictorSPX(11);
  private final WPI_VictorSPX RIGHT_MOTOR = new WPI_VictorSPX(12);

  public ShooterSubsystem() {
    //default and set neutral mode to brake for all of them
    for (WPI_VictorSPX motor : new WPI_VictorSPX[] {TOP_MOTOR,BOTTOM_MOTOR,LEFT_MOTOR,RIGHT_MOTOR}) {
      motor.configFactoryDefault();
      motor.setNeutralMode(NeutralMode.Brake);
    }
  }

  public void setMotors(double speed) {
    //top, left set to speed
    //down, right set to -speed
    TOP_MOTOR.set(speed);
    LEFT_MOTOR.set(speed);
    BOTTOM_MOTOR.set(-speed);
    RIGHT_MOTOR.set(-speed);
  }

  public void stop() {
    setMotors(0);
  }
  
}
