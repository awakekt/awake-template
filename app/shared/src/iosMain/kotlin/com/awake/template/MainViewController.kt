package com.awake.template

import io.github.awakelab.awake.vulkan.application.VulkanEngine
import io.github.awakelab.awake.vulkan.application.makeVulkanGameViewController

fun MainViewController() = makeVulkanGameViewController(
    VulkanEngine(
        appLifecycle = createGame(),
        plan = AwakeRenderPlan,
    ),
)
