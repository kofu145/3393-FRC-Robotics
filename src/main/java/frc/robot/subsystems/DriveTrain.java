// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX leftFrontMotorControl = null;
  WPI_TalonSRX leftBackMotorControl = null;
  WPI_TalonSRX rightFrontMotorControl = null;
  WPI_TalonSRX rightBackMotorControl = null;

  WPI_TalonSRX intakeOneMotorControl = null;
  WPI_TalonSRX intakeTwoMotorControl = null;
  WPI_TalonSRX shooterMotorControl = null;

  DifferentialDrive differentialDrive = null;
  public boolean driveArcadeHasShooter = true;

  Encoder encoderLeft;
  Encoder encoderRight;

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

    rightBackMotorControl.follow(rightFrontMotorControl);
    leftFrontMotorControl.follow(leftFrontMotorControl);

    this.gyro = gyro;
    rightFrontMotorControl.setInverted(true);
    rightBackMotorControl.setInverted(true);

    differentialDrive = new DifferentialDrive(leftFrontMotorControl, rightFrontMotorControl);

    rightFrontMotorControl.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kRightSlotIdx, Constants.kTimeoutMs);
    leftFrontMotorControl.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kLeftSlotIdx, Constants.kTimeoutMs);
    shooterMotorControl.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kShooterSlotIdx, Constants.kTimeoutMs);    

    shooterMotorControl.config_kP(Constants.kShooterSlotIdx, Constants.kP);
    shooterMotorControl.config_kI(Constants.kShooterSlotIdx, Constants.kI);
    shooterMotorControl.config_kD(Constants.kShooterSlotIdx, Constants.kD);
    shooterMotorControl.config_kF(Constants.kShooterSlotIdx, Constants.kF);

    rightFrontMotorControl.config_kP(Constants.kRightSlotIdx, Constants.kP);
    rightFrontMotorControl.config_kI(Constants.kRightSlotIdx, Constants.kI);
    rightFrontMotorControl.config_kD(Constants.kRightSlotIdx, Constants.kD);
    rightFrontMotorControl.config_kF(Constants.kRightSlotIdx, Constants.kF);

    leftFrontMotorControl.config_kP(Constants.kLeftSlotIdx, Constants.kP);
    leftFrontMotorControl.config_kI(Constants.kLeftSlotIdx, Constants.kI);
    leftFrontMotorControl.config_kD(Constants.kLeftSlotIdx, Constants.kD);
    leftFrontMotorControl.config_kF(Constants.kLeftSlotIdx, Constants.kF);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("SensorVel", shooterMotorControl.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("SensorPos", shooterMotorControl.getSelectedSensorPosition(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("MotorOutputPercent", shooterMotorControl.getMotorOutputPercent());
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
