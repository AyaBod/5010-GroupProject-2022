// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.FRC5010;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

/** Add your docs here. */
public interface MotorController5010 extends MotorController{
    MotorController5010 setSlewRate(double rate);
    MotorController5010 setFollow(MotorController5010 motor);
    MotorController5010 invert(boolean inverted);
    MotorController getMotor();
    void factoryDefault();
}
