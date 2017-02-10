package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {
	private DriveSystem drive;
	private Joystick driver;
	
	public DriveWithJoystick() {
		this.drive = DriveSystem.getInstance();
		driver = new Joystick(RobotMap.JOYSTICK_PORT);
		this.requires(drive);
	}
	
	protected void execute() {
		this.drive.DriveWithJoystick(this.driver);
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
