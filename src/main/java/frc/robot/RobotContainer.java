// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController controller = new XboxController(Constants.CONTROLLER_PORT);
  //private final Drivetrain drivetrain = new Drivetrain();
  private final AutoCommand autoCommand = new AutoCommand();
 private final Intake intake = new Intake();
 private final Tower tower = new Tower();
 private final Shooter shooter = new Shooter();
 //private final Climber climber = new Climber();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
//  //   drivetrain.setDefaultCommand(getTeleOpDrive());
//   //  Shuffleboard.getTab("Debug").add("ToggleIntake", new ToggleIntake(intake));
//     Shuffleboard.getTab("Debug").add("ToggleIntakeReverse", new ToggleIntakeReverse(intake));
//     Shuffleboard.getTab("Debug").add("ActivateTower", new ActivateTower(tower));
//     Shuffleboard.getTab("Debug").add("StopTower", new StopTower(tower));
//     Shuffleboard.getTab("Debug").add("ToggleIntakeRotation", new ToggleIntakeRotation(intake));
  
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton speedButton = new JoystickButton(controller, Constants.SPEED_ADJUSTOR_TRIGGER);
   // speedButton.whenPressed(new SpeedAdjustor(drivetrain));

   //JoystickButton climberUpButton = new JoystickButton(controller, Constants.CLIMBER_UP_BUTTON);
   //JoystickButton climberDownButton = new JoystickButton(controller, Constants.CLIMBER_DOWN_BUTTON);
  // JoystickButton climberStopButton = new JoystickButton(controller, Constants.CLIMBER_STOP_BUTTON);
   JoystickButton towerToggleButton = new JoystickButton(controller, Constants.TOWER_TOGGLE_BUTTON);
   JoystickButton shootButton = new JoystickButton(controller, Constants.SHOOT_BOLL_BUTTON);
   JoystickButton intakeToggleButton = new JoystickButton(controller, Constants.INTAKE_TOGGLE_BUTTON);

 //climberUpButton.whenPressed(new RaiseClimber(climber));
 // climberDownButton.whenPressed(new LowerClimber(climber));
 // climberStopButton.whenPressed(new StopClimber(climber));

  shootButton.whenPressed(new SpinShooter(shooter));//toggles shooter
  towerToggleButton.whenPressed(new LoadTower(tower));
  intakeToggleButton.whenPressed(new ToggleIntake(intake));

    
  }

public Command getTeleOpDrive(){
    return null; //TeleOpDrive(drivetrain,() -> controller.getLeftX(), () -> controller.getLeftY(), () -> controller.getRightX());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
