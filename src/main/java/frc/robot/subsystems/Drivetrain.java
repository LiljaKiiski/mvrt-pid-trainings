// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  public TalonFX motor1;
  public TalonFX motor2;
  public TalonFX motor3;
  public TalonFX motor4;

  private double kWheelCircumference = 6 * Math.PI;
  private double kTicksPerRotation = 2048;
  private double kGearRatio = 12.78;

  /** Creates a new DriveTrain. */
  public Drivetrain() {
    motor1 = new TalonFX(0);
    motor2 = new TalonFX(0);
    motor3 = new TalonFX(0);
    motor4 = new TalonFX(0);
    motor1.configFactoryDefault(0);
    motor2.configFactoryDefault(0);
    motor3.configFactoryDefault(0);
    motor4.configFactoryDefault(0);
    motor3.setInverted(true);
    motor4.setInverted(true);
    motor1.setInverted(false);
    motor2.setInverted(false);
    motor2.follow(motor1);
    motor4.follow(motor3);

    resetEncoders();
  }

  public void resetEncoders() {
    motor1.setSelectedSensorPosition(0);
    motor2.setSelectedSensorPosition(0);
    motor3.setSelectedSensorPosition(0);
    motor4.setSelectedSensorPosition(0);
  }
  
  public double ticksToMeters(){
    double rotations = motor1.getSelectedSensorPosition() / kTicksPerRotation;
    double wheelRotations = rotations / kGearRatio;
    double meters = wheelRotations * Units.inchesToMeters(kWheelCircumference);
    return meters;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    motor1.set(ControlMode.PercentOutput, speed);
    motor3.set(ControlMode.PercentOutput, speed);
  }
}
