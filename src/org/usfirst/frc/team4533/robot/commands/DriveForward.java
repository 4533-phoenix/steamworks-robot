package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
//Imports the DriveSystem in the subsystems folder

import edu.wpi.first.wpilibj.command.Command;
//Imports the command class from the first api

public class DriveForward extends Command{ //This new command allows the robot to move forward
	private DriveSystem drive; //Creates an instance variable (correct us if we are wrong) called drive
	private final double speed;//Same concept but for speed that is in a -1 to 1 range and can not be changed in this class
	
	public DriveForward(double speed) { //Reuses the DriveForward command in DriveSystem
		this.speed = speed; //Creates a variable speed that is equal to speed
		this.drive = DriveSystem.getInstance(); // this.drive returns INSTANCE
	}
	
	protected void execute() { //Executing drive.forward
		this.drive.forward(this.speed);
	}
	
	protected void end() { //Ends driving forward
		this.drive.stop();
	}
	
	protected void interrupted() { //If interrupted the robot will stop
		this.drive.stop();
	}
	
	@Override
	protected void initialize() { //Initialize
		
	}
	
	@Override
	protected boolean isFinished() { //When the timer reaches 0 the boolean returns false and we can't drive forward
		return false;
	}
}
