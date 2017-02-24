package org.usfirst.frc.team4533.robot.autonomous;

import org.usfirst.frc.team4533.robot.commands.AutoRotate;
import org.usfirst.frc.team4533.robot.commands.TimeDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveInBox extends CommandGroup {

    public DriveInBox() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	addSequential(new TimeDriveForward(2,.3));
    	addSequential(new TimeDriveForward(0.5,0));
    	addSequential(new AutoRotate(90));
    	addSequential(new TimeDriveForward(2,.3));
    	addSequential(new TimeDriveForward(0.5,0));
    	addSequential(new AutoRotate(90));
    	addSequential(new TimeDriveForward(2,.3));
    	addSequential(new TimeDriveForward(0.5,0));
    	addSequential(new AutoRotate(90));
    	addSequential(new TimeDriveForward(2,.3));
    	addSequential(new TimeDriveForward(2,0));
    	addSequential(new AutoRotate(90));
    }
}
