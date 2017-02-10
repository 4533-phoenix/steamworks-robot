package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class AgitateCommand extends Command{
	private ShooterSystem shooter;
	@Override
	public void execute(){
		shooter.agitate();
	}
	@Override
	public void end(){
		shooter.stopAgitate();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
