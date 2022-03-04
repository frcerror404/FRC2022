// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.Modes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.SetShooterRPM;
import frc.robot.commands.TurnOffIndexer;
import frc.robot.commands.TurnOffIntake;
import frc.robot.commands.TurnOffShooter;
import frc.robot.commands.TurnOnIndexer;
import frc.robot.commands.TurnOnIntake;
import frc.robot.commands.Autonomous.Commands.DelayCommand;
import frc.robot.commands.Autonomous.Commands.SetDrivetrainSpeedForTime;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallShortAuton extends SequentialCommandGroup {
  /** Creates a new TwoBallAuton. */
  public TwoBallShortAuton(Drivebase drivebase, Shooter shooter, Indexer indexer, Intake intake) {
    super(
      new SetShooterRPM(shooter, Constants.HighGoalRPM),
      new DelayCommand(.5),
      new TurnOnIndexer(indexer),
      new DelayCommand(.5),
      //new TurnOffShooter(shooter),
      new TurnOffIndexer(indexer),
      new TurnOnIntake(intake),
      new SetDrivetrainSpeedForTime(-.6, -.6, .35, drivebase),
      new SetDrivetrainSpeedForTime(.5, .5, .2, drivebase),
      new SetDrivetrainSpeedForTime(-.4, -.4, 1.75, drivebase),
      new SetDrivetrainSpeedForTime(.6, .6, .4, drivebase),
      new TurnOnIndexer(indexer),
      new DelayCommand(2),
      new TurnOffShooter(shooter),
      new TurnOffIndexer(indexer),
      new TurnOffIntake(intake)
    );
    addCommands();
  }
}
