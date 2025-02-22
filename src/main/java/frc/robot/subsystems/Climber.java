// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
 // private final PWMSparkMax leftClimber = new PWMSparkMax(Constants.LEFT_CLIMBER_PORT);
  private final PWMSparkMax rightClimber = new PWMSparkMax(Constants.RIGHT_CLIMBER_PORT);
  // private ShuffleboardTab tab = Shuffleboard.getTab("Debug");
  // private NetworkTableEntry leftClimberDisplay = tab.add("Left Climber Display: ", 0.0).getEntry();
  // private NetworkTableEntry rightClimberDisplay = tab.add("Right Climber Display: ", 0.0).getEntry();
  // private final SendableChooser<Double> climberToggle = new SendableChooser<Double>();
  /** Creates a new Climber. */
  public Climber() {
    // climberToggle.setDefaultOption("go climb ", 0.1);
    // climberToggle.setDefaultOption("un climb ", -0.1);
    // climberToggle.setDefaultOption("no climb no", 0.0);
    // tab.add(climberToggle);
  }

  public void setSpeed(double speed){
    SmartDashboard.putNumber("Climber speed bghhf", speed);
   // leftClimber.set(speed);
    rightClimber.set(speed);
  //  SmartDashboard.putNumber("LeftClimber Speed Read", leftClimber.get());
  }

  public void lowerClimber(){
   // leftClimber.set(.5);
    rightClimber.set(.5);
  }

  public void raiseClimber(){
   // leftClimber.set(-.5);
    rightClimber.set(-.5);
  }

  public void stopClimber(){
  //  leftClimber.set(0);
    rightClimber.set(0);
  }

  public double getSpeedLeft(){
  //  return leftClimber.get();
  return 0.0;
  }
  
  public double getSpeedRight(){
    return rightClimber.get();
  }

  @Override
  public void periodic() {
    //leftClimberDisplay.setDouble(getSpeedLeft());
    //rightClimberDisplay.setDouble(getSpeedRight());
    //setSpeed(climberToggle.getSelected());
    // This method will be called once per scheduler run

    
  }
}
