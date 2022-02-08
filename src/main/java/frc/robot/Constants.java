// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

/** CAN ID 1-10 reserved for drivetrain.
 *  CAN ID 11-20 reserved for Modules. (Shooter, Intake, etc.)
 *  CAN ID 21-30 reserved for (EDIT THIS LINE).
 *  CAN ID 31-40 reserved for (EDIT THIS LINE).
 * 
 * The PDB (Power Distribution Board) has a ID of 60 as I don't beleive we will
 * go that high in terms of ID's. 
 */ 

public final class Constants {
    // Drivetrain CAN ID's
    public static int klDT1 = 14;
    public static int klDT2 = 15;
    public static int krDT1 = 45;
    public static int krDT2 = 1;

    // Module ID's
    public static int kFrontIntake = 5;
    public static int kIndexer = 4;
    public static int kShooterA = 2;
    public static int kShooterB = 13;

    // true = arcade drive, false = tank drive
    public static boolean isCurvatureDrive = false;
}
