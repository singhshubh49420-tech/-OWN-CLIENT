package dev.ownclient.core;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OWN CLIENT entry point.
 *
 * Keep this initializer small. Feature modules should be registered by
 * dedicated classes so that optional features can be enabled independently.
 */
public final class OwnClient implements ClientModInitializer {
    public static final String MOD_ID = "own_client";
    public static final String DISPLAY_NAME = "OWN CLIENT";
    public static final Logger LOGGER = LoggerFactory.getLogger(DISPLAY_NAME);

    @Override
    public void onInitializeClient() {
        LOGGER.info("{} initialising for Minecraft 26.2", DISPLAY_NAME);
        ClientConfig.load();
        FeatureRegistry.registerDefaults();
        LOGGER.info("{} core initialised", DISPLAY_NAME);
    }
}
