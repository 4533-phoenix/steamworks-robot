package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.DriveWithDistanceReading;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineAutonomous extends CommandGroup{

    public BaselineAutonomous() {
        addSequential(new DriveWithDistanceReading(-.5, -1, 350));
    }

}
