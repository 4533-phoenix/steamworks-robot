#include <Adafruit_Sensor.h>
#include <Adafruit_LSM303_U.h>
#include <Adafruit_9DOF.h>
#include <Adafruit_L3GD20_U.h>
#include <SPI.h>
#include <Pixy.h>
#include <LIDARLite.h>
#include <Wire.h>
#include <Timer.h>

#define X_CENTER ((PIXY_MAX_X-PIXY_MIN_X)/2)
int ultrasonicpin = 0;
//Pixy pixy;
LIDARLite lidar;
uint16_t blocks;
boolean debug = false;
Timer t;
String gyroPrint;
Adafruit_9DOF                dof   = Adafruit_9DOF();
Adafruit_LSM303_Mag_Unified   mag   = Adafruit_LSM303_Mag_Unified(30302);
int i;

double readUltraSonic() {
  double total = 0;
  for(i = 0; i < 50; i++) {
    total += analogRead(ultrasonicpin);
  }
  // UltraSonic analog values are (Vcc/512) per inch and analogRead
  // is 0-1023 @ 5V, so divide by 2 for per-inch reading. Multiply by
  // 2.54 to convert inches to centimeters.
  return ((total / 50.0) / 2.0) * 2.54;
}

void printData() {
  sensors_vec_t orientation;
  sensors_event_t mag_event;
  int dif;
  blocks = -1;
  char buffer[100];
//  blocks = pixy.getBlocks();
//  // PIXY STUFF
//  String dir;
  static int i = 0;
//  int CenterOfBlocks;
  char buf[7];
//
//  if (blocks) {
//    //Serial.println("Block Count: " + String(blocks));
//    if (blocks == 1) {
//      CenterOfBlocks = pixy.blocks[0].x;
//    } else if (blocks == 2) {
//      CenterOfBlocks = (pixy.blocks[0].x + pixy.blocks[1].x) / 2;
//    } else {
//      CenterOfBlocks = 0;
//    }
//    //if (blocks == 1 || blocks == 2) {
//    dif = X_CENTER - CenterOfBlocks;
//    if (dif < -5) {
//      sprintf(buffer, "^%s~%s~%s~", "PIXY", "direction", "right");
//      Serial.write(buffer);
//    } else if (dif > 5) {
//      sprintf(buffer, "^%s~%s~%s~", "PIXY", "direction", "left");
//      Serial.write(buffer);
//    } else {
//      sprintf(buffer, "^%s~%s~%s~", "PIXY", "direction", "straight");
//      Serial.write(buffer);
//    }
//    if (debug) {
//      Serial.println("");
//    }
//
//  }
  dtostrf(readUltraSonic(), 5, 2 , buf);
  sprintf(buffer, "^%s~%s~%s~", "ULTRASONIC", "cm", buf);
  Serial.write(buffer);
  if (debug) {
    Serial.println("");
  }

  //LIDAR STUFF
  sprintf(buffer, "^%s~%s~%d~", "LIDAR", "cm", lidar.distance());
  Serial.write(buffer);
  if (debug) {
    Serial.println("");
  }

  mag.getEvent(&mag_event);
  if (dof.magGetOrientation(SENSOR_AXIS_Z, &mag_event, &orientation))
  {
    dtostrf(orientation.heading, 5, 2 , buf);
    sprintf(buffer, "^%s~%s~%s~", "GYRO", "heading", buf);
    Serial.write(buffer);
  }
  if (debug) {
    Serial.println("");
  }
}

void setup() {
  Serial.begin(115200);
//  pixy.init();
  if (debug) {
    Serial.println("PIXY ONLINE");
  }
  lidar.begin(0, true);
  if (debug) {
    Serial.println("LIDAR ONLINE");
  }
  mag.begin();
  if (debug)
  {
    Serial.println("GYRO ONLINE");
  }
  t.every(15, printData);

}

void loop() {

  t.update();

}
