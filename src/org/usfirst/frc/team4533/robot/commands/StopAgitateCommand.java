package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class StopAgitateCommand extends Command{
	private ShooterSystem shooter;
	
	public StopAgitateCommand() {
		this.shooter = ShooterSystem.getInstance();
	}
	
	@Override
	public void execute(){
		this.shooter.stopAgitate();
	}
	
	@Override
	public void end(){
		this.shooter.agitate();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
