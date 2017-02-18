package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class NewAutoForward extends Command {
	private DriveSystem drive;

	private static double DEFAULT_DRIVE_SPEED;

	public NewAutoForward(double speed) {
		this.drive = DriveSystem.getInstance();
		requires(this.drive);
		DEFAULT_DRIVE_SPEED = speed;
	}

	@Override
	protected void end() {
		this.drive.stop();
	}

	@Override
	protected void execute() {
		this.drive.forward(DEFAULT_DRIVE_SPEED);
	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		boolean finished = false;
		SensorData data = SensorUtilities.interpretSerial();

		
		if (data.getName() == "LIDAR" && data.getUnit() == "cm") {
			int distance = Integer.parseInt(data.getValue());
			int target = RobotMap.LIDAR_DISTANCE_IN + 10;
			finished = (distance > target);
		}
		
		return finished;
	}
}
