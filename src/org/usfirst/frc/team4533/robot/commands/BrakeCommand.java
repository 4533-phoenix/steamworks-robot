package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;
import edu.wpi.first.wpilibj.command.Command;

public class BrakeCommand extends Command{
	public BrakeCommand() {
		climber = ClimbSystem.getInstance();
	}
	
	private ClimbSystem climber;
	
	@Override
	protected void execute() {
		climber.brake();
	}
	
	@Override
	protected boolean isFinished() {
		climber.brake();
		return false;
	}
	
}
