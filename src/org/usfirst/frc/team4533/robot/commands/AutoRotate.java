package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoRotate extends Command {

	boolean positive = true;
	double degree;
	double startHeading;

	public AutoRotate(double deg) {
		requires(Robot.drive);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		degree = deg;
		if (deg > 0) {
			positive = true;
		} else {
			positive = false;
		}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startHeading = Robot.heading;
		SmartDashboard.putNumber("start heading", startHeading);
		System.out.println("start heading: " + startHeading);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (positive) {
			Robot.drive.turnRight(.25, -.25);

		} else {
			Robot.drive.turnLeft(-.25, .25);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		int sign = 1;
		double heading = Robot.heading;

		// if (heading < startHeading) { sign = -1; }
		// offset = sign * (Math.floorMod((int) Math.abs(heading -
		// startHeading), 360));
		// SmartDashboard.putNumber("offset", offset);
		int offset = Math.floorMod((int) Math.abs(heading - startHeading), 360);
		if (offset > 180) {
			offset = Math.abs(offset - 360);
		}
		if (degree < 0 && offset < degree) {
			System.out.println(offset);
			return true;
		} else if (degree > 0 && offset > degree) {
			System.out.println(offset);
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
