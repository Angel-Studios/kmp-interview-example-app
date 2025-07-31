## KMP Interview Example App

### Setup

#### Enable Inlay Hints in Android Studio / IntelliJ
* Search for `inlay hints` inside the IDE settings (or double-shift and type `inlay hints`)
* Check all checkboxes:

<img width="582" height="286" alt="image" src="https://github.com/user-attachments/assets/a770ecb8-5503-4d15-960f-762e5e02d0a4" />

#### Generate Apollo sources

```
./gradlew common:generateApolloSources
```

### Installation

#### Android

```
./gradlew installDebug
```

#### Web

Uncomment the `web` module from settings.gradle.kts, then run:

```
./gradlew jsBrowserDevelopmentRun
```

