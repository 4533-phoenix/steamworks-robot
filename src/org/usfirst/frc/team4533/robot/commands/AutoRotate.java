package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoRotate extends Command {

	boolean direction;
	double toRotate;
	double startHeading;
	
	public static final boolean RIGHT = true;
	public static final boolean LEFT = false;
	//Accepts a certain degree as a parameter and a direction via AutoRotate.LEFT/RIGHT
	public AutoRotate(double deg, boolean direct) {
		requires(Robot.drive);
		this.toRotate = deg;
		this.direction = direct;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startHeading = Robot.heading;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (direction == AutoRotate.RIGHT) {
			Robot.drive.turnRight(.25, -.25);
		} else if (direction == AutoRotate.LEFT) {
			Robot.drive.turnLeft(-.25, .25);
		}
		else{
			Robot.drive.turnRight(.25, -.25);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double currentHeading = Robot.heading;

		double offset = Math.floorMod((long) Math.abs(currentHeading - startHeading), (long) 360);
		if (offset > 180) {
			offset = Math.abs(offset - 360);
		}
		if (offset > Math.abs(toRotate)) {
			System.out.println("Beep boop! Stopping rotation at " + offset + "@ degree " + currentHeading + " from a starting heading of "
					+ startHeading + " and a desire rotation of " + toRotate + "...");
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
