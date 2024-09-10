# Assignment Application

This Android app displays a list of items fetched from a mock public API. The app uses a RecyclerView to display the list, shows a loading indicator while fetching data, and handles errors gracefully by displaying an appropriate message to the user. Additionally, it includes a simple Room database for storing user information.

## Table of Contents

- [Features](#Features)
- [Project Structure](#project-structure)
- [Libraries Used](#libraries-used)
- [Setup and Installation](#setup-and-installation)
- [How to Run the App](#how-to-run-the-app)
- [Testing](#testing)
- [Bonus Features](#bonus-features)


## Features

- Fetches a list of items from a mock API and displays them in a RecyclerView.
- Shows a loading indicator while data is being fetched.
- Handles errors gracefully, displaying error messages to the user.
- Uses a Room database to store user information.
- Implements basic unit tests and UI tests using JUnit, Mockito, and Espresso.
- Bonus: Implements data binding and uses ViewModel and LiveData for managing UI-related data.

## Project Structure

```plaintext
com.example.assignmentapplication
│
├── ui                  # Contains UI components such as Activities and Adapters
│   ├── MainActivity.kt
│   └── ItemDataAdapter.kt
│
├── viewmodel           # Contains ViewModel classes
│   └── ItemViewModel.kt
│
├── model               # Contains data models and Room entities
│   ├── User.kt
│   └── UserItem.kt
│
├── network             # Contains Retrofit service and instance
│   ├── ApiService.kt
│   └── RetrofitInstance.kt
│
└── database            # Contains Room database and DAO interfaces
    ├── AppDatabase.kt
    └── UserDao.kt


```


## Libraries Used

- *Kotlin*: For app development.
- *AndroidX*: Core libraries for Android development.
- *Room*: For local database storage.
- *Retrofit*: For network operations and API calls.
- *RecyclerView*: For displaying lists of data.
- *Lifecycle, ViewModel, LiveData*: For managing UI-related data in a lifecycle-conscious way.
- *JUnit, Mockito, Espresso*: For unit testing and UI testing.

## Setup and Installation

1. *Clone the repository:*
   
git clone git@github.com:Hamza008/AssignmentSampleAppKotlin.git

2. *Open the project in Android Studio:*
   - Start Android Studio.
   - Select File -> Open... and navigate to the folder where you cloned the repository.
   - Select the folder and open it.

3. *Install dependencies:*
   - The project will automatically sync dependencies. If not, you can manually sync by going to File -> Sync Project with Gradle Files.

4. *Build the project:*
   - Go to Build -> Make Project or use the shortcut Ctrl+F9.

5. *Run the app:*
   - Select the device or emulator to run the app on.
   - Click on the Run button or use the shortcut Shift+F10.

## How to Run the App

1. *Ensure you have an Android device or emulator set up.*
2. *Run the app from Android Studio* by selecting the target device and clicking the Run button.
3. *Make sure to have internet connection on device or emulator.
4. *Navigate through the app*:
   - The main screen will display a list of items fetched from the mock API.
   - The app will show a loading indicator while the data is being fetched.
   - If there’s an error during data fetching, an error message will be displayed.

## Testing

### Unit Tests

- The app includes basic unit tests using JUnit and Mockito.
- To run the unit tests:
  - Go to Run -> Run Tests in 'app'.
  - Alternatively, use the shortcut Shift+F10 after selecting the test class.

### UI Tests

- The app includes simple UI tests using Espresso.
- To run the UI tests:
  - Go to Run -> Run Tests in 'androidTest'.
  - Alternatively, use the shortcut Shift+F10 after selecting the test class.

## Bonus Features

- *Data Binding*: The app uses data binding to bind UI components in the layout to data sources in the app.
- *ViewModel and LiveData*: These are used to manage UI-related data in a lifecycle-conscious way.
