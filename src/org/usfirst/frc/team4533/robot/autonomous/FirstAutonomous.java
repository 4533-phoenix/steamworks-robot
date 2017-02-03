package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.AutoBackwards;
import org.usfirst.frc.team4533.robot.commands.AutoForward;
import org.usfirst.frc.team4533.robot.commands.AutoLeft;
import org.usfirst.frc.team4533.robot.commands.AutoRight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FirstAutonomous extends CommandGroup {
	private static final int DRIVE_FORWARD_DURATION = 2; //There was a change from milliseconds to seconds from 2016 to 2017
	private static final int DRIVE_RIGHT_DURATION = 2;
	//private static final long DRIVE_LEFT_DURATION = 2;
	private static final int DRIVE_LEFT_DURATION = 2;
	private static final int DRIVE_BACKWARDS_DURATION = 2;
	
	public FirstAutonomous() throws InterruptedException {
		this.addSequential(new AutoForward(DRIVE_FORWARD_DURATION, -.5));
		this.addSequential(new AutoRight(DRIVE_RIGHT_DURATION, .5));
		//this.addSequential(new TimedDriveTurnLeft(DRIVE_LEFT_DURATION, 1));
		this.addSequential(new AutoLeft(DRIVE_LEFT_DURATION, .5));
		this.addSequential(new AutoBackwards(DRIVE_BACKWARDS_DURATION, .5));
	}
	
}

