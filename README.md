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
