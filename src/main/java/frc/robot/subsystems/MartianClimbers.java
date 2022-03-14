// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.revrobotics.CANPIDController.AccelStrategy;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.lib.ReleaseType;

public class MartianClimbers extends SubsystemBase {
  private final WPI_TalonFX SwingR = new WPI_TalonFX(Constants.kSwingR);
  private final WPI_TalonFX SwingL = new WPI_TalonFX(Constants.kSwingL);
  
  private final WPI_TalonFX ReleaseMotor = new WPI_TalonFX(Constants.kRelease);
  private TalonFXConfiguration aConfiguration = new TalonFXConfiguration();

  public ReleaseType CurrentReleaseType = ReleaseType.None;
  /** Creates a new MartianClimbers. */
  public MartianClimbers() {
    SwingL.follow(SwingR);
    SwingL.setInverted(InvertType.OpposeMaster);

    

    // Configure PID for release
    aConfiguration.slot0.kP = Constants.kReleasePIDF.kP;
    aConfiguration.slot0.kI = Constants.kReleasePIDF.kI;
    aConfiguration.slot0.kD = Constants.kReleasePIDF.kD;
    aConfiguration.slot0.kF = Constants.kReleasePIDF.kF;
    aConfiguration.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();
    aConfiguration.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;

    // Limit the current for the release motor. Prevents breaker from tripping
    // and motor from overheating
    aConfiguration.statorCurrLimit.enable = true;
    aConfiguration.statorCurrLimit.currentLimit = 29;
    ReleaseMotor.configAllSettings(aConfiguration);
    

  }

  public void SetRelease(ReleaseType releaseType) {
    CurrentReleaseType = releaseType;

    switch(releaseType) {
      case LongArmRelease:
        ReleaseMotor.set(TalonFXControlMode.Position, Constants.kLongArmReleaseSetPoint);
        break;
      case ShortArmRelease: 
        ReleaseMotor.set(TalonFXControlMode.Position, Constants.kShortArmReleaseSetpoint);
        break;
      case None:
      default:
        ReleaseMotor.set(TalonFXControlMode.Position, Constants.kNoRelease);
    }

    System.out.println("Climber Release: " + releaseType.name());
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
