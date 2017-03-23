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
	public static boolean useRampedDriving = false;
	public static boolean useTurboTrigger = true;
	public static int RIGHT_TRIGGER = 8;
	public static int RIGHT_BUMPER = 6;
	public static int LEFT_TRIGGER = 7;
	public static int LEFT_BUMPER = 5;
	public static int Y_BUTTON = 4;
	public static int B_BUTTON = 3;
	public static int A_BUTTON = 2;
	public static int RIGHT_STICK_BUTTON = 12;
	public static int LEFT_STICK_BUTTON = 11;
	public static int BACK_BUTTON = 9;
	public static int START_BUTTON = 10;
	public static int TRIANGLE_BUTTON = 1;
	public static int CIRCLE_BUTTON = 2;
	public static int X_BUTTON = 3;
	public static int SQUARE_BUTTON = 4;
	
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
	public static double FLY_VOLTAGE = 1;
	public static double AGITATOR_SPEED = 0.8;

	// pwm
	public static int CLIMB_MOTOR = 0;
	public static int AGITATOR_MOTOR = 1;
	
	//DIO
	public static int GEAR_SENSOR = 9;
	
	//AIO
	public static int FRONT_SENSOR_PORT = 3; //Ultrasonic Sensor
	
	//Relay
	//public static int AGITATOR_MOTOR = 0;
	
	public static boolean isPractice() {
		return CLIMB_MOTOR == 6;
	}

	public static void setPracticeBot() {
		// can
		Motor_Left_Master = 1;
		Motor_Right_Master = 5;
		Motor_Left_Slave = 2;
		Motor_Right_Slave = 4;
		FLY_WHEEL_MOTOR = 3;
		CLIMB_MOTOR = 6;
		// random stuff
		JOYSTICK_PORT = 0;
		LIDAR_DISTANCE_IN = 20;
		DEFAULT_SPEED = .5;
		CLIMB_SPEED = 1;
		FLY_VOLTAGE = 1;
	}
}
