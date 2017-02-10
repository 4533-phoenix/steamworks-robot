package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class StopAgitateCommand extends Command{
	private ShooterSystem shooter;
	
	@Override
	public void execute(){
		shooter.stopAgitate();
	}
	
	@Override
	public void end(){
		shooter.agitate();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
