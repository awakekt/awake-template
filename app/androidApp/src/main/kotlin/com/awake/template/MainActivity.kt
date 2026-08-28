package com.awake.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.github.ronjunevaldoz.awake.engine.platform.VulkanView
import io.github.ronjunevaldoz.awake.vulkan.application.VulkanEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val engine = VulkanEngine(createGame(), AwakeRenderPlan)
        setContentView(VulkanView(this, engine))
    }
}
