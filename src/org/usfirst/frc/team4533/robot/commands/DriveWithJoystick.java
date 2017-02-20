package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {
	private Joystick driver;
	
	public DriveWithJoystick() {
		driver = new Joystick(RobotMap.JOYSTICK_PORT);
		requires(Robot.drive);
	}
	
	protected void execute() {
		Robot.drive.DriveWithJoystick(this.driver);
	}
	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
