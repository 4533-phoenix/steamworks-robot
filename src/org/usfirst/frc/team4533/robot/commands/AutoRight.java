package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class AutoRight extends Command {
	private DriveSystem drive;
	private static double DEFAULT_DRIVE_SPEED;
	
	public AutoRight(double speed) {
		
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
		this.drive.turnRight(DEFAULT_DRIVE_SPEED, -DEFAULT_DRIVE_SPEED);
	}
	
	@Override
	protected void interrupted() {
	}
	
	@Override
	protected boolean isFinished(){
		SensorData data = SensorUtilities.interpretSerial();

		if (data.getName() == "PIXY" && data.getUnit() == "direction"){
			return data.getValue().equals("right");
			}
		return false;
	}
}
