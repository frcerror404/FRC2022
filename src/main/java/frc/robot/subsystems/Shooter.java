/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

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
  private final WPI_TalonFX shooterA = new WPI_TalonFX(Constants.kShooterA);
  private final WPI_TalonFX shooterB = new WPI_TalonFX(Constants.kShooterB);
  private final WPI_TalonFX topShooter = new WPI_TalonFX(Constants.kTopShooter);

  private TalonFXConfiguration aConfiguration = new TalonFXConfiguration();


  public Shooter() {
    // Set the configuration's PIDF values
    aConfiguration.slot0.kP = Constants.kShooterPIDF.kP;
    aConfiguration.slot0.kI = Constants.kShooterPIDF.kI;
    aConfiguration.slot0.kD = Constants.kShooterPIDF.kD;
    aConfiguration.slot0.kF = Constants.kShooterPIDF.kF;
    aConfiguration.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();

    shooterA.setInverted(true);
    shooterB.follow(shooterA);
    shooterB.setInverted(TalonFXInvertType.OpposeMaster);

    shooterA.configAllSettings(aConfiguration);

    topShooter.configAllSettings(aConfiguration);
  }
  
  /**
   * @param ShooterSpeed the speed 0-1
   */
  public void setShooterPercentage(double shooterSpeed) {
    shooterA.set(shooterSpeed);
    topShooter.set(shooterSpeed);
  }

  public void setShooterRPM(int rpm) {
    double outputInSensorUnits = rpm * Constants.Falcon500SensorUnitsConstant / 600.0;
    double topOutput = calculateTopShooterSpeed(rpm) * Constants.Falcon500SensorUnitsConstant / 600.0;
    topOutput = topOutput * Constants.TopShooterMultiplier;
    
    shooterA.set(TalonFXControlMode.Velocity, outputInSensorUnits);
    topShooter.set(TalonFXControlMode.Velocity, topOutput);
  }

  private double calculateTopShooterSpeed(int mainShooterRPM) {
    if(mainShooterRPM == 0) { return 0.0; }

    double mainWheelSFM = 0.262 * Constants.MAIN_SHOOTER_WHEEL_DIAMETER * mainShooterRPM;
    double topWheelRPM = mainWheelSFM / .262 / Constants.TOP_SHOOTER_WHEEL_DIAMETER;
    return topWheelRPM;
  }
  
  @Override
  public void periodic() {
    //System.out.println(String.format("Shooter 1 Speed: %f rpm", shooterMotorA.getSensorCollection().getIntegratedSensorVelocity()));
    //System.out.println(String.format("Shooter 1 Inverted?", shooterMotorA.getInverted()));
    // This method will be called once per scheduler run
  }
}
