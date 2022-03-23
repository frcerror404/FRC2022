// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.MartianClimbers;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetMartianClimberSpeed extends InstantCommand {
  private final MartianClimbers m_martianClimbers;
  private double m_speed;
  public SetMartianClimberSpeed(MartianClimbers climbers, double speed) {
    m_martianClimbers = climbers;
    m_speed = speed;
    addRequirements(m_martianClimbers);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_martianClimbers.SetClimberSpeed(m_speed);
  }
}
