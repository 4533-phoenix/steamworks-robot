package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.commands.DriveWithDistanceReading;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleDriveStationAutonomous extends CommandGroup{

    public MiddleDriveStationAutonomous() {
        addSequential(new DriveWithDistanceReading(.25, 20, Robot.FRONT));
    }

}
