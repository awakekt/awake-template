# Awake Template

A Kotlin Multiplatform application template for [Awake Engine](https://github.com/awake-lab/awake).
It starts from Kotlin's official `kmp-wizard` `all-targets` baseline and keeps the generated
platform projects in place:

- Android
- iOS
- Desktop JVM
- Web/Wasm with WebGPU
- Optional Ktor server

## Project Shape

```text
app/
├── shared/       # game lifecycle and shared RenderPlan
├── androidApp/   # Android Vulkan host
├── desktopApp/   # Desktop Vulkan host
├── webApp/       # Wasm WebGPU host
└── iosApp/       # Xcode UIKit host
core/             # shared application utilities
server/           # optional Ktor backend
```

The shared game is defined in
[`app/shared/src/commonMain/kotlin/com/awake/template/Game.kt`](app/shared/src/commonMain/kotlin/com/awake/template/Game.kt).
Platform modules only connect it to the appropriate Awake host.

## Requirements

- JDK 17 or newer
- Android SDK 36 for Android builds
- Xcode on macOS for iOS builds
- A Vulkan-capable desktop for the desktop renderer
- A WebGPU-capable browser for Wasm

## Run

```bash
# Verify the generated project
./gradlew help

# Desktop Vulkan
./gradlew :app:desktopApp:run

# Web/Wasm development server
./gradlew :app:webApp:wasmJsBrowserDevelopmentRun

# Android debug APK
./gradlew :app:androidApp:assembleDebug

# Ktor server
./gradlew :server:run
```

Open `app/iosApp/iosApp.xcodeproj` in Xcode for the iOS target.

## Awake Version

The Awake version is centralized in `gradle/libs.versions.toml`. Change the `awake` version there
when consuming a newer engine release. The current template points at the development snapshot
until Awake publishes its first stable application artifacts.

## Customize

1. Change the package from `com.awake.template` to your application package.
2. Edit `createGame()` and `AwakeRenderPlan` in `Game.kt`.
3. Add scene, Compose, physics, and asset modules only when the game needs them.
4. Keep platform files focused on host integration; shared gameplay belongs in `commonMain`.

## License

This template is licensed under Apache-2.0. See [LICENSE](LICENSE) when the repository is
published.
