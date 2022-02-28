// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.IntakeWinch;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetIntakeWinchSpeed extends InstantCommand {
  private final IntakeWinch m_IntakeWinch;
  private final double m_WinchSpeed;


  public SetIntakeWinchSpeed(IntakeWinch winch, double winch_speed) {
    addRequirements(winch);
    m_IntakeWinch = winch;
    m_WinchSpeed = winch_speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_IntakeWinch.setWinchSpeed(m_WinchSpeed);
  }
}
