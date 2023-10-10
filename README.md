## KMP Interview Example App

### Setup

Generate Apollo sources:

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

