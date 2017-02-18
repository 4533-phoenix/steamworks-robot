package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4533.robot.utils.SensorData;
import org.usfirst.frc.team4533.robot.utils.SensorUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	private SensorData data;
	private DriveSystem drive;
	
	public AutoDrive()  {
	}

	@Override
	protected void end() {
		this.drive.stop();
	}
	@Override
	protected void execute() {
	
	}
	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		int distance = 0;
		if (data.getName().equals("LIDAR") && data.getUnit().equals("cm")) {
			distance = Integer.parseInt(data.getValue());
		}
		
		return (distance > 150);
	}
	public Command drive() {
		double spd = RobotMap.DEFAULT_SPEED;
		double turnSpeed = RobotMap.DEFAULT_SPEED / 2;
		data = SensorUtilities.interpretSerial();
		this.drive = DriveSystem.getInstance();
		this.requires(this.drive);
		if (data.getName() == "PIXY" && data.getUnit() == "direction") {
			if (data.getValue() == "right") {
				this.drive.drive(spd, turnSpeed);
			} else if (data.getValue() == "left") {
				this.drive.drive(turnSpeed, spd);
			} else {
				this.drive.drive(spd, spd);
			}
		} else if(data.getName().equals("LIDAR") && data.getUnit().equals("cm")){
			while(Integer.parseInt(data.getValue()) < 150){
				this.drive.drive(spd, spd);
			}
			this.drive.drive(0, 0);;			
		}else{
			System.out.println("ERROR: incorrect data format");
			System.out.println("NAME: " + data.getName() + "||UNIT: " + data.getUnit() + "||VALUE: " + data.getValue());
		}
		return this;
	}
}
