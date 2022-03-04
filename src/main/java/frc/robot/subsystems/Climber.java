package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Climber extends SubsystemBase {
    private final WPI_TalonFX ClimberA = new WPI_TalonFX(Constants.kClimberFL);
    private final WPI_TalonFX ClimberB = new WPI_TalonFX(Constants.kClimberFR);


    public Climber() {
        //ClimberA.setInverted(true);
        ClimberB.follow(ClimberA);
        //ClimberB.setInverted(TalonFXInvertType.OpposeMaster);

    }

    public void setClimberSpeed(double climberSpeed) {
        ClimberA.set(climberSpeed);
    }
}
