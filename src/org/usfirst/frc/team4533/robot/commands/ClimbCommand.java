package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	private ClimbSystem climber;
	double voltage;
	public ClimbCommand(double volts) {
		requires(Robot.climb);
		voltage = volts;
	}

	@Override
	protected void execute() {
		Robot.climb.climb(voltage);

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
