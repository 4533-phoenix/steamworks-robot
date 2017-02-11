
package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static ClimbSystem INSTANCE;
	
	Spark climbMotor;
	
	private ClimbSystem() {
		climbMotor = new Spark(RobotMap.CLIMB_MOTOR);
	}
	
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new ClimbSystem();
		}
	}
	
	public static ClimbSystem getInstance() {
		return INSTANCE;
	}
	
	public void climb() {
		climbMotor.set(RobotMap.CLIMB_SPEED);
	}
	public void brake() {
		climbMotor.set(0);
	}
	
	public boolean ready() {
		return false;
	}
	    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        }
}

