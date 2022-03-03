// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.IndexerTalon;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnOnIndexer extends InstantCommand {
  private final Indexer m_indexer;
  
  public TurnOnIndexer(Indexer indexer) {
    addRequirements(indexer);
    m_indexer = indexer;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_indexer.setIndexerSpeed(1.0);
  }
}
