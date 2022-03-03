package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IntakeWinch extends SubsystemBase {
    
    private final WPI_TalonFX Winch = new WPI_TalonFX(Constants.KIntakeWinch);

    public IntakeWinch() {
        Winch.setNeutralMode(NeutralMode.Brake);
        Winch.overrideLimitSwitchesEnable(false);
        Winch.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
        Winch.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
    }

    public void setWinchSpeed(double WinchSpeed) {
        Winch.set(WinchSpeed);

        //System.out.println(String.format("Limit Switches %b %b", Winch.isFwdLimitSwitchClosed(), Winch.isRevLimitSwitchClosed() ));
    }
}
