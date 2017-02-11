package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {
	public ShootCommand() {
		this.shooter = ShooterSystem.getInstance();
	}
	
	private ShooterSystem shooter;
	
	@Override
	public void execute(){
		this.shooter.startFlywheel();
	}
	
	@Override
	public void end() {
		this.shooter.stopFlywheel();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
