# ⚽ Premier League App

A modern Android application that displays English Premier League teams and their details, built with **Jetpack Compose** and the **MVVM architecture**.

---

## ✨ Features

- 🏠 **Home Screen** – Welcome page with an "Enter" button
- 📋 **Team List Screen** – Shows a list of Premier League teams
- 📄 **Team Detail Screen** – Displays detailed information about a selected team
- 🔄 **State Management** – UI state handled using Kotlin `StateFlow`
- 🧠 **ViewModel** – Business logic and state separated from UI
- 📦 **Repository Pattern** – Clean data access layer
- 🚀 **Navigation** – Jetpack Compose Navigation
- 🎨 **Material 3** – Built using Material Design 3 components

---

## 🧰 Tech Stack

| Layer              | Technology                     |
|-------------------|--------------------------------|
| UI                | [Jetpack Compose](https://developer.android.com/jetpack/compose) |
| Architecture      | MVVM (Model-View-ViewModel)    |
| Navigation        | [Jetpack Compose Navigation](https://developer.android.com/jetpack/compose/navigation) |
| State Management  | Kotlin Flow, `StateFlow`       |
| UI Components     | Material 3                     |

---

## 🧭 Navigation Structure

```text
[ HomeScreen ]
     |
     v
[ TeamListScreen ] <--> [ TeamDetailScreen ]
```

## 📷 Screenshots

![Screenshot_20250707_122210](https://github.com/user-attachments/assets/8ce73c83-1ec6-41fc-a42f-14a1c4713149)
![Screenshot_20250707_122247](https://github.com/user-attachments/assets/29bbf8ec-9af1-435b-9d14-d497a954ea97)
![Screenshot_20250707_122311](https://github.com/user-attachments/assets/6eaaa995-3fef-46ad-b955-457d3b2c50ed)
![Screenshot_20250707_122327](https://github.com/user-attachments/assets/ff4c7dde-68cb-45a8-b018-13d0ceb9cad9)
![Screenshot_20250707_122345](https://github.com/user-attachments/assets/7e0ff5e7-c613-44ff-9c0e-3eea4f429837)
![Screenshot_20250707_122402](https://github.com/user-attachments/assets/5755c664-61af-4527-b5ca-ae27a77c4cd8)
![Screenshot_20250707_122424](https://github.com/user-attachments/assets/3b3cc914-2b25-47c9-99ae-35e7ce090d28)
![Screenshot_20250707_122452](https://github.com/user-attachments/assets/dcc97ba2-a8b9-4d9d-aacc-232e6f6ad12a)


## 🏗️ Project Structure
```
com.example.premierleagueapp
│
├── data
│   ├── model
│   └── repository
│
├── ui
│   ├── screens
│   │   ├── HomeScreen.kt
│   │   ├── TeamListScreen.kt
│   │   └── TeamDetailScreen.kt
│   ├── state
│   └── viewmodel
│
└── MainActivity.kt
```
## 🤝 Contributions
Contributions are welcome! Feel free to fork the repository and submit pull requests.

## 📝 License
This project is licensed under the MIT License. See the LICENSE file for details.

## 💬 Questions?
Open an issue or start a discussion on GitHub Discussions
