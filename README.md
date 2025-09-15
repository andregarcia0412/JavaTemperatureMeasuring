# 🌡️ Java Temperature Measuring

Temperature and humidity monitoring system using **Arduino** and **DHT22**, sending data to **Java** and presenting it to the user.

## 📌 Features
- Real-time temperature and humidity readings
- Arduino ↔ Java communication via serial port

## ⚙️ Technologies Used
- **Hardware**
  - **Arduino Uno**
  - **DHT22 Sensor**
  - **4K7 Pull-up Resistor**
  - **4x Jumper Wires**
- **Software**
  - **Java**
  - **Java Libraries:** `jSerialComm`
  - **Arduino IDE** for microcontroller programming
  - **Arduino Libraries:** `Adafruit_Sensor.h`

## 🖼️ System Workflow
Arduino (DHT22) → Serial → Java

## 🚀 How to Use
### 1️⃣ Arduino
1. Open `dht22-config.ino` in the Arduino IDE.
2. Upload it to the board.
3. Connect the DHT22 according to the wiring diagram.

<img src="https://blog.eletrogate.com/wp-content/uploads/2019/01/Arduino-DHT11-DHT22_editado2-1024x566.jpg">

### 2️⃣ Java
1. Run the script Main.java to monitor temperature and humidity data.
