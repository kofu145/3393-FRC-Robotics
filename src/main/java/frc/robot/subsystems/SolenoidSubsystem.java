// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class SolenoidSubsystem extends SubsystemBase {

  public DoubleSolenoid framePistonOne = null;
  public DoubleSolenoid framePistonTwo = null;

  /** Creates a new SolenoidSubsystem. */
  public SolenoidSubsystem() {
    framePistonOne = new DoubleSolenoid
    (
      PneumaticsModuleType.CTREPCM,
      Constants.INTAKE_ONE_SOLENOID_DEPLOY,
      Constants.INTAKE_ONE_SOLENOID_RETRACT
    );
    framePistonTwo = new DoubleSolenoid
    (
      PneumaticsModuleType.CTREPCM,
      Constants.INTAKE_TWO_SOLENOID_DEPLOY,
      Constants.INTAKE_TWO_SOLENOID_RETRACT
    );

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pitchUp() {
    framePistonOne.set(Value.kForward);
    framePistonTwo.set(Value.kForward);

  }

  public void pitchDown() {
    framePistonOne.set(Value.kReverse);
    framePistonTwo.set(Value.kReverse);

  }

  public Value getPitch() {
    return framePistonOne.get();
  }
}
