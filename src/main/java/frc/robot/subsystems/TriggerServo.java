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

  public void pitchUp(int servo_num) {
    switch (servo_num) {
      case 1:
        triggerServo.setAngle(130);
      case 2:
        secondaryServo.setAngle(100);
    }
  }

  public void pitchDown(int servo_num) {
    switch (servo_num) {
      case 1:
        triggerServo.setAngle(100);
      case 2:
        secondaryServo.setAngle(220);
    }
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

}
