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

	// can
	public static int Motor_Left_Master = 1;
	public static int Motor_Right_Master = 4;
	public static int Motor_Left_Slave = 2;
	public static int Motor_Right_Slave = 3;
	public static int FLY_WHEEL_MOTOR = 5;
	// random stuff
	
	public static int JOYSTICK_PORT = 0;
	public static int LIDAR_DISTANCE_IN = 20;
	public static double DEFAULT_SPEED = .5;
	public static double CLIMB_SPEED = 1;
	public static int JOYSTICK_CLIMB_BUTTON = 2;
	public static double FLY_VOLTAGE = 1;
	public static double AGITATOR_VOLTAGE = 1;
	public static int JOYSTICK_AGITATE_BUTTON = 6;
	public static int JOYSTICK_FLY_WHEEL_BUTTON = 4;

	// pwm
	public static int CLIMB_MOTOR = 0;

	// relay
	public static int AGITATOR_MOTOR = 0;
	
	public static boolean isPractice() {
		return CLIMB_MOTOR == 6;
	}

	public static void setPracticeBot() {
		// can
		Motor_Left_Master = 1;
		Motor_Right_Master = 5;
		Motor_Left_Slave = 2;
		Motor_Right_Slave = 4;
		FLY_WHEEL_MOTOR = 5;
		CLIMB_MOTOR = 6;
		// random stuff
		JOYSTICK_PORT = 0;
		LIDAR_DISTANCE_IN = 20;
		DEFAULT_SPEED = .5;
		CLIMB_SPEED = 1;
		JOYSTICK_CLIMB_BUTTON = 2;
		FLY_VOLTAGE = 1;
		AGITATOR_VOLTAGE = 1;
		JOYSTICK_AGITATE_BUTTON = 6;
		JOYSTICK_FLY_WHEEL_BUTTON = 4;
		

		// PWM
		AGITATOR_MOTOR = 0;

	}
}
