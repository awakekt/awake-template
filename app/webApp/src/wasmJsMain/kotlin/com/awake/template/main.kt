package com.awake.template

import io.github.awakelab.awake.webgpu.application.WebGpuEngine
import io.github.awakelab.awake.webgpu.application.launchWebGpuGame
import io.github.awakelab.awake.engine.platform.dsl.AppWindowBackend

fun main() = launchWebGpuGame {
    WebGpuEngine(
        appLifecycle = createGame(AppWindowBackend.WEBGPU),
        requestedPlan = AwakeRenderPlan,
    )
}
