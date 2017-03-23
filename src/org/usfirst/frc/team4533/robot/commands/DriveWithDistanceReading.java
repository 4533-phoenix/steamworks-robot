package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithDistanceReading extends Command {
	private final double speed;
	private double distance;
	private int direction;
	
	public DriveWithDistanceReading(double speed, double distance, int direction) {
		this.speed = speed;
		this.distance = distance;
		this.direction = direction;
		requires(Robot.drive);
	}


	protected void execute() {
		Robot.drive.forward(this.speed);
	}


	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		Robot.drive.stop();
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected boolean isFinished() {
		if(direction == Robot.FRONT){
			return (Robot.frontDistance < distance);
		}else if(direction == Robot.REAR){
			return (Robot.rearDistance > distance);
		}

		return false;
	}
}
