package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class BackClimber extends SubsystemBase {
    private final WPI_TalonFX ClimberBL = new WPI_TalonFX(Constants.kClimberBL);
    private final WPI_TalonFX ClimberBR = new WPI_TalonFX(Constants.kClimberBR);


    public BackClimber() {
        //ClimberA.setInverted(true);
        ClimberBL.setNeutralMode(NeutralMode.Brake);
        ClimberBL.configOpenloopRamp(.25);
        ClimberBR.follow(ClimberBL);
        ClimberBR.configOpenloopRamp(.25);
        ClimberBR.setInverted(TalonFXInvertType.OpposeMaster);
        ClimberBR.setNeutralMode(NeutralMode.Brake);

    }

    public void setClimberSpeed(double climberSpeed) {
        ClimberBL.set(climberSpeed);
    }
}
