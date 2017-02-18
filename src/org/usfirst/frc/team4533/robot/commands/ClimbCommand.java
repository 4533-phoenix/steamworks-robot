package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command{
	private ClimbSystem climber;
	public ClimbCommand() {
		
		this.climber = ClimbSystem.getInstance();
	}
	
	
	
	@Override
	protected void execute() {
		System.out.println("here");
		climber.climb();
		
	}
	
	@Override
	protected void end() {
		climber.brake();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	

}
