package org.usfirst.frc.team4533.robot.utils;

import edu.wpi.first.wpilibj.SerialPort;

public class SensorUtilities {
	private static final byte syncByte = 94;
	private static final byte endSec = 126;
	

	public static SensorData interpretSerial() throws NoSignalException{
		SerialPort sPort = new SerialPort(74880, SerialPort.Port.kUSB);
		SensorData data = new SensorData();
		String name = "";
		String unit = "";
		String value = "";
		int i = 0;
		//find syncbyte (caret)
		byte curr = 0x00;
		
		while(curr != syncByte) {
			try{
				curr = sPort.read(1)[0];
			} catch(Exception e){
				throw new NoSignalException();
			}
		}
		//find the name from the serial 
		curr = sPort.read(1)[0];
		while(curr != endSec){
			name += (char)curr;
			curr = sPort.read(1)[0];
		}
		data.setName(name);
		
		//find the unit
		curr = sPort.read(1)[0];
		while(curr != endSec){
			unit += (char)curr;
			curr = sPort.read(1)[0];
		}
		data.setUnit(unit);
		
		//find the value
		curr = sPort.read(1)[0];
		while(curr != endSec){
			value += (char)curr;
			curr = sPort.read(1)[0];
		}
		data.setValue(value);
		
		return data;		
	}
	
}
