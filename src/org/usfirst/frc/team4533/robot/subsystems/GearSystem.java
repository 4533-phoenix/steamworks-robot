package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class GearSystem extends Subsystem {
	
	private static GearSystem INSTANCE;
	
	private GearSystem(){
		
	}

	public static void initialize(){
		
		if(INSTANCE == null){
			INSTANCE = new GearSystem();
		}
		
	}
	
	public void initDefaultCommand() {
	
	}
}
