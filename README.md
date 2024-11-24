This repository contains a collection of my Mobile Software Development labs completed during my third year of Computer Science at TU Dublin. 

All applications are developed using Kotlin, Java, and XML in Android Studio, showcasing various aspects of mobile app development.

# Lab Summaries

### Lab 1: Hello World App
In this lab, I developed a simple application that displays a personalized message. This project serves as an introduction to Android development, showcasing basic UI elements and text display.

### Lab 2: Vertical Linear Layout
In this lab, I created an example project that demonstrates the use of vertical linear layouts in Android. The application features buttons arranged in a column, effectively illustrating how to structure UI components within a mobile application.

### Lab 3: UI Component Interactions
In this lab, I explored various UI components and their interactions using Kotlin:

- **TextView Manipulation**: Created a layout with a `TextView` displaying "Hello World!" and manipulated its text programmatically.
- **Button View**: Implemented a `Button` that counts and displays user clicks, demonstrating event handling.
- **EditText**: Added `EditText` components to facilitate user input, enabling dynamic text interactions.
- **RadioButton and Spinner**: Incorporated `RadioButtons` and a `Spinner` to enhance user selection options.

### Lab 4: ActionBar, SnackBar, and Calendar Implementation
In this lab, I focused on enhancing the user interface and experience in an Android app by implementing the ActionBar, SnackBar, and calendar feature:

- **ActionBar and Menus**: Utilized the ActionBar at the top of the activity to create a consistent navigation experience. This involved implementing an options menu with actions, such as adding a new item, and managing user selections effectively.
- **Event Handling**: Developed Kotlin code to handle events triggered by user interactions with the ActionBar, ensuring responsive app behavior.
- **SnackBar Introduction**: Integrated the SnackBar component to provide brief feedback messages at the bottom of the screen. I implemented two scenarios: one that displays a simple message and another that includes an action (e.g., "Undo").
- **Calendar Feature**: Added functionality for users to select a date via a calendar interface. Upon selection, a message is displayed showing the chosen date, enhancing user interactivity with a visual confirmation of their selection.
- **Demonstration**: Successfully executed the app to showcase the functionality of the ActionBar, SnackBar, and calendar feature, emphasizing their roles in enhancing user engagement and providing meaningful feedback.

### Lab 5: Dialogs and Orientation Handling
In this lab, I implemented various types of dialogs and event handling in an Android application:

- **Alert Dialogs**: Created dialogs to inform users and prompt simple choices, effectively managing user confirmations and notifications.
- **List Dialogs**: Developed a List Dialog that allows users to select from a predefined set of options, enhancing interaction through a clear selection interface.
- **Input Dialogs**: Designed custom input dialogs to gather user data, allowing for personalized input fields and layouts tailored to the app's needs.
- **Event Handling**: For each dialog type, I set up specific event listeners to handle user interactions seamlessly. The alert dialogs provide simple responses, while the list and input dialogs capture user selections and input effectively.

**Screen Orientation Handling**: I also focused on managing orientation changes by creating separate layout files for both portrait and landscape modes. This involved:

- **Defining Alternate Layouts**: Created a new layout resource specifically for landscape mode to ensure that the UI remains user-friendly and visually appealing regardless of the device's orientation.
- **Layout Management**: Implemented the logic to switch between these layouts automatically when the device orientation changes, ensuring a smooth user experience.

### Lab 6: Building a Reactive App with Architecture Components
In this lab, I built an app using Android’s Architecture Components: Room, ViewModel, and LiveData. The app focused on managing a list of words with a local database and updating the UI reactively when data changes.

- **Room Database**: I integrated Room to save and retrieve words, and pre-populated the database with sample data.
- **RecyclerView**: The app displayed words in a RecyclerView, automatically updating the list when the database changed.
- **Adding Data**: I implemented a FloatingActionButton that opened a second activity, allowing users to enter and add new words to the database.
- **ViewModel & LiveData**: The ViewModel exposed data through LiveData, ensuring the UI updated automatically when the data in the database changed.
- **Repository & DAO**: I used the Repository to manage data operations, while the DAO provided methods for querying the database.

By the end of this lab, I built an app with a clean architecture, utilizing LiveData to create a reactive UI that updates seamlessly in response to changes in the Room database. This lab helped me understand how to structure apps using architecture components for better scalability and maintainability.

### Lab 7: Threads and ExecutorService

In this lab, I explored the use of threads in Android development to handle time-consuming tasks without blocking the main UI thread. The main focus was on how threads can improve the responsiveness of applications by allowing time-consuming operations to run concurrently with the main thread, ensuring smooth user interactions.

#### Part 1: Using Threads to Start New Tasks
The lab began by creating a basic Android application where two buttons were added to the UI: "Change Content" and "Run Background Task". The purpose was to simulate a scenario where a long-running operation could block the UI thread, causing the app to freeze.

- **Problem**: When "Run Background Task" was clicked, the application became unresponsive when trying to click "Change Content" afterward.
- **Solution**: To resolve this, I created a new thread using the `Thread` class in Kotlin, which allowed the background task to run concurrently without blocking the main thread. This made the application more responsive and prevented freezing.

#### Part 2: Threads and Handler Object
In the second part of the lab, I learned how to use a `Handler` object to allow background threads to communicate with the main UI thread. Since Android doesn't allow background threads to update the UI directly, a handler is used to send messages from the background thread to the UI thread.

- **Objective**: The goal was to count for 20 seconds in a background thread and update the UI every second.
- **Implementation**:
  - A new `TextView` was added to the layout to display the countdown.
  - A custom `ThreadHandler` class was created, which extended `Handler` and communicated with the UI thread to update the `TextView` every second.
  - A background thread was implemented using `Thread` that sent messages to the handler, which in turn updated the UI by calling the `updateUI()` function in `MainActivity`.

This approach demonstrated how to effectively use handlers and threads to perform background tasks without blocking the main thread or crashing the app due to UI updates from background threads.

By the end of this lab, I gained a solid understanding of how to implement multithreading in Android applications using the `Thread` class and `Handler` objects. This is crucial for maintaining responsiveness in mobile apps, especially when dealing with time-consuming operations like network requests or data processing.

### Lab 8: Location Tracking and Geolocation

In this lab, I developed a location-aware app using Android's location services and geocoding features.

#### Key Features:
1. **Location Detection**: Displayed real-time GPS coordinates (latitude and longitude) and ensured proper runtime permissions and GPS signal handling.
2. **Custom Location Updates**: Added user inputs (`minTime`, `minDistance`) to adjust update frequency, with `Toast` notifications for changes.
3. **Geocoding**: Translated GPS coordinates into readable addresses and displayed them on the screen.
4. **Address History**: Implemented a list to show previously visited locations using arrays and adapters.
5. **Battery Optimization**: Used lifecycle methods (`onPause()`, `onResume()`) to toggle location tracking, conserving battery when the app is in the background.

This lab enhanced my skills in creating efficient, location-aware Android apps.
