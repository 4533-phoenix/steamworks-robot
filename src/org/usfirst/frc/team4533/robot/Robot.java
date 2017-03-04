
package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.autonomous.BaselineAutonomous;
import org.usfirst.frc.team4533.robot.autonomous.LeftAutonomous;
import org.usfirst.frc.team4533.robot.autonomous.MiddeDriveStationAutonomous;
import org.usfirst.frc.team4533.robot.autonomous.RightAutonomous;
import org.usfirst.frc.team4533.robot.commands.TimeDriveForward;
import org.usfirst.frc.team4533.robot.subsystems.AgitatorSystem;
import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;
import org.usfirst.frc.team4533.robot.utils.Arduino;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	
	public static DriveSystem drive;
	public static ClimbSystem climb;
	public static ShooterSystem shooter;
	public static AgitatorSystem agitator;
	public static OI oi;
	private CommandGroup autonomousCommand;
    public SendableChooser AutoChooser;
    public static Sendable AutoPosition;
    public static int maxSpeed;
    public static double joystk_deadzone;
    Preferences prefs;
    public static int seed;
    int count;
    
    private PowerDistributionPanel pdp;

    // Sensors
    public static double heading;       // Arduino : 9DOF Magnetometer
    public static double rearDistance;  // Arduino : LIDAR-LITE v3
    public static String pixyGuidance;  //  : PIXY Camera
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	String bot = "Main";
    	if (bot.equals("Practice")) {
    		RobotMap.setPracticeBot();
    	}
    	pdp = new PowerDistributionPanel(10);
    	drive = new DriveSystem();
    	climb = new ClimbSystem();
    	shooter = new ShooterSystem();
    	agitator = new AgitatorSystem();
    	oi = new OI();
    	AutoChooser = new SendableChooser();
    	AutoChooser.addDefault("Middle", new MiddeDriveStationAutonomous());
    	AutoChooser.addObject("Left", new LeftAutonomous());
    	AutoChooser.addObject("Right", new RightAutonomous());
    	AutoChooser.addObject("Baseline", new BaselineAutonomous());
    	AutoChooser.addObject("TimedDriveForward", new TimeDriveForward(2, .5));
    	prefs = Preferences.getInstance();
    	SmartDashboard.putData("Autonomous mode chooser", AutoChooser);
    	maxSpeed = 100;
    	joystk_deadzone = 0.1;
    	count = 0;
//    	autonomousCommand = new DriveInBox();
    	
    	// Start up our Arduino data feed
    	Arduino.initialize();
    	Robot.pixyGuidance = "straight";
    	Robot.rearDistance = 0;
    	Robot.heading = 0;
    	System.out.println("finished robot init");
    	}
    	
	
    /**
     * This function updates our smart dashboard values. It should probably be called periodically 
     */
    public void updateSmartDashboard() {
        SmartDashboard.putBoolean("Gear", DriveSystem.hasGear());
        SmartDashboard.putBoolean("Climber On?", ClimbSystem.isOn());
        SmartDashboard.putNumber("Front Distance", DriveSystem.ultraSonic());
		SmartDashboard.putString("PIXY", Robot.pixyGuidance);
		SmartDashboard.putNumber("LIDAR", Robot.rearDistance);
		SmartDashboard.putNumber("HEADING", Robot.heading);
		
		SmartDashboard.putNumber("PDP 12:", pdp.getCurrent(12));
		SmartDashboard.putNumber("PDP 13:", pdp.getCurrent(13));
		SmartDashboard.putNumber("PDP 14:", pdp.getCurrent(14));
		SmartDashboard.putNumber("PDP 15", pdp.getCurrent(15));
    }
    
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	if(count++ % 10 == 0){
    		System.out.println("disabled init  " + count);
    	}
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
		if(count++ % 10 == 0){
			System.out.println("disabled periodic " + count);
		}
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	this.autonomousCommand = (CommandGroup) AutoChooser.getSelected();
//    	this.autonomousCommand = new TimeDriveForward(2, 0.5);

    			//new DefaultAutonomous();	

        this.autonomousCommand.start();	
		if(count++ % 10 == 0){
			System.out.println("autonomous init  " + count);
		}
	}
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
		if(count++ % 10 == 0){
			System.out.println("autonomous periodic " + count);
		}
	}

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null){
        	autonomousCommand.cancel();
        }
		if(count++ % 10 == 0){
			System.out.println("teleop init  " + count);
		}
	}

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
		if(count++ % 10 == 0){
			System.out.println("teleop periodic " + count);
		}		
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
		Arduino.update();
		updateSmartDashboard();
		if(count++ % 10 == 0){
			System.out.println("test periodic " + count);
		}

    }
}
