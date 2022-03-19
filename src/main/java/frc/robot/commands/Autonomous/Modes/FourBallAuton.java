// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.Modes;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous.Commands.DelayCommand;
import frc.robot.commands.Autonomous.Commands.EnableBrakeMode;
import frc.robot.commands.Autonomous.Commands.TurnInPlaceXDegrees;
import frc.robot.subsystems.Drivebase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FourBallAuton extends SequentialCommandGroup {
  /** Creates a new FourBallAuton. */
  public FourBallAuton(Drivebase drivebase, AHRS imu, double angle, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new EnableBrakeMode(drivebase, true),
      new TurnInPlaceXDegrees(drivebase, imu, angle, speed),
      new DelayCommand(.1),
      new EnableBrakeMode(drivebase, false)
    );
  }
}
