// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX leftFrontMotorControl = null;
  WPI_TalonSRX leftBackMotorControl = null;
  WPI_TalonSRX rightFrontMotorControl = null;
  WPI_TalonSRX rightBackMotorControl = null;

  WPI_TalonSRX intakeOneMotorControl = null;
  WPI_TalonSRX intakeTwoMotorControl = null;
  WPI_TalonSRX shooterMotorControl = null;

  MotorControllerGroup leftMotors = null;
  MotorControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  double speed;
  double rotation;

  double threshold = 1;

  Gyro gyro;

  /** Creates a new DriveTrain. */
  public DriveTrain(Gyro gyro) {
    
    
    rightFrontMotorControl = new WPI_TalonSRX(Constants.RIGHT_FRONT_TALON);
    rightBackMotorControl = new WPI_TalonSRX(Constants.RIGHT_BACK_TALON);
    leftFrontMotorControl = new WPI_TalonSRX(Constants.LEFT_FRONT_TALON);
    leftBackMotorControl = new WPI_TalonSRX(Constants.LEFT_BACK_TALON);

    intakeOneMotorControl = new WPI_TalonSRX(Constants.INTAKE_ONE);
    intakeTwoMotorControl = new WPI_TalonSRX(Constants.INTAKE_TWO);
    shooterMotorControl = new WPI_TalonSRX(Constants.SHOOTER);

    this.gyro = gyro;
    rightFrontMotorControl.setInverted(true);
    rightBackMotorControl.setInverted(true);

    leftMotors = new MotorControllerGroup(leftFrontMotorControl, leftBackMotorControl);
    rightMotors = new MotorControllerGroup(rightFrontMotorControl, rightBackMotorControl);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void calcRotateValue(double targetAngle){
    double error = targetAngle - this.gyro.getAngle();
    if (error > threshold) {
        rotation = error * (double)Constants.PROPORTIONAL_CONSTANT;
    }
    else{
      rotation = 0;
    }

  }

  public void motorRun(double speed) {
    rightFrontMotorControl.set(speed);
    rightBackMotorControl.set(speed);
    leftFrontMotorControl.set(speed);
    leftBackMotorControl.set(speed);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {

    differentialDrive.tankDrive(leftSpeed, rightSpeed);

  }

  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);

  }

  public void intakeMotorRun(double speed){
    intakeOneMotorControl.set(speed);
    intakeTwoMotorControl.set(-speed);
    
  }

  public void shooterMotorRun(double speed) {
    shooterMotorControl.set(speed);

  }

  public void arcadeDrivePID(double speed, double rotation) {
    
    //differentialDrive.arcadeDrive(speed, rotation);
  }

  public void autoRotate(){



  }
}
