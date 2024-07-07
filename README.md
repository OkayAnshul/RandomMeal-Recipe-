# Random Meal Recipe App

## Overview
The **Random Meal Recipe App** is an Android application that fetches and displays random meal recipes using the [TheMealDB API](https://www.themealdb.com/api.php). The app showcases a detailed meal recipe, including ingredients, instructions, and an image of the meal.

## Features
- Fetch and display random meal recipes
- View meal details: ingredients, measurements, instructions, and images
- Clean and user-friendly interface
- Built with Kotlin and Jetpack Compose
- Uses Retrofit for API calls

## Screenshots
<p align="center">
  <img src="https://github.com/OkayAnshul/RandomMealRecipeApp/assets/174731765/7e594cbc-2c41-42e5-9ade-b13274933993" width="300">
  <img src="https://github.com/OkayAnshul/RandomMealRecipeApp/assets/174731765/e5659655-f750-4b80-b706-b59699a4c9b0" width="300">
  <img src="https://github.com/OkayAnshul/RandomMealRecipeApp/assets/174731765/e8b6c592-2184-4b1b-93c2-3273ccdab2ee" width="300">
</p>

## Download
You can download the APK file and install the app directly on your Android device:
[Download Random Meal Recipe App APK](https://github.com/OkayAnshul/RandomMealRecipeApp/releases/download/v1.0.0/RandomMealApp.apk.apk)


## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/OkayAnshul/RandomMealRecipeApp.git
    ```
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Usage
1. Launch the app.
2. The app will automatically fetch a random meal recipe.
3. Scroll to view meal details, including ingredients and instructions.

## Technologies Used
- **Kotlin**: The primary programming language.
- **Jetpack Compose**: For building the UI.
- **Retrofit**: For making API calls.
- **Coil**: For image loading.
- **Coroutines**: For asynchronous operations.

## Code Structure
Here's a brief overview of the main components of the project:

<div style="font-size: 0.85em;">
  
```plaintext
RandomMealRecipeApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/example/randommealrecipeapp/
│   │   │   │   │   ├── model/          # Data classes
│   │   │   │   │   ├── network/        # Retrofit API service
│   │   │   │   │   ├── ui/             # Composables and UI components
│   │   │   │   │   ├── viewmodel/      # ViewModel for managing UI-related data
│   │   │   │   │   └── MainActivity.kt # Entry point of the app
│   │   │   └── res/                    # Resources (layouts, strings, etc.)
│   │   └── AndroidManifest.xml         # Manifest file
└── build.gradle                        # Project-level build config
 ```
</div>

Contributing
Contributions are welcome! Feel free to submit a pull request or open an issue.

Fork the repository.      
Create your feature branch:
```bash
git checkout -b feature/my-new-feature
```
Commit your changes:
```bash
git commit -m 'Add some feature'
```
Push to the branch:
```bash
git push origin feature/my-new-feature
```
Open a pull request.

Contact
For any inquiries or feedback, please contact:

Name: Anshul

Email: anshulisokay@gmail.com

GitHub: [OkayAnshul](https://github.com/OkayAnshul)

Thank you for checking out the Random Meal Recipe App! If you like this project, please give it a star ⭐️ on GitHub.
