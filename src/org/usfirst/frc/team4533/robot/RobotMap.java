package org.usfirst.frc.team4533.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static final int Motor_Left_Master = 1;
	public static final int Motor_Right_Master = 5;
	public static final int Motor_Left_Slave = 2;
	public static final int Motor_Right_Slave = 4;
	public static final int JOYSTICK_PORT = 0;
	public static final int LIDAR_DISTANCE_IN = 20;
	public static final double DEFAULT_SPEED = .5;
	public static final int CLIMB_MOTOR = 6;
	public static final double CLIMB_SPEED = 1;
	public static final int JOYSTICK_CLIMB_BUTTON = 2;
//	public static final int FLY_WHEEL_MOTOR = //CANTALON; //was 7 but we dont have a 7
	public static final int AGITATOR_MOTOR = 8;
	public static final double FLY_VOLTAGE = 1;
	public static final double AGITATOR_VOLTAGE = .5;
	public static final int JOYSTICK_AGITATE_BUTTON = 8;
	public static final int JOYSTICK_FLY_WHEEL_BUTTON = 4;
	//public static final int INTAKE_MOTOR = //A Spark;
}
