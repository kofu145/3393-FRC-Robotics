// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TimedShootMain extends SequentialCommandGroup {
  /** Creates a new TimedShootMain. */
  public TimedShootMain() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //new ShooterRun(),
      new WaitCommand(2),
      new TimedServoTrigger(),
      new WaitCommand(.5),
      new PistonDown(),
      new TimedIntakeRun(),
      new PistonUp()

    );
  }
}
