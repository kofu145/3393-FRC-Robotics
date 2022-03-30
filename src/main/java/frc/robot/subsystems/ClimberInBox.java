// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberInBox extends SubsystemBase {
  WPI_TalonSRX climberMotorController = null;
  /** Creates a new ClimberInBox. */
  public ClimberInBox() {
    climberMotorController = new WPI_TalonSRX(Constants.CLIMBER);



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb(double speed) {
    climberMotorController.set(speed);
  }
}
