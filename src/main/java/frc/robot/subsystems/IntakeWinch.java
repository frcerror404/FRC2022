package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IntakeWinch extends SubsystemBase {
    
    private final WPI_TalonSRX Winch = new WPI_TalonSRX(Constants.KIntakeWinch);

    public IntakeWinch() {

    }

    public void setWinchSpeed(double WinchSpeed) {
        Winch.set(WinchSpeed);
    }
}
