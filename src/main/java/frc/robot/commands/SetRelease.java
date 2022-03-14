// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.lib.ReleaseType;
import frc.robot.subsystems.MartianClimbers;

public class SetRelease extends InstantCommand {
  private final MartianClimbers m_martianClimbers;
  private final ReleaseType m_releaseType;
  /** Creates a new SetRelease. */
  public SetRelease(MartianClimbers climbers, ReleaseType releaseType) {
    m_martianClimbers = climbers;
    m_releaseType = releaseType;

    addRequirements(m_martianClimbers);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_martianClimbers.SetRelease(m_releaseType);
  }
}
