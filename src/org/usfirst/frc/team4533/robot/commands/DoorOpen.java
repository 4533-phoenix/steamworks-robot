package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.command.Command;

public class DoorOpen extends Command {
	
	private ShooterSystem shooter;
	
	public DoorOpen() {
		this.shooter = ShooterSystem.getInstance();
	}
	
	@Override
	public void execute() {	
		this.shooter.openDoor();
	}
	
	@Override
	public void end() {
		this.shooter.closeDoor();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
