// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.simulation.JoystickSim;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.FrontClimber;
import frc.robot.subsystems.BackClimber;
// import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.IndexerTalon;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeWinch;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.SetDrivetrainSpeedCommand;
import frc.robot.commands.SetFrontClimberSpeed;
import frc.robot.commands.SetIntakeWinchSpeed;
import frc.robot.commands.TurnOnIntake;
import frc.robot.commands.TurnOffIntake;
import frc.robot.commands.TurnOnShooter;
import frc.robot.commands.TurnOffShooter;
import frc.robot.commands.HighGoalShooter;
import frc.robot.commands.LowGoalShooter;
import frc.robot.commands.SetBackClimberSpeed;
import frc.robot.commands.SetShooterRPM;
import frc.robot.commands.TurnOnIndexer;
import frc.robot.commands.TurnOffIndexer;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivebase drivebase;
  public final Intake intake = new Intake();
  public final IntakeWinch winch = new IntakeWinch();
  public final Shooter shooter = new Shooter();
  public final IndexerTalon indexer = new IndexerTalon();
  public final FrontClimber Fclimber = new FrontClimber();
  public final BackClimber Bclimber = new BackClimber();
 
  private final XboxController joy0 = new XboxController(0);
  private final XboxController joy1 = new XboxController(1);

  //public final AHRS navx = new AHRS(Port.kMXP);
  //public final Limelight limelight = new Limelight();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer(Drivebase drivebase) {
    this.drivebase = drivebase;
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton P0_RBumber = new JoystickButton(joy0, XboxController.Button.kRightBumper.value);
    JoystickButton P0_BButton = new JoystickButton(joy0, XboxController.Button.kB.value);
    JoystickButton P0_AButton = new JoystickButton(joy0, XboxController.Button.kA.value);
    JoystickButton P0_XButton = new JoystickButton(joy0, XboxController.Button.kX.value);
    JoystickButton P0_YButton = new JoystickButton(joy0, XboxController.Button.kY.value);


    JoystickButton P1_leftBumper = new JoystickButton(joy1, XboxController.Button.kLeftBumper.value);
    JoystickButton P1_rightBumper = new JoystickButton(joy1, XboxController.Button.kRightBumper.value);
    JoystickButton P1_BButton = new JoystickButton(joy1, XboxController.Button.kB.value);
    JoystickButton P1_AButton = new JoystickButton(joy1, XboxController.Button.kA.value);
    JoystickButton P1_XButton = new JoystickButton(joy1, XboxController.Button.kX.value);
    JoystickButton P1_YButton = new JoystickButton(joy1, XboxController.Button.kY.value);
  
  P1_leftBumper
   .whenPressed(new SetShooterRPM(shooter, Constants.LowGoalRPM))
   .whenReleased(new TurnOffShooter(shooter));  

  P1_rightBumper
    .whenPressed(new SetShooterRPM(shooter, Constants.HighGoalRPM))
    .whenReleased(new TurnOffShooter(shooter));

  P1_BButton
    .whenPressed(new TurnOnIndexer(indexer))
    .whenReleased(new TurnOffIndexer(indexer));

  P1_AButton
    .whenPressed(new TurnOnIntake(intake))
    .whenReleased(new TurnOffIntake(intake));

  P1_YButton
    .whenPressed(new SetIntakeWinchSpeed(winch, 0.65))
    .whenReleased(new SetIntakeWinchSpeed(winch, 0.0));
  
  P1_XButton
    .whenPressed(new SetIntakeWinchSpeed(winch, -0.65))
    .whenReleased(new SetIntakeWinchSpeed(winch, 0.0));

  P0_YButton
    .whenPressed(new SetFrontClimberSpeed(Fclimber, 1.0))
    .whenReleased(new SetFrontClimberSpeed(Fclimber, 0.0));

  P0_BButton
    .whenPressed(new SetFrontClimberSpeed(Fclimber, -0.65))
    .whenReleased(new SetFrontClimberSpeed(Fclimber, 0.0));

  P0_AButton
    .whenPressed(new SetBackClimberSpeed(Bclimber, 0.85))
    .whenReleased(new SetBackClimberSpeed(Bclimber, 0.0));

  P0_XButton
    .whenPressed(new SetBackClimberSpeed(Bclimber, -.65))
    .whenReleased(new SetBackClimberSpeed(Bclimber, 0.0));

    
    if(Constants.isCurvatureDrive) {
      drivebase.setDefaultCommand(
        new SetDrivetrainSpeedCommand(
         () -> joy0.getLeftY(),
         () -> joy0.getRightY(),
         () -> joy0.getRightBumper(),
        drivebase));
  
    } else {
      drivebase.setDefaultCommand(
        new SetDrivetrainSpeedCommand(
         () -> joy0.getLeftY(),
         () -> joy0.getRightY(),
         () -> P0_RBumber.get(),
        drivebase));
  
    }
    
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  }
}