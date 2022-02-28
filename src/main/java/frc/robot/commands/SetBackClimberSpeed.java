// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.BackClimber;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetBackClimberSpeed extends InstantCommand {
  private final BackClimber m_climber;
  private final double m_climberSpeed;

  public SetBackClimberSpeed(BackClimber climber, double climber_speed) {
    addRequirements(climber);
    m_climber = climber;
    m_climberSpeed = climber_speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climber.setClimberSpeed(m_climberSpeed);
  }
}
