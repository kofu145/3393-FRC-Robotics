// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TimedIntakeRun extends CommandBase {
  private double startTime;
  /** Creates a new IntakeRun. */
  public TimedIntakeRun() {
    // Use addRequirements() here to declare subsystem dependencies.
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
    if (time - startTime < .7) {
      RobotContainer.m_drivetrain.intakeMotorRun(.37);
    }
    else {
      RobotContainer.m_drivetrain.intakeMotorRun(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double time = Timer.getFPGATimestamp();
    if (time - startTime > .7) {
      RobotContainer.m_drivetrain.intakeMotorRun(0);
      return true;
    }
    return false;
  }
}
