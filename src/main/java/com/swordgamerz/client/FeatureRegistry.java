package com.swordgamerz.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeatureRegistry {

    private static final List<String> FEATURES = new ArrayList<>();

    static {
        FEATURES.add("FPS HUD");
        FEATURES.add("Coordinates HUD");
        FEATURES.add("Keystrokes HUD");
        FEATURES.add("Armor HUD");
        FEATURES.add("Ping HUD");
        FEATURES.add("Crosshair Customization");
        FEATURES.add("Zoom");
        FEATURES.add("Fullbright");
    }

    public static List<String> getFeatures() {
        return Collections.unmodifiableList(FEATURES);
    }

    public static boolean isAvailable(String feature) {
        return FEATURES.contains(feature);
    }
}
