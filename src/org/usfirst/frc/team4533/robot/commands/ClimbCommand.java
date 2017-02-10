package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command{
	private ClimbSystem climber;
	@Override
	protected void execute() {
		this.climber.climb();
	}

	public ClimbCommand() {
		this.climber = ClimbSystem.getInstance();
	}
	@Override
	protected void end(){
		this.climber.brake();
	}
	@Override
	protected boolean isFinished(){
		return false;
	}
	

}
