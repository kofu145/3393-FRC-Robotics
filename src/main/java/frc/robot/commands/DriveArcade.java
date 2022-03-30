// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.fasterxml.jackson.databind.util.RootNameLookup;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;

import frc.robot.Constants;
import frc.robot.Robot;

public class DriveArcade extends CommandBase {

  boolean disabledDriveTrain;
  /** Creates a new DriveArcade. */

  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    boolean disabledDriveTrain = false;
    System.out.println("DriveArcade initialized.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    double speed = 0;
    double secondSpeed = 0;
    double leftSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_LEFT_AXIS);
    double rightSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_RIGHT_AXIS);
    //double intakeSpeed = RobotContainer.shooterController.getRawAxis(Constants.SHOOTER_CONTROLLER_LEFT_AXIS);
    double rotation = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_LEFT_SIDE_AXIS);


   // double intakeTrigger = RobotContainer.shooterController.getL2Axis();
    boolean intakeReverse = RobotContainer.driverController.getRawButton(5);

    double speedBoostOne = RobotContainer.driverController.getRightTriggerAxis();
    double intakeSpeed = RobotContainer.driverController.getLeftTriggerAxis();

    int triggerDPad = RobotContainer.driverController.getPOV();

    // all this is completely unecessary, learn how to use the command scheduler


    
    /*
    if (triggerDPad == 0){
      speed = .9;
    }
    else {
        speed = (double)triggerDPad * .0025;
    }
 */

    if (triggerDPad == 0) {
      speed = -1;
    }
    else if (triggerDPad == 180) {
      speed = .4;
    }

    if (leftSpeed > 0)
      leftSpeed = leftSpeed*.7 + (speedBoostOne*.3);
    else if (leftSpeed < 0)
      leftSpeed = leftSpeed*.7 - (speedBoostOne*.3);
    
    if (rightSpeed > 0)
      rightSpeed = rightSpeed*.7 + (speedBoostOne*.3);
    else if (rightSpeed < 0)
      rightSpeed = rightSpeed*.7 - (speedBoostOne*.3);

    if (intakeReverse){
      intakeSpeed *= -1;
    }
    
    //RobotContainer.m_drivetrain.tankDrive(leftSpeed, rightSpeed);
    RobotContainer.m_drivetrain.arcadeDrive(leftSpeed, rotation*-.8);
    RobotContainer.m_climber.climb(speed);
    //RobotContainer.m_drivetrain.shooterMotorRun(speed);
    
    //RobotContainer.m_drivetrain.intakeMotorRun(intakeSpeed/2);

    

    

    //RobotContainer.m_drivetrain.motorRun(leftSpeed);
    //RobotContainer.m_drivetrain.secondMotorRun(rightSpeed/2);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // disabledDriveTrain = true;
    RobotContainer.m_drivetrain.tankDrive(0, 0);
    RobotContainer.m_drivetrain.intakeMotorRun(0);
    RobotContainer.m_drivetrain.shooterMotorRun(0);


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (disabledDriveTrain) {
      return true;
    }
    return false;
  }
}
