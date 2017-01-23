package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	
	CANTalon rightMaster;
	CANTalon leftMaster; 
	CANTalon leftSlave;
	CANTalon rightSlave;
	
	/*Note on Master/Slave Drivestyle-
	 * This works by initiating all four motors (right master & slave, left master & slave), 
	 * then setting the two slave motors to follow input from their masters
	 * 
	 */
	private DriveSystem(){
		//this sets the right master motor channel 
		rightMaster = new CANTalon(RobotMap.RIGHT_MASTER_MOTOR);
		//this sets the left master motor channel
		leftMaster = new CANTalon(RobotMap.LEFT_MASTER_MOTOR);
		
		//sets the right slave motor channel 
		rightSlave = new CANTalon(RobotMap.RIGHT_SLAVE_MOTOR);
		//changes the control mode to follower of the master motor
		rightSlave.changeControlMode(TalonControlMode.Follower);
		//sets the master motor to the right master
		rightSlave.set(RobotMap.RIGHT_MASTER_MOTOR);
		//sets the left slave motor channel
		leftSlave = new CANTalon(RobotMap.LEFT_SLAVE_MOTOR);
		//changes the control mode to be a follower of the master motor 
		leftSlave.changeControlMode(TalonControlMode.Follower);
		//sets the master motor to the left master
		leftSlave.set(RobotMap.LEFT_MASTER_MOTOR);
	}
	
	
	public void drive(double left, double right){
		this.leftMaster.set(left);
		this.rightMaster.set(right);
		this.leftSlave.set(RobotMap.LEFT_MASTER_MOTOR);
		this.rightSlave.set(RobotMap.RIGHT_MASTER_MOTOR);
	}

	public static void initialize(){
		
		if(INSTANCE == null){
			INSTANCE = new DriveSystem();
		}
		
	}
	
	public void initDefaultCommand() {
	
	}
}
