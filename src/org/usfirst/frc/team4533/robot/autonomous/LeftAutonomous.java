package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.AutoRotate;
import org.usfirst.frc.team4533.robot.commands.DriveWithDistanceReading;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutonomous extends CommandGroup {
    
    public  LeftAutonomous() {
    	addSequential(new DriveWithDistanceReading(.5,-1, 200));
    	addSequential(new AutoRotate(60));
    	addSequential(new DriveWithDistanceReading(.5, 9, -1));
    }
}
