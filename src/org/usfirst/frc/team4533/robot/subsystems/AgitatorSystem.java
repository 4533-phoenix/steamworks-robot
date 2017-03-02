package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AgitatorSystem extends Subsystem {
	
	private static AgitatorSystem INSTANCE;
	Spark agitator;
	public AgitatorSystem() {
		agitator = new Spark(RobotMap.AGITATOR_MOTOR);
	}
	
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new AgitatorSystem();
		}
	}
	
	public static AgitatorSystem getInstance() {
		return INSTANCE;
	}

	public void startAgitator() {
		agitator.set(RobotMap.AGITATOR_SPEED);
	}
	
	public void stopAgitator() {
		agitator.set(0);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
