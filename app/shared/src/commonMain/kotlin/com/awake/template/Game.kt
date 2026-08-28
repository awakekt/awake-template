package com.awake.template

import io.github.ronjunevaldoz.awake.asset.shaders.RenderPlan
import io.github.ronjunevaldoz.awake.asset.shaders.ScenePipeline
import io.github.ronjunevaldoz.awake.asset.shaders.shaderSet
import io.github.ronjunevaldoz.awake.core.geometry.VertexFormat
import io.github.ronjunevaldoz.awake.engine.bootstrap.dsl.app
import io.github.ronjunevaldoz.awake.engine.platform.dsl.AppWindowBackend
import io.github.ronjunevaldoz.awake.engine.bootstrap.dsl.select
import io.github.ronjunevaldoz.awake.engine.platform.lifecycle.AwakeAppLifecycle
import io.github.ronjunevaldoz.awake.render.pipeline.PipelineKey

/** Creates a fresh application lifecycle for a platform host. */
fun createGame(windowBackend: AppWindowBackend = AppWindowBackend.VULKAN): AwakeAppLifecycle = app {
    window {
        title = "Awake Template"
        size(1280, 720)
        backend.select(windowBackend)
    }

    render { frame ->
        // Add simulation and gameplay updates here.
        frame.delta
    }
}

/** Shared pipeline declaration consumed by Vulkan and WebGPU. */
val AwakeRenderPlan = RenderPlan(
    primary = ScenePipeline(
        key = PipelineKey.Primary,
        shaders = shaderSet("triangle"),
        vertexFormat = VertexFormat.PositionColor,
    ),
)
