# Java Weather App

## 🌦️ Overview
This is a **Weather App** built using **Spring Boot** for the backend and a simple HTML, CSS, and JavaScript frontend. It fetches real-time weather data using the **OpenWeatherMap API** and displays temperature trends using **Chart.js**.

## 🚀 Features
- 🌍 Fetches weather data for any city.
- 📊 Displays temperature trends in a graphical format.
- 🔄 Updates weather data dynamically.
- 🖥️ User-friendly interface.

## 🛠️ Technologies Used
### Backend:
- **Java** (Spring Boot)
- **Spring Web**
- **RestTemplate** (for API calls)
- **Maven**

### Frontend:
- **HTML**, **CSS**, **JavaScript**
- **Chart.js** (for graph visualization)
- **OpenWeatherMap API** (for weather data)

## 📂 Project Structure
```
weather-app-springboot/
├── src/
│   ├── main/
│   │   ├── java/com/example/weatherapp/
│   │   │   ├── WeatherController.java
│   │   │   ├── WeatherService.java
│   │   │   ├── WeatherApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
├── frontend/
│   ├── index.html
│   ├── graph.html
│   ├── css/style.css
│   ├── js/script.js
├── pom.xml
```

## 🌐 API Setup
1. Get an **API key** from [OpenWeatherMap](https://openweathermap.org/api).
2. Add your API key to `application.properties`:
   ```properties
   weather.api.key=your_api_key_here
   ```
3. The backend fetches data from:
   ```
   https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&appid={API_KEY}
   ```

## 🏃‍♂️ Running the Project
### Backend (Spring Boot):
```sh
mvn spring-boot:run
```

### Frontend:
Open `index.html` in a browser or use Live Server (VS Code Extension).

## 📸 Screenshots
![Screenshot (89)](https://github.com/user-attachments/assets/52752e4b-0eb6-4baf-976a-5c1a206682e2)
![Screenshot (92)](https://github.com/user-attachments/assets/d7903efa-e42a-4560-af17-6dba2d9754ef)
![Screenshot (90)](https://github.com/user-attachments/assets/f181daa2-e06c-43a4-b363-ef1c8f6b195e)
![Screenshot (91)](https://github.com/user-attachments/assets/d1df8df1-31da-443a-8fd8-6ebc20c38e0d)

## 📝 License
This project is **open-source** and available under the **MIT License**.

## 🙌 Contributing
Feel free to fork the repo and submit pull requests. Suggestions and improvements are welcome! 🎉
