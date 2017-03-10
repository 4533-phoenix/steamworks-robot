package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.AutoRotate;
import org.usfirst.frc.team4533.robot.commands.DriveWithDistanceReading;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutonomous extends CommandGroup {
    
    public  LeftAutonomous() {
    	addSequential(new DriveWithDistanceReading(.3,-1, 173));
    	addSequential(new AutoRotate(120, AutoRotate.LEFT));
    	addSequential(new DriveWithDistanceReading(.3, 9, -1));
    }
}
