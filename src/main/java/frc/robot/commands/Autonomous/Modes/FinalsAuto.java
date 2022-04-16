// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.Modes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.SetShooterRPM;
import frc.robot.Constants;
import frc.robot.commands.SetShooterRPM;
import frc.robot.commands.TurnOffIndexer;
import frc.robot.commands.TurnOffIntake;
import frc.robot.commands.TurnOffShooter;
import frc.robot.commands.TurnOnIndexer;
import frc.robot.commands.TurnOnIntake;
import frc.robot.commands.Autonomous.Commands.DelayCommand;
import frc.robot.commands.Autonomous.Commands.ReverseIntake;
import frc.robot.commands.Autonomous.Commands.SetDrivetrainSpeedForTime;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FinalsAuto extends SequentialCommandGroup {
  /** Creates a new FinalsAuto. */
  public FinalsAuto(Drivebase drivebase, Shooter shooter, Indexer indexer, Intake intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SetShooterRPM(shooter, Constants.HighGoalRPM),
      new DelayCommand(0.1),
      new TurnOnIndexer(indexer),
      new DelayCommand(.5),
      //new TurnOffShooter(shooter),
      new TurnOffIndexer(indexer),
      new ReverseIntake(intake),
      new SetDrivetrainSpeedForTime(-.6, -.6, .35, drivebase),
      new SetDrivetrainSpeedForTime(.5, .5, .2, drivebase),
      new DelayCommand(.4),
      new TurnOnIntake(intake),
      new SetDrivetrainSpeedForTime(-.5, -.5, 1, drivebase),
      new DelayCommand(.3),
      new TurnOnIndexer(indexer),
      new SetDrivetrainSpeedForTime(.6, .6, .65, drivebase),
      new DelayCommand(1),
      new SetDrivetrainSpeedForTime(0., -.7, .95, drivebase),
      new SetDrivetrainSpeedForTime(-.8, -.8, 1.6, drivebase),
      new TurnOffIndexer(indexer),
      new SetDrivetrainSpeedForTime(-.1, -.1, .1, drivebase),
      new DelayCommand(2),
      new SetDrivetrainSpeedForTime(.85, .85, 1.5, drivebase),
      new SetDrivetrainSpeedForTime(-.1, .75, 1.35, drivebase),
      new TurnOnIndexer(indexer),
      new SetDrivetrainSpeedForTime(.35, .35, .25, drivebase),
      new DelayCommand(0),
      
      new DelayCommand(3),
      new TurnOffShooter(shooter),
      new TurnOffIndexer(indexer),
      new TurnOffIntake(intake)
    );
  }
}
