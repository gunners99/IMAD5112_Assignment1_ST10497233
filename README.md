# Social Sparks

> Stay connected, one spark at a time 

A native Android app built with Kotlin that helps Kora maintain meaningful social connections throughout her busy day. Based on the time of day entered, the app suggests a small, thoughtful social action — a **"spark"** — to keep her connected to family and friends.

\---

## Screenshots

|Home Screen|Spark Result|Error State|
|-|-|-|
|User enters time of day|Suggestion displayed on yellow card|Friendly error for unrecognised input|

\---

## Features

* **Time-based suggestions** — six social sparks mapped to different parts of the day
* **Friendly error handling** — motivating messages for invalid or empty input
* **Reset button** — clears input and result instantly
* **Engaging UI** — purple-themed card-based layout built with Material Components
* **Lightweight** — no internet connection required, no permissions needed

\---

## Social Spark Suggestions

|Time of Day|Emoji|Spark|
|-|-|-|
|Morning|☀️|Send a warm "Good Morning" text to a family member|
|Mid-Morning|🤝|Reach out to a colleague with a quick "Thank You"|
|Afternoon|😂|Share a funny meme or interesting link with a friend|
|Snack Time|💭|Send a quick "Thinking of you" message to someone special|
|Dinner|📞|Call a friend or relative for a 5-minute catch-up|
|Evening / Night|💬|Leave a thoughtful comment on a friend's post|

\---

## Tech Stack

|Item|Detail|
|-|-|
|Language|Kotlin|
|Minimum SDK|API 24 (Android 7.0 Nougat)|
|Target SDK|API 34 (Android 14)|
|UI|XML Layouts + Material Components|
|Architecture|Single Activity|
|IDE|Android Studio Hedgehog (2023.1.1) or newer|

\---

## Project Structure

```
SocialSparks/
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/kora/socialsparks/
│       │   └── MainActivity.kt          ← all app logic
│       └── res/
│           ├── drawable/
│           │   └── input\\\_background.xml ← rounded EditText style
│           ├── layout/
│           │   └── activity\\\_main.xml    ← UI layout
│           └── values/
│               ├── colors.xml           ← colour palette
│               ├── strings.xml          ← app name
│               └── themes.xml           ← Material theme
├── build.gradle
├── gradle.properties
├── gradle/wrapper/gradle-wrapper.properties
└── settings.gradle
```

\---

## Setup \& Installation

### Prerequisites

* Android Studio Hedgehog (2023.1.1) or newer
* JDK 17
* Android SDK API 24+

### Steps

1. **Clone or unzip** the project into a folder on your computer
2. **Open in Android Studio**

   * File > Open > select the `SocialSparks` folder
   * Wait for Gradle to sync
3. **Fix Gradle JDK** (if you see an "Incompatible Gradle JVM" error)

   * File > Settings > Build, Execution, Deployment > Build Tools > Gradle
   * Set **Gradle JDK** to **JDK 17**
   * Click OK and sync
4. **Run the app**

   * Connect a physical Android device via USB with USB Debugging enabled, OR
   * Launch an emulator via Tools > Device Manager
   * Click the green **Run ▶** button

\---

## Common Issues

|Issue|Fix|
|-|-|
|`mipmap/ic\\\_launcher not found`|Right-click `res` > New > Image Asset > Finish, or use `@android:mipmap/sym\\\_def\\\_app\\\_icon` in AndroidManifest.xml|
|`Incompatible Gradle JVM`|Set Gradle JDK to 17 in File > Settings > Build Tools > Gradle|
|`Emulator failed to launch`|Use a physical device instead, or install HAXM via SDK Manager|
|`Unresolved reference` error|Check that all XML IDs in `activity\\\_main.xml` match `findViewById()` calls in `MainActivity.kt`|

\---

## Colour Palette

|Name|Hex|Used For|
|-|-|-|
|Primary Purple|`#6C63FF`|Header, buttons, accents|
|Background|`#F0F4FF`|App background|
|Spark Yellow|`#FFFDE7`|Result card background|
|Error Red|`#C62828`|Error message text|
|White|`#FFFFFF`|Input and content cards|

\---

## How to Add a New Spark

Open `MainActivity.kt` and add a new branch inside the `when` expression in the `getSocialSpark()` function:

```kotlin
normalised.contains("lunch") ->
    Pair("🍽️", "Share a funny meme with a colleague over your lunch break!")
```

\---
VIDEO DEMONSTRATION LINK
https://youtu.be/\_XC6IxsLgok

