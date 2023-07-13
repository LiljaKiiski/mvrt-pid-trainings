// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private TalonFX leftFront;
  private TalonFX leftBack;
  private TalonFX rightFront;
  private TalonFX rightBack;
  private double kWheelCircumference = 6 * Math.PI;
  private double kTicksPerRotation = 2048;
  private double kGearRatio = 12.78;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFront = new TalonFX(1);
    rightFront = new TalonFX(2);
    leftBack = new TalonFX(3);
    rightBack = new TalonFX(4);
    rightFront.setInverted(TalonFXInvertType.Clockwise);
    rightBack.setInverted(TalonFXInvertType.Clockwise);
    leftFront.setInverted(TalonFXInvertType.CounterClockwise);
    leftBack.setInverted(TalonFXInvertType.CounterClockwise);
    rightBack.follow(rightFront);
    leftBack.follow(leftFront);
    
    resetEncoders();
  }

  public void resetEncoders() {
    // reset the encoders by using setSelectedSensorPosition
  }

  public void setSpeeds(double speed) {
    // set the speeds of the motors
    leftFront.set(ControlMode.PercentOutput, speed);
    rightFront.set(ControlMode.PercentOutput, speed);
  }

  /** Stop the motor. */
  public void stop() {
    setSpeeds(0);
  }

  /** Log the motor's percent output to Smart Dashboard. */
  public void log() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
  }

  public double getPosition() {
    // use ticksToMeters to get the position
    return 0;
  }

  // unit conversions from ticks to meters
  public  double ticksToMeters(double ticks) {
    return 0;
  }
}
