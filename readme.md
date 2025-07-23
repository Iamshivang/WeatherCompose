# WeatherCompose ☔️ 🌍

A stunning Kotlin Android app built with **Jetpack Compose**, showcasing real-time weather updates using the **OpenWeatherMap API**. With a smooth and clean UI, it dynamically fetches weather data based on your **current location**, offering detailed metrics and a 5-day forecast.

---

## 🚀 Features

* ☔️ **Current Weather Details**:

  * Temperature, Feels Like
  * Date & Weather Condition
  * Sunrise & Sunset
  * Min/Max Temperature
  * Wind Speed
  * Pressure, Humidity
  * Visibility

* ⏰ **5-Day Weekly Forecast**

* ↻ **Refresh Button** for updated weather

* 📍 **Location Access**:

  * Prompts user for location permission
  * Requests to enable GPS
  * Auto-fetches weather based on current location

---

## 📚 Tech Stack

* **Language**: Kotlin
* **UI Framework**: Jetpack Compose
* **Architecture**: MVVM + Clean Architecture
* **Dependency Injection**: Hilt
* **Networking**: Retrofit
* **Image Loading**: Coil
* **Navigation**: Navigation Compose
* **State Handling**:

  * Coroutines + Flow + `mutableStateOf`
  * Generic class for UI state management
* **UX Enhancements**:

  * Shimmer effect for loading placeholders

---

## ⚡ Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/WeatherCompose.git
   ```
2. Obtain a free API key from [OpenWeatherMap](https://openweathermap.org/api)
3. Add your API key in `Constants.kt` file:

   ```
   const val API_KEY = "your_api_key"
   ```
4. Build and run on Android Studio Arctic Fox or later

---

## 🚧 Permissions Required

* **ACCESS\_FINE\_LOCATION** - For fetching the precise weather based on user location
* Prompts user to **enable location** if not turned on

---

## 🛍️ API Reference

* OpenWeatherMap OneCall API:

  * [https://openweathermap.org/api/one-call-api](https://openweathermap.org/api/one-call-api)

---

## 📊 Preview

| Home Screen | 5-Day Forecast  |
| ----------- | --------------- |
| <img src="https://github.com/Iamshivang/WeatherCompose/blob/main/app/assests/weathercompose1.jpg?raw=true" width="200"/> | <img src="https://github.com/Iamshivang/WeatherCompose/blob/main/app/assests/weathercompose2.jpg?raw=true" width="200"/> |

---

## 🌟 Credits

Built with ❤️ by [Shivang Yadav](https://github.com/Iamshivang)

---

## 📅 License

[MIT License](https://github.com/Iamshivang/WeatherCompose/blob/main/LICENSE)

---

## 🏷️ Keywords & Tech Tags

Weather App • Jetpack Compose • Kotlin • Android • OpenWeather • MVVM • Clean Architecture • Hilt • Retrofit • Coroutines • Flow • mutableStateOf • Shimmer Effect • Coil • Navigation Compose • State Management • Generic UI State • Weather Forecast • Location Permission • Android Weather App • Android UI

