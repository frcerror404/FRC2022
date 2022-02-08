/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Shooter extends SubsystemBase {
  /**
   * Creates a new shooter.
   */
  private final WPI_TalonFX shooterMotorA = new WPI_TalonFX(Constants.kShooterA);
  private final WPI_TalonFX shooterMotorB = new WPI_TalonFX(Constants.kShooterB);

  private TalonFXConfiguration aConfiguration = new TalonFXConfiguration();


  public Shooter() {
    // Set the configuration's PIDF values
    aConfiguration.slot0.kP = Constants.kShooterPIDF.kP;
    aConfiguration.slot0.kI = Constants.kShooterPIDF.kI;
    aConfiguration.slot0.kD = Constants.kShooterPIDF.kD;
    aConfiguration.slot0.kF = Constants.kShooterPIDF.kF;
    aConfiguration.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();

    shooterMotorA.setInverted(true);
    shooterMotorB.follow(shooterMotorA);
    shooterMotorB.setInverted(TalonFXInvertType.OpposeMaster);

    shooterMotorA.configAllSettings(aConfiguration);
  }
  
  /**
   * @param ShooterSpeed the speed 0-1
   */
  public void setShooterPercentage(double shooterSpeed) {
    shooterMotorA.set(shooterSpeed);
  }

  public void setShooterRPM(int rpm) {
    double outputInSensorUnits = rpm * Constants.Falcon500SensorUnitsConstant / 600.0;
    shooterMotorA.set(TalonFXControlMode.Velocity, outputInSensorUnits);
  }
  
  @Override
  public void periodic() {
    //System.out.println(String.format("Shooter 1 Speed: %f rpm", shooterMotorA.getSensorCollection().getIntegratedSensorVelocity()));
    //System.out.println(String.format("Shooter 1 Inverted?", shooterMotorA.getInverted()));
    // This method will be called once per scheduler run
  }
}
