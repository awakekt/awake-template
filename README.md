# Awake Template

A Kotlin Multiplatform game starter built on [Awake Engine](https://github.com/awakekt/awake). You
write the game in Kotlin; the sample is a lit cube spinning above the ground. To start from a project
made in Awake Studio instead, use
[awake-project-template](https://github.com/awakekt/awake-project-template).

## Run it

You need JDK 17 or newer. On macOS, desktop needs Vulkan: `brew install molten-vk vulkan-loader`.

```bash
./gradlew :app:desktopApp:run                       # desktop
./gradlew :app:androidApp:assembleDebug             # Android APK (needs the Android SDK)
./gradlew :app:webApp:wasmJsBrowserDevelopmentRun   # web (needs a WebGPU browser)
```

For iOS, open `app/iosApp/iosApp.xcodeproj` in Xcode.

## Ship it

Release builds are shrunk and obfuscated, which makes them smaller and harder to take apart: R8 on
Android, ProGuard on desktop, and an optimized, minified build on the web.

```bash
./gradlew :app:desktopApp:packageReleaseDistributionForCurrentOS   # desktop installer
./gradlew :app:androidApp:assembleRelease                          # Android APK
./gradlew :app:webApp:wasmJsBrowserDistribution                    # web
```

- **Keep rules:** Awake's libraries bring the rules for what their native code finds by name. If
  your game finds a class by name, keep it in `app/androidApp/proguard-rules.pro` and
  `app/desktopApp/proguard-rules.pro`.
- **Signing:** the Android release is signed with the debug key so that it installs as it is. Sign
  it with your own key before you publish.

## Where to start

| File | What it does |
|---|---|
| `app/shared/.../Game.kt` | The game: window, scene, camera, light and entities |
| `app/shared/.../RenderPlan.kt` | Sets up drawing for lit, textured and animated meshes, particles and the sky |
| `gradle/libs.versions.toml` | Pins the Awake Core (`awake`) and Vulkan (`awake-vulkan`) versions |

Rename the package `com.awakekt.awake.template` to your own. The
[Awake docs](https://docs.awakekt.com) cover scenes, physics, input and the rest.

## License

Apache-2.0. See [LICENSE.md](LICENSE.md).
