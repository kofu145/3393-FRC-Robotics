// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Servo;

public class TriggerServo extends SubsystemBase {
  /** Creates a new TriggerServo. */
  public Servo triggerServo = null;
  public Servo secondaryServo = null;
  public TriggerServo() {
    triggerServo = new Servo(0);
    secondaryServo = new Servo(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void pitchUpTrigger() {
      triggerServo.setAngle(200);
        
  }

  public void pitchUpSecondary() {
    secondaryServo.setAngle(120);

  }

  public void pitchDownTrigger() {
    // coming in (open gate)
      triggerServo.setAngle(50);

  }

  public void pitchDownSecondary() {
    secondaryServo.setAngle(230);
  }

  public double getPos(int servo_num) {
    switch (servo_num) {
      case 1:
        return triggerServo.getAngle();
      case 2:
        return secondaryServo.getAngle();
    }
    // if we fail
    return -1;
  }

  public void setPos(int angle) {
    triggerServo.setAngle(90);
  }

}
