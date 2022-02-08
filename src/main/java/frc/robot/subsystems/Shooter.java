/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Shooter extends SubsystemBase {
  /**
   * Creates a new shooter.
   */
  private final WPI_TalonFX shooterMotorA = new WPI_TalonFX(Constants.kShooterA);
  private final WPI_TalonFX shooterMotorB = new WPI_TalonFX(Constants.kShooterB);
  private boolean _inverted_test = false;

  public Shooter() {
    shooterMotorB.follow(shooterMotorA);
    shooterMotorB.setInverted(TalonFXInvertType.OpposeMaster);

    System.out.println("Shooter 1 Inverted? " + (shooterMotorA.getInverted() ? "True" : "False"));
    shooterMotorA.setInverted(false);
    System.out.println("Shooter 1 Inverted? " + (shooterMotorA.getInverted() ? "True" : "False"));
  }
  
  /**
   * @param ShooterSpeed the speed 0-1
   */
  public void setShooterSpeed(double shooterSpeed) {

    // if(shooterSpeed > 0) {
    //   _inverted_test = !_inverted_test;
    //   shooterMotorA.setInverted(_inverted_test);
    // }
    System.out.println("Shooter 1 Inverted? " + (shooterMotorA.getInverted() ? "True" : "False"));

    shooterMotorA.set(shooterSpeed);
  }
  
  @Override
  public void periodic() {
    //System.out.println(String.format("Shooter 1 Speed: %f rpm", shooterMotorA.getSensorCollection().getIntegratedSensorVelocity()));
    //System.out.println(String.format("Shooter 1 Inverted?", shooterMotorA.getInverted()));
    // This method will be called once per scheduler run
  }
}
