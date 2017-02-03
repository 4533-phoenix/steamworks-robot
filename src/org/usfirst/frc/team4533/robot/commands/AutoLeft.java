package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.TimedCommand;


/**
 *
 */
public class AutoLeft extends TimedCommand {

	private DriveSystem drive;
	private static double DEFAULT_DRIVE_SPEED;

	public AutoLeft(int duration, double speed) {
		super(duration);
		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
		DEFAULT_DRIVE_SPEED = speed;
	}

	@Override
	protected void end() {
		this.drive.stop();
	}

	@Override
	protected void execute() {
		this.drive.turnLeft(-DEFAULT_DRIVE_SPEED, DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {
	}
}