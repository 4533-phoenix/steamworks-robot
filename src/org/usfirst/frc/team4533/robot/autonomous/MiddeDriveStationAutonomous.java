package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.DriveWithDistanceReading;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddeDriveStationAutonomous extends CommandGroup{

    public MiddeDriveStationAutonomous() {
        addSequential(new DriveWithDistanceReading(.5, 9, -1));
    }

}
