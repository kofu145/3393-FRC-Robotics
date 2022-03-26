// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeRun;
import frc.robot.commands.TimedIntakeRun;
import frc.robot.commands.TimedParallelShootSlow;
import frc.robot.commands.PistonDown;
import frc.robot.commands.PistonToggle;
import frc.robot.commands.PistonUp;
import frc.robot.commands.ServoDown;
import frc.robot.commands.ServoUp;
import frc.robot.commands.ShooterRun;
import frc.robot.commands.ShooterRunSlow;
import frc.robot.commands.TimedServoTrigger;
import frc.robot.commands.TimedShootMain;
import frc.robot.commands.ShooterRunSlow;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static final XboxController driverController = new XboxController(0);
  public static final PS4Controller shooterController = new PS4Controller(1);

  public static final AnalogGyro gyro = new AnalogGyro(0);
  public static final DriveTrain m_drivetrain = new DriveTrain(gyro);

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    
  }

  /**
   * Use this medthod to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // init the objects we want to bind
    JoystickButton button_a = new JoystickButton(this.driverController, 1);
    JoystickButton button_b = new JoystickButton(this.shooterController, 2);
    JoystickButton button_x = new JoystickButton(this.driverController, 3);
    JoystickButton button_y = new JoystickButton(this.driverController, 4);

    JoystickButton left_bumper = new JoystickButton(this.driverController, 5);
    JoystickButton right_bumper = new JoystickButton(this.driverController, 6);
    ///button_b.whenPressed(new ServoDown());
    button_a.whenPressed(new TimedShootMain());
    

    left_bumper.whileHeld(new IntakeRun());

    button_x.whenPressed(new PistonToggle());
    //left_bumper.whenPressed(new PistonUp());
    //right_bumper.whenPressed(new PistonDown());

    // do mappings here



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
