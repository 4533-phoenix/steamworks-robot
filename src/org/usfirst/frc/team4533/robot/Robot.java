
package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4533.robot.subsystems.ShooterSystem;
import org.usfirst.frc.team4533.robot.utils.Arduino;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
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
	
	//public static OI oi;
	public static DriveSystem drive;
	public static ClimbSystem climb;
	public static ShooterSystem shooter;
	public static OI oi;
    private CommandGroup autonomousCommand;
    public SendableChooser seedChooser;
    public static int seed;
    public static int maxSpeed;
    Preferences prefs;

    // Sensors
    public static double heading;       // Arduino : 9DOF Magnetometer
    public static double rearDistance;  // Arduino : LIDAR-LITE v3
    public static String pixyGuidance;  // Arduino : PIXY Camera
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	String bot = "Practice";
    	if (bot.equals("Practice")) {
    		RobotMap.setPracticeBot();
    	}
    	drive = new DriveSystem();
    	climb = new ClimbSystem();
    	shooter = new ShooterSystem();
    	oi = new OI();
    	seedChooser = new SendableChooser();
    	//seedChooser.addDefault("5", );
    	//seedChooser.addObject("1", this.DriveSystem.getControlSpeed(2,4));//seed=1
    	//seedChooser.addObject("2", seed = 2);
    	//seedChooser.addObject("8", seed = 8);
    	prefs = Preferences.getInstance();
    	seed = 5;
    	maxSpeed = 100;
    	
    	// Start up our Arduino data feed
    	Arduino.initialize();
    }
    	
	
    /**
     * This function updates our smart dashboard values. It should probably be called periodically 
     */
    public void updateSmartDashboard() {
        SmartDashboard.putBoolean("Gear", DriveSystem.hasGear());
        SmartDashboard.putBoolean("Climber On?", ClimbSystem.isOn());
        SmartDashboard.putNumber("Front Distance", DriveSystem.ultraSonic());
        String messageOfTheDay = "don't do school stay in drugs";
		SmartDashboard.putString("Message Of The Day", messageOfTheDay);
		SmartDashboard.putString("PIXY", Robot.pixyGuidance);
		SmartDashboard.putNumber("LIDAR", Robot.rearDistance);
		SmartDashboard.putNumber("HEADING", Robot.heading);
    }
    
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
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

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
		Arduino.update();
		updateSmartDashboard();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
		Arduino.update();
		updateSmartDashboard();
    }
}
