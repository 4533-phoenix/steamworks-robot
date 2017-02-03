
package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static DriveSystem INSTANCE;
	
	private CANTalon leftMaster;
	private CANTalon rightMaster;
	private CANTalon leftSlave;
	private CANTalon rightSlave;
	
	private static final double DEFAULT_SPEED_ADJUSTMENT = 1;
	
	private DriveSystem() {
		leftMaster = new CANTalon(RobotMap.Motor_Left_Master);
		rightMaster = new CANTalon(RobotMap.Motor_Right_Master);
		
		leftSlave = new CANTalon(RobotMap.Motor_Left_Slave);
		leftSlave.changeControlMode(TalonControlMode.Follower);
		leftSlave.set(RobotMap.Motor_Left_Master);
		
		rightSlave = new CANTalon(RobotMap.Motor_Right_Slave);
		rightSlave.changeControlMode(TalonControlMode.Follower);
		rightSlave.set(RobotMap.Motor_Right_Master);
	}
	
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new DriveSystem();
		}
	}
	
	public static DriveSystem getInstance() {
		return INSTANCE;
	}
	
	public void drive(double left, double right) {
		this.leftMaster.set(left*DEFAULT_SPEED_ADJUSTMENT);
		this.leftSlave.set(RobotMap.Motor_Left_Master);
		this.rightMaster.set(-right*DEFAULT_SPEED_ADJUSTMENT);
		this.rightSlave.set(RobotMap.Motor_Right_Master);
	}
	
	public void DriveWithJoystick(Joystick driver) {
		this.drive(driver.getY(), driver.getRawAxis(5));
	}
	
	public void forward(double value) {
		this.drive(value, value);
	}
	
	public void forward() {
		this.forward(1.0);
	}
	
	public void backward(double value) {
		this.drive(value, value);
	}
	
	public void backward() {
		this.backward(-1.0);
	}
	
	public void stop() {
		this.drive(0.0, 0.0);
	}
	
	public void turnLeft(double value1, double value2) {
		this.drive(value1, value2);
	}
	
	public void turnLeft() {
		this.turnLeft(-.5, .5);
	}

	public void turnRight(double value1, double value2) {
		this.drive(value1, value2);
	}
	
	public void turnRight() {
		this.turnRight(.5, -.5);
	}
	
    public void initDefaultCommand() {
    	this.setDefaultCommand(new DriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        }
}

