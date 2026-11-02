package com.swordgamerz.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

public class OwnClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HudElementRegistry.attachElementBefore(
            VanillaHudElements.CHAT,
            Identifier.of("own_client", "fps_hud"),
            (graphics, deltaTracker) -> {

                Minecraft minecraft = Minecraft.getInstance();

                graphics.fill(5, 5, 125, 25, 0xCC101828);

                graphics.text(
                    minecraft.font,
                    "OWN CLIENT  |  FPS: " + minecraft.getFps(),
                    10,
                    10,
                    0xFF55AAFF,
                    true
                );
            }
        );

    }
}
