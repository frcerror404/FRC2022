package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class FrontClimber extends SubsystemBase {
    private final WPI_TalonFX ClimberFL = new WPI_TalonFX(Constants.kClimberFL);
    private final WPI_TalonFX ClimberFR = new WPI_TalonFX(Constants.kClimberFR);


    public FrontClimber() {
        //ClimberA.setInverted(true);
        ClimberFL.setNeutralMode(NeutralMode.Brake);
        ClimberFL.configOpenloopRamp(.25);
        ClimberFR.follow(ClimberFL);
        ClimberFR.configOpenloopRamp(.25);
        ClimberFR.setInverted(TalonFXInvertType.OpposeMaster);
        ClimberFR.setNeutralMode(NeutralMode.Brake);

    }

    public void setClimberSpeed(double climberSpeed) {
        ClimberFL.set(climberSpeed);
    }
}
