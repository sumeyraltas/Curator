# 🏛️ Curator — Art History & Digital Museum

<p align="center">
  <strong>An elegant, museum-grade Android application bringing world-renowned masterpieces, art movements, and AI-driven curatorial insights to your fingertips.</strong>
</p>

<p align="center">
  <em>Dünyaca ünlü başyapıtları, sanat akımlarını ve yapay zekâ destekli küratör analizlerini parmaklarınızın ucuna getiren modern bir dijital sanat müzesi uygulaması.</em>
</p>

<p align="center">
  <a href="#-english"><strong>English</strong></a> •
  <a href="README_TR.md"><strong>Türkçe</strong></a>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white" alt="Platform" />
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white" alt="Language" />
  <img src="https://img.shields.io/badge/UI-Jetpack_Compose_Material_3-4285F4?logo=jetpackcompose&logoColor=white" alt="Jetpack Compose" />
  <img src="https://img.shields.io/badge/Database-Room_SQLite-00599C?logo=sqlite&logoColor=white" alt="Room" />
  <img src="https://img.shields.io/badge/Networking-Retrofit_2_%2B_Moshi-blue" alt="Retrofit" />
  <img src="https://img.shields.io/badge/Architecture-MVVM_%2B_Flow-brightgreen" alt="Architecture" />
</p>

---

## 🇬🇧 English

### 📖 Table of Contents
1. [Overview](#overview)
2. [Key Features](#key-features)
3. [App Screenshots](#app-screenshots)
4. [Architecture & Tech Stack](#architecture--tech-stack)
5. [Project Structure](#project-structure)
6. [Getting Started](#getting-started)

---

### Overview
**Curator** is an open-source Android digital art museum application designed to make classical and modern art exploration immersive, educational, and visually captivating. Built with **100% Kotlin** and **Jetpack Compose (Material Design 3)**, Curator bridges centuries of artistic heritage with contemporary mobile craftsmanship.

Users can discover the handpicked **Masterpiece of the Day**, explore world-famous institutions like **The Louvre, MoMA, and El Prado**, filter through pivotal **Art Movements (Renaissance, Impressionism, Baroque)**, read deep **AI Curatorial Insights**, and curate their own **Personal Collection** with custom notes stored offline via **Room Database**.

---

### Key Features

* 🌟 **Masterpiece of the Day**: Featured historical artwork prominently showcased daily with high-resolution visual previews, author attribution, and instant access to deep curatorial analysis.
* 🏛️ **Explore by Museum**: Dedicated portals for world-class cultural institutions including *The Louvre* (Paris), *MoMA* (New York), *The Prado Museum* (Madrid), and the *Art Institute of Chicago*.
* 🎨 **Art Movements**: Comprehensive catalogs explaining historical periods from the Classical Renaissance and Dutch Golden Age to French Impressionism and Modernism.
* 🔍 **Smart Search & Quick Filters**: Search by artwork name, creator, or style with fast horizontal filter chips (`Van Gogh`, `19th Century`, `Paris`, `Impressionism`, `Baroque`, `Renaissance`).
* 🖼️ **High-Resolution Artwork Detail & Lightbox**: Inspect artworks with full-screen zoom and pan capabilities, accompanied by structured museum specifications (Year, Medium, Dimensions, Physical Location, and Curatorial Background).
* ✨ **AI Curator Insights**: On-demand art historical breakdowns analyzing color harmony, compositional tension, materiality, and historical zeitgeist.
* 📑 **Personal Collection & Notes**: Bookmark favorite masterpieces to local storage using an offline-first **Room Database**, allowing users to attach and edit personalized curator study notes.
* 🏺 **Museum Editorial Design**: Custom warm-neutral canvas, terracotta accents, high-contrast serif typography, and edge-to-edge layout adhering strictly to Material Design 3 guidelines.

---

### App Screenshots

| 1. Discover & Daily Masterpiece | 2. Artwork Detail & Metadata | 3. Movements & Museums |
| :---: | :---: | :---: |
| <img width="240" src="https://github.com/user-attachments/assets/b21c7be2-ad21-48c3-8901-1f2e13ac32ec" /> | <img width="240" src="https://github.com/user-attachments/assets/9fc3ee79-dd87-44f8-a8dd-5a7e6c44c9f7" /> | <img width="240" src="https://github.com/user-attachments/assets/190c3825-a7f1-45f7-a934-f1079e8202c4" /> | 
| *Curator home showcasing "The Starry Night" and movements* | *Technical details (Year, Medium, Dimensions, Museum) and description* | *Art movements and world-renowned museum shortcuts* |

| 4. Curated Gallery Stream | 5. Personal Collection & Notes | 6. Search & Filter Chips | 7. Category Discovery |
| :---: | :---: | :---: | :---: |
| <img width="190" src="https://github.com/user-attachments/assets/8b773b00-362e-4d5e-915d-189d10678cbe" /> | <img width="190"  src="https://github.com/user-attachments/assets/b3f39fbd-4b0e-4945-aac0-cfa9f12db4f1" /> | <img width="190" src="https://github.com/user-attachments/assets/11b69198-4e21-4ef5-bd6c-dff4397c8096" /> | <img width="190" src="https://github.com/user-attachments/assets/32039291-05b9-4be4-bac9-adb01a47189b" /> | 
| *Curated visual stream of historical masterpieces* | *Saved artworks with personal notes, edit & delete* | *Instant search by keyword and topic tags* | *Trending curations filtered by art movement* |

---

### Architecture & Tech Stack

The application adheres to modern Android architectural principles: **MVVM (Model-View-ViewModel)** with **Unidirectional Data Flow (UDF)** and an **Offline-First** repository pattern.

```
┌────────────────────────────────────────────────────────┐
│                   Jetpack Compose UI                   │
│   (DiscoverScreen, ArtworkDetailScreen, SearchScreen)  │
└───────────────────────────▲────────────────────────────┘
                            │ StateFlow / UiState
┌───────────────────────────┴────────────────────────────┐
│                       ViewModels                       │
│      (CuratorViewModel, ArtworkDetailViewModel)        │
└───────────────────────────▲────────────────────────────┘
                            │ Coroutines / Flow
┌───────────────────────────┴────────────────────────────┐
│                   ArtworkRepository                    │
└─────────────┬────────────────────────────┬─────────────┘
              ▼                            ▼
┌───────────────────────────┐┌───────────────────────────┐
│       Room Database       ││     Retrofit / REST API   │
│ (SavedArtworkDao, Entity) ││ (Art Institute of Chicago)│
└───────────────────────────┘└───────────────────────────┘
```

* **Language**: Kotlin 2.0+
* **User Interface**: Jetpack Compose, Material 3, Material Icons Extended
* **Image Loading & Caching**: Coil Compose
* **Local Persistence**: Jetpack Room Database with KSP (Kotlin Symbol Processing)
* **Networking**: Retrofit 2 + Moshi + OkHttp Logging Interceptor
* **Concurrency**: Kotlin Coroutines & `StateFlow` / `SharedFlow`
* **Navigation**: Jetpack Navigation Compose with type-safe routing
* **Testing**: Robolectric (JVM Unit Tests), Roborazzi (Screenshot Testing), JUnit 4

---

### Project Structure

```
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example
│   │   │   │   ├── data
│   │   │   │   │   ├── api          # Retrofit endpoints & Curated Art data
│   │   │   │   │   ├── db           # Room Database, DAOs & Entities
│   │   │   │   │   ├── model        # Domain models (Artwork, ArtMovement, Museum)
│   │   │   │   │   └── repository   # Repository uniting remote and local persistence
│   │   │   │   ├── ui
│   │   │   │   │   ├── components   # Reusable UI widgets (Cards, Shimmers, Lightbox)
│   │   │   │   │   ├── navigation   # Compose NavHost & bottom bar navigation
│   │   │   │   │   ├── screens      # Discover, Detail, Search & Collection screens
│   │   │   │   │   ├── theme        # ColorScheme, Typography & Theme styling
│   │   │   │   │   └── viewmodel    # CuratorViewModel & ArtworkDetailViewModel
│   │   │   │   └── MainActivity.kt  # Edge-to-edge Activity entry point
│   │   │   └── res                  # Vector drawables, strings, and launcher icons
│   │   └── test                     # Robolectric & Roborazzi visual verification
├── screenshots                      # High-resolution screenshots of the app
├── build.gradle.kts                 # Root build script
└── settings.gradle.kts              # Project configuration
```

---

### Getting Started

#### Prerequisites
* **Android Studio**: Ladybug (2024.2.1) or newer
* **JDK**: Version 17 or higher
* **Android SDK**: Compile SDK 36 (Minimum SDK 24)

#### Installation & Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/curator-android.git
   cd curator-android
   ```
2. Open the project in Android Studio.
3. Allow Gradle to download dependencies and sync.
4. Select an emulator (API 26+) or physical Android device.
5. Click **Run (`Shift + F10`)** or run via command line:
   ```bash
   ./gradlew installDebug
   ```

---

<br />
