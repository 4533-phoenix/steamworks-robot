package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSystem extends Subsystem {
	
	private static ShooterSystem INSTANCE;
	CANTalon flyWheel;
	Relay agitator;
	private ShooterSystem() {
		//flyWheel = new CANTalon(RobotMap.FLY_WHEEL_MOTOR);
		agitator = new Relay(RobotMap.AGITATOR_MOTOR);
		flyWheel = new CANTalon(RobotMap.FLY_WHEEL_MOTOR);
	}
	
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new ShooterSystem();
		}
	}
	
	public static ShooterSystem getInstance() {
		return INSTANCE;
	}
	
	public void agitate() {
		agitator.set(Relay.Value.kOn);
	}
	public void startFlywheel() {
		flyWheel.set(RobotMap.FLY_VOLTAGE);
	}
	
	public void stopAgitate() {
		agitator.set(Relay.Value.kOff);
	}
	
	public void stopFlywheel() {
		flyWheel.set(0);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
