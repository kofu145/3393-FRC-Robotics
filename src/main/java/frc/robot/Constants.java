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
public final class Constants {

    // our talons
    
    public static final int RIGHT_FRONT_TALON = 1;
    public static final int RIGHT_BACK_TALON = 2;
    public static final int LEFT_FRONT_TALON = 3;
    public static final int LEFT_BACK_TALON = 4;

    public static final int INTAKE_ONE = 8;
    public static final int INTAKE_TWO = 7;
    public static final int SHOOTER = 5;

    public static final int CLIMBER = 6;

    public static final int DRIVER_CONTROLLER = 0;
    public static final int DRIVER_CONTROLLER_LEFT_AXIS = 1; // Change for your controller
    public static final int DRIVER_CONTROLLER_RIGHT_AXIS = 5; // Change for your controller
    public static final int DRIVER_CONTROLLER_RIGHT_SIDE_AXIS = 0;
    public static final int DRIVER_CONTROLLER_LEFT_SIDE_AXIS = 4;


    public static final int SHOOTER_CONTROLLER_LEFT_AXIS = 1;

    // 4 5 solenoids are here
    public static final int INTAKE_ONE_SOLENOID_DEPLOY = 0;
    public static final int INTAKE_ONE_SOLENOID_RETRACT = 1;
    public static final int INTAKE_TWO_SOLENOID_DEPLOY = 2;
    public static final int INTAKE_TWO_SOLENOID_RETRACT = 3;

    public static final int CLIMBER_ONE_SOLENOID_DEPLOY = 4;
    public static final int CLIMBER_ONE_SOLENOID_RETRACT = 5;
    public static final int CLIMBER_TWO_SOLENOID_DEPLOY = 6;
    public static final int CLIMBER_TWO_SOLENOID_RETRACT = 7;

    public static final int PROPORTIONAL_CONSTANT = 0; // tune this later

    public static final int TRIGGER_SERVO = 0;
    public static final int PROTECTOR_SERVO = 1;
}
