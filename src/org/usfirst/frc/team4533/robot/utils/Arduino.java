package org.usfirst.frc.team4533.robot.utils;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.SerialPort;

public class Arduino {
	private static SerialPort serial;
	private static boolean ready = false;
	private static String oldBuffer = "";

	private static final char syncChar = '^';
	private static final char separatorChar = '~';

	/* Initialize serial communications to the Ardunio */
	public static void initialize() {
		serial = new SerialPort(115200, SerialPort.Port.kUSB);
	}

	/*
	 * Returns true if the Arduino is initialized and has read sensor data
	 */
	public static boolean isReady() {
		return ready;
	}

	/*
	 * Read the serial buffer, parse sensor data, and update the Robot's sensor
	 * variables. This should be called periodically.
	 */
	public static void update() {
		String buffer;

		buffer = serial.readString(); // Read all pending data from the serial
										// port into a string
		buffer = oldBuffer + buffer; // Prepend any leftover data from previous
										// reads
		oldBuffer = ""; // Zero out the old buffer

		for (int i = 0; i < buffer.length();) {
			// Ignore any junk characters before we find a sync byte
			if (buffer.charAt(i) != syncChar) {
				i++;
				continue;
			}

			int c = 0;
			int numFields = 0;

			// Process the data packet if we've located a sync byte
			if (buffer.charAt(i) == '^') {
				c = i + 1;

				// Count the number of separator chars we see until we have 3 of
				// them
				while (c < buffer.length() && numFields != 3) {
					if (buffer.charAt(c) == separatorChar) {
						numFields++;
					}
					c++;
				}

				// Check to see if we've seen a complete data packet
				if (numFields == 3) {
					// Split the fields between sync char and the last separator
					// char
					String data[] = buffer.substring(i + 1, c - 1).split(Character.toString(separatorChar));
					// Store the resulting data to our sensor variables
					switch (data[0]) {
					case "LIDAR":
						try {
							Robot.rearDistance = Double.parseDouble(data[2]);
						} catch (NumberFormatException e) {
							continue;
						}
						break;
					case "GYRO":
						try {
							double heading = Double.parseDouble(data[2]);
							if (heading != 0) {
								Robot.heading = heading;
							}
						} catch (NumberFormatException e) {
							continue;
						}
						break;
					case "PIXY":
						Robot.pixyGuidance = data[2];
						break;
					}
				} else {
					// This isn't a complete data packet, so place it in the old
					// buffer so we
					// can process it next time we read from the serial port
					oldBuffer = buffer.substring(i);
				}
			}
			i = c; // There is more data to read, so update the index and keep
					// going
		}
	}
}
