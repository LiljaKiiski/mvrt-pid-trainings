// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class PIDCommand extends CommandBase {

  private final Drivetrain dt;
  private PIDController pidController;

  /** Creates a new PIDCommand. */
  public PIDCommand(Drivetrain dt) {
    this.dt = dt;
    addRequirements(dt);
    pidController = new PIDController(0.1, 0, 0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double output = pidController.calculate(dt.ticksToMeters());
    if (output > 0.3) {
      output = 0.3;
    }
    dt.setSpeed(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (dt.ticksToMeters() - 3 >= -0.1 && dt.ticksToMeters() - 3 <= 0.1);
  }
}
