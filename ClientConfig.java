package dev.ownclient.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Small JSON-backed client configuration. */
public final class ClientConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance()
            .getConfigDir().resolve("own-client.json");

    public boolean showWelcome = true;
    public boolean fpsHud = true;
    public boolean coordinatesHud = true;
    public boolean keystrokesHud = false;
    public boolean armorHud = true;
    public boolean pingHud = true;
    public String accentColor = "#3B82F6";
    public String hudPreset = "default";

    private static ClientConfig current = new ClientConfig();

    private ClientConfig() {}

    public static ClientConfig get() {
        return current;
    }

    public static void load() {
        try {
            if (Files.exists(FILE)) {
                ClientConfig loaded = GSON.fromJson(Files.readString(FILE), ClientConfig.class);
                if (loaded != null) current = loaded;
            } else {
                save();
            }
        } catch (IOException | RuntimeException exception) {
            OwnClient.LOGGER.error("Could not load OWN CLIENT configuration; using defaults", exception);
            current = new ClientConfig();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(current));
        } catch (IOException exception) {
            OwnClient.LOGGER.error("Could not save OWN CLIENT configuration", exception);
        }
    }
}
