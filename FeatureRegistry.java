package dev.ownclient.core;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Central feature catalogue. Rendering/input hooks are added in the next
 * implementation stage; this registry is the single source of feature IDs.
 */
public final class FeatureRegistry {
    private static final Map<String, Feature> FEATURES = new LinkedHashMap<>();

    private FeatureRegistry() {}

    public static void registerDefaults() {
        register(new Feature("fps", "FPS Counter", true));
        register(new Feature("coordinates", "XYZ Coordinates", true));
        register(new Feature("cps", "CPS Counter", false));
        register(new Feature("keystrokes", "Keystrokes HUD", false));
        register(new Feature("armor", "Armor HUD", true));
        register(new Feature("potion_effects", "Potion Effects HUD", true));
        register(new Feature("ping", "Ping Display", true));
        register(new Feature("direction", "Direction HUD", false));
        register(new Feature("speedometer", "Speedometer", false));
        register(new Feature("crosshair", "Custom Crosshair", false));
        register(new Feature("zoom", "Zoom", false));
        register(new Feature("fullbright", "Fullbright", false));
        register(new Feature("freelook", "Freelook", false));
        register(new Feature("toggle_sprint", "Toggle Sprint", false));
        register(new Feature("minimap", "Mini Map", false));
    }

    private static void register(Feature feature) {
        FEATURES.put(feature.id(), feature);
    }

    public static Map<String, Feature> all() {
        return Collections.unmodifiableMap(FEATURES);
    }

    public record Feature(String id, String displayName, boolean plannedDefault) {}
}
