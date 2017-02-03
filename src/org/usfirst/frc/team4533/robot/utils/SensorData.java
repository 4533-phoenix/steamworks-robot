package org.usfirst.frc.team4533.robot.utils;

public class SensorData {
	
	private String name = null;
	private String unit = null;
	private String value = null;

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SensorData(){

	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public String getValue() {
		return value;
	}
	public String toString(){
		StringBuilder build = new StringBuilder();
		build.append("name: ");
		build.append(name);
		build.append("|unit: ");
		build.append(unit);
		build.append("|value: ");
		build.append(value);
		return build.toString();
	}
}