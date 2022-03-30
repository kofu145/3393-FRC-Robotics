// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;

  private double startTime;
  private boolean servoToggle = false;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double time = Timer.getFPGATimestamp();

    // danger of missing, find some other way to do this
    //if (time - startTime == 2) {
    //  new TimedServoTrigger();
    //}

    if (time - startTime < 5) {
      RobotContainer.m_drivetrain.shooterMotorRun(1);

    }

    

    if (time - startTime < 2) {//(time - startTime > 3 && time - startTime < 5.5) {
      RobotContainer.m_drivetrain.tankDrive(.6, .6);
    }
    
    else if (time - startTime > 2) {

      RobotContainer.m_drivetrain.tankDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double time = Timer.getFPGATimestamp();

    if (time - startTime > 2 && !servoToggle) {
      CommandScheduler.getInstance().schedule(new TimedServoTrigger());
      servoToggle = true;
    }
    if (time - startTime > 5) {
      RobotContainer.m_drivetrain.shooterMotorRun(0);
      
    }
    return false;
  }
}
