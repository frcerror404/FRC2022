/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class LowGoalShooter extends InstantCommand {
  private final Shooter m_shooter;

  public LowGoalShooter(Shooter shooter) {
    m_shooter = shooter;

    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    // Low goal .35, high goal .65.
    m_shooter.setShooterSpeed(0.35);
  }
}
