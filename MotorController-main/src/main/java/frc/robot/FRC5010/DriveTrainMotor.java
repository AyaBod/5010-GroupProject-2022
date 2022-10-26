// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.FRC5010;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

/** Add your docs here. */
public class DriveTrainMotor implements MotorController5010{
    private MotorController5010 _motor;

    public DriveTrainMotor(MotorController5010 motor){
        this._motor = motor;
    }

    public DriveTrainMotor(MotorController5010 motor, double slewRate){
        this._motor = motor;
        _motor.setSlewRate(slewRate);
    }

    @Override
    public MotorController5010 setSlewRate(double rate){
        _motor.setSlewRate(rate);
        return this;
    }

    @Override
    public void set(double speed) {
        // TODO Auto-generated method stub
        _motor.set(speed);
    }

    @Override
    public double get() {
        // TODO Auto-generated method stub
        return _motor.get();
    }

    @Override
    public void setInverted(boolean isInverted) {
        // TODO Auto-generated method stub
        _motor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        // TODO Auto-generated method stub
        return _motor.getInverted();
    }

    @Override
    public void disable() {
        // TODO Auto-generated method stub
        _motor.disable();
    }

    @Override
    public void stopMotor() {
        // TODO Auto-generated method stub
        _motor.stopMotor();
    }

    @Override
    public MotorController5010 setFollow(MotorController5010 motor) {
        // TODO Auto-generated method stub
        _motor.setFollow(motor);
        return this;
    }

    @Override
    public MotorController5010 invert(boolean inverted) {
        // TODO Auto-generated method stub
        _motor.invert(inverted);
        return this;
    }
    @Override
    public MotorController getMotor() {
        return _motor.getMotor();
    }

    //@Override
    public void factoryDefault() {
        // Not sure if it needs to return anything
        _motor.factoryDefault();
    }
}
