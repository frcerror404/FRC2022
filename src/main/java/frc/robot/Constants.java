// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.lib.Gains;


public final class Constants {
    // Drivetrain CAN ID's
    public static int klDT1 = 14;
    public static int klDT2 = 15;
    public static int krDT1 = 45;
    public static int krDT2 = 1;

    // Module ID's
    public static int kFrontIntake = 7;
    public static int KIntakeWinch = 9;
    public static int kIndexer = 4;
    public static int kShooterA = 2;
    public static int kShooterB = 13;
    public static int kTopShooter = 11;
    public static int kClimberFL = 10; // Deprecated
    public static int kClimberFR = 6; // Deprecated
    public static int kClimberBL = 11; // Deprecated
    public static int kClimberBR = 5; // Deprecated
    public static int kSwingR = 10;
    public static int kSwingL = 6;
    public static int kRelease = 5;

    public static double MAIN_SHOOTER_WHEEL_DIAMETER = 4.0;
    public static double TOP_SHOOTER_WHEEL_DIAMETER = 2.25;
    public static double TopShooterMultiplier = 1.1;
    

    // Shooter PID
    /* 	                                    			  kP   kI   kD   kF               Iz    PeakOut */
    public static Gains kShooterPIDF  = new Gains( 0.1,   0,  5,  1023.0    /20660.0,  300,  1.00);
    public static int HighGoalRPM = 1850;
    public static int LowGoalRPM = 800;

    // Climber Release PID
    public static Gains kReleasePIDF = new Gains( 0.2,    0,   .004,    0,  0,  1.00);
    public static int kShortArmReleaseSetpoint = -300;
    public static int kLongArmReleaseSetPoint = 3234;
    public static int kNoRelease = 1705;

    public static double Falcon500SensorUnitsConstant = 2048;



    
    public static double kDrivetrainLowSpeedMultiplier = .75;

    // true = arcade drive, false = tank drive
    public static boolean isCurvatureDrive = false;
}
