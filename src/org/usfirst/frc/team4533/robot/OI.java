package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
public class OI {
	Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	JoystickButton climbBtn = new JoystickButton(stick, RobotMap.CIRCLE_BUTTON);
	JoystickButton flyBtn = new JoystickButton(stick, RobotMap.RIGHT_BUMPER);
	JoystickButton agitatorBtn = new JoystickButton(stick, RobotMap.RIGHT_TRIGGER);
	JoystickButton agitator = new JoystickButton(stick, RobotMap.LEFT_BUMPER);
	JoystickButton slowClimbButton = new JoystickButton(stick, RobotMap.SQUARE_BUTTON);
	JoystickButton slowDriveButton = new JoystickButton(stick, RobotMap.LEFT_TRIGGER);
	OI() {
		//while held, the climb button makes the robot climb, and then sets the voltage to 0 when the button is released
		climbBtn.whileHeld(new ClimbCommand(1));
		slowClimbButton.whileHeld(new ClimbCommand(0.5));
		//climbBtn.whenReleased(new BrakeCommand());
		flyBtn.toggleWhenPressed(new ShootCommand());
		agitatorBtn.toggleWhenPressed(new AgitatorCommand());
		//testingButton.whenPressed(new AutoRotate(30));
	}
	public static OI getInstance(){
		return INSTANCE;
	}
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new OI();
		}
	}
}
