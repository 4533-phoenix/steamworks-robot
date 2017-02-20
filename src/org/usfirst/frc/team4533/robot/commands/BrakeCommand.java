package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;
import edu.wpi.first.wpilibj.command.Command;

public class BrakeCommand extends Command{
	public BrakeCommand() {
		requires(Robot.climb);
	}
	
	private ClimbSystem climber;
	
	@Override
	protected void execute() {
		Robot.climb.brake();
	}
	
	@Override
	protected boolean isFinished() {
		Robot.climb.brake();
		return false;
	}
	
}
