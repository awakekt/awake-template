package com.awake.template

import io.github.ronjunevaldoz.awake.vulkan.application.VulkanEngine
import io.github.ronjunevaldoz.awake.vulkan.application.makeVulkanGameViewController

fun MainViewController() = makeVulkanGameViewController(
    VulkanEngine(
        appLifecycle = createGame(),
        plan = AwakeRenderPlan,
    ),
)
