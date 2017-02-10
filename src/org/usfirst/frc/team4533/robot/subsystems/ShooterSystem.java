package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSystem extends Subsystem {
	
	private static ShooterSystem INSTANCE;
	CANTalon flyWheel;
	Spark agitator;
	private ShooterSystem() {
		//flyWheel = new CANTalon(RobotMap.FLY_WHEEL_MOTOR);
		agitator = new Spark(RobotMap.AGITATOR_MOTOR);
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
		agitator.set(RobotMap.AGITATOR_VOLTAGE);
	}
	public void shoot() {
		flyWheel.set(RobotMap.FLY_VOLTAGE);
	}
	
	public void stopAgitate() {
		agitator.set(0);
	}
	
	public void stopShoot() {
		flyWheel.set(0);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
