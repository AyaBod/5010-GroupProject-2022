// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.FRC5010.MotorController5010;
import frc.robot.FRC5010.MotorFactory;
import frc.robot.FRC5010.Controller;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private MotorController5010 motor1, motor2, motor3, motor4, motor5, motor6;
  private DifferentialDrive drive;
  private Controller driver;
  private DrivetrainSubsystem driveTrain;
  private CANSparkMax motor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    driver = new Controller(0);
    driver.setLeftYAxis(driver.createLeftYAxis().deadzone(.075).cubed().negate().limit(1));
    driver.setRightXAxis(driver.createRightXAxis().deadzone(.075).limit(1));
    motor1 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(1));
    motor2 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(2).setFollow(motor1));
    motor3 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(3).setFollow(motor1));
    motor4 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(4).invert(true));
    motor5 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(5).setFollow(motor4));
    motor6 = MotorFactory.DriveTrainMotor(MotorFactory.NEO(6).setFollow(motor4));


    drive = new DifferentialDrive(motor1, motor4);
    driveTrain = new DrivetrainSubsystem(drive);
    driveTrain.setDefaultCommand(new FunctionalCommand(() -> {}, () -> driveTrain.arcadeDrive(driver.getLeftYAxis(), driver.getRightXAxis()), (interrupt) -> driveTrain.arcadeDrive(0,0), () -> false, driveTrain));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
