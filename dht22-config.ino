#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>

#define DHTPIN 2
#define DHTTYPE DHT22

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  float hum = dht.readHumidity();
  float temp = dht.readTemperature();

  Serial.print(temp);
  Serial.print(",");
  Serial.println(hum);

  delay(30000);
}
