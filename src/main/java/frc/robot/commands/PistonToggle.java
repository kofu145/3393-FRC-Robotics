// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PistonToggle extends InstantCommand {
  public PistonToggle() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("pressed piston!");
    System.out.println(Robot.pneumatics.getPitch());
    /*
    switch(Robot.pneumatics.getPitch()){
      case kOff:
        Robot.pneumatics.pitchUp();

      case kForward:
        Robot.pneumatics.pitchDown();

      case kReverse:
        Robot.pneumatics.pitchUp();

    }*/

    if (Robot.pneumatics.getPitch() == Value.kOff){
      Robot.pneumatics.pitchDown();

    }
    else if (Robot.pneumatics.getPitch() == Value.kForward){
      Robot.pneumatics.pitchDown();

    }
    else if (Robot.pneumatics.getPitch() == Value.kReverse){
      Robot.pneumatics.pitchUp();

    }


  }
}
