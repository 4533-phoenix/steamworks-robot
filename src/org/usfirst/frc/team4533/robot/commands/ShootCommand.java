package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command{
	ShooterSystem shooter;
	@Override
	public void execute(){
	//	shooter.shoot();
	}
	
	@Override
	public void end(){
		shooter.stopShoot();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
