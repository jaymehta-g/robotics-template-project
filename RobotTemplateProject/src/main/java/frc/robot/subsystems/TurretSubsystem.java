package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {
    private final WPI_VictorSPX shooter, turret, shroud;
    private final PIDController turretPid;
    private final PIDController shroudPid;
    public TurretSubsystem() {
        shooter = new WPI_VictorSPX(0);
        turret= new WPI_VictorSPX(1);
        shroud= new WPI_VictorSPX(2);
        turretPid = new PIDController(0.01, 0.01, 0.01);
        shroudPid = new PIDController(0.01, 0.01, 0.01);

        for (var m : new WPI_VictorSPX[]{shooter,turret,shroud}) {
            m.configFactoryDefault();
            m.setNeutralMode(NeutralMode.Brake);
        }
    }

    
}