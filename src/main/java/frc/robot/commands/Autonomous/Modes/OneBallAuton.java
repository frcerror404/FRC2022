package frc.robot.commands.Autonomous.Modes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.SetShooterRPM;
import frc.robot.commands.TurnOffIndexer;
import frc.robot.commands.TurnOffShooter;
import frc.robot.commands.TurnOnIndexer;
import frc.robot.commands.Autonomous.Commands.DelayCommand;
import frc.robot.commands.Autonomous.Commands.SetDrivetrainSpeedForTime;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class OneBallAuton extends SequentialCommandGroup {

    public OneBallAuton(Drivebase drivebase, Shooter shooter, Indexer indexer) {
        super(
            new SetShooterRPM(shooter, Constants.HighGoalRPM),
            new DelayCommand(1.0),
            new TurnOnIndexer(indexer),
            new DelayCommand(1.5),
            new TurnOffShooter(shooter),
            new TurnOffIndexer(indexer),
            new SetDrivetrainSpeedForTime(-.6, -.6, 1, drivebase)
        );

        addRequirements(drivebase, shooter, indexer);
    }
}
