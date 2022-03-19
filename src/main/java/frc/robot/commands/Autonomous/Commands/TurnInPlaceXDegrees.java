// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.Commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class TurnInPlaceXDegrees extends CommandBase {
  private final Drivebase m_drivebase;
  private double m_speed;
  private final double m_degrees;
  private final AHRS m_imu;

  private double goal = 0.0;
  private boolean inverted = false;
  PIDController turnController;

  static final double kP = 0.012;
  static final double kI = 0.003;
  static final double kD = 0.0005;
  static final double max_output = 0.7;
  static final double kToleranceDegrees = 3.0f;
  boolean enabled = true;   

  /** Creates a new TurnInPlaceXDegrees. */
  public TurnInPlaceXDegrees(Drivebase drivebase, AHRS imu, double degrees, double speed) {
    m_drivebase = drivebase;
    m_degrees = degrees * .85;
    m_speed = speed;
    m_imu = imu;
    
    addRequirements(m_drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    goal = m_imu.getAngle() + m_degrees;
    
    if(m_degrees < 0) {
      m_speed = -m_speed;
    }
    
    turnController = new PIDController(kP, kI, kD);
    turnController.setSetpoint(goal);
    turnController.setIntegratorRange(0, 0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(goal - m_imu.getAngle());
    
    if(!enabled) { return; }

    double speed = turnController.calculate(m_imu.getAngle());
    speed = clamp(speed);
    m_drivebase.manualControl(-speed, speed, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.manualControl(0, 0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(m_imu.getAngle() - goal);
    return Math.abs(m_imu.getAngle() - goal) < kToleranceDegrees;
  }

  private double clamp(double input) {
    if(input > max_output) {
      return max_output;
    }
    if(input < -max_output) {
      return -max_output;
    }

    return input;

  }
}
