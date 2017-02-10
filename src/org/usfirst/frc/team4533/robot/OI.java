package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.commands.AgitateCommand;
import org.usfirst.frc.team4533.robot.commands.BrakeCommand;
import org.usfirst.frc.team4533.robot.commands.ClimbCommand;
import org.usfirst.frc.team4533.robot.commands.ShootCommand;
import org.usfirst.frc.team4533.robot.commands.StopAgitateCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
public class OI {
	Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	JoystickButton climbBtn = new JoystickButton(stick, RobotMap.JOYSTICK_CLIMB_BUTTON);
	JoystickButton agitateBtn = new JoystickButton(stick, RobotMap.JOYSTICK_AGITATE_BUTTON);
	JoystickButton flyBtn = new JoystickButton(stick, RobotMap.JOYSTICK_FLY_WHEEL_BUTTON);
	private OI() {
		//while held, the climb button makes the robot climb, and then sets the voltage to 0 when the button is released
		climbBtn.whileHeld(new ClimbCommand());
		climbBtn.whenReleased(new BrakeCommand());
		agitateBtn.whenPressed(new AgitateCommand());
		agitateBtn.whenReleased(new StopAgitateCommand());
		flyBtn.toggleWhenPressed(new ShootCommand());
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
