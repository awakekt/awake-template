package com.awake.template

import io.github.ronjunevaldoz.awake.webgpu.application.WebGpuEngine
import io.github.ronjunevaldoz.awake.webgpu.application.launchWebGpuGame
import io.github.ronjunevaldoz.awake.engine.platform.dsl.AppWindowBackend

fun main() = launchWebGpuGame {
    WebGpuEngine(
        appLifecycle = createGame(AppWindowBackend.WEBGPU),
        requestedPlan = AwakeRenderPlan,
    )
}
