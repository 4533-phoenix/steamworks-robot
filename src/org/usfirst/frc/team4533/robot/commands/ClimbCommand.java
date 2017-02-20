package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	private ClimbSystem climber;

	public ClimbCommand() {

		requires(Robot.climb);
	}

	@Override
	protected void execute() {
		Robot.climb.climb();

	}

	@Override
	protected void end() {
		Robot.climb.brake();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
