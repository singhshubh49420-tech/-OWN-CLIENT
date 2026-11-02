package com.swordgamerz.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClientConfig {
    private static final Gson GSON =
        new GsonBuilder().setPrettyPrinting().create();

    private static final Path FILE =
        FabricLoader.getInstance().getConfigDir()
        .resolve("own-client.json");

    public boolean showWelcome = true;
    public boolean fpsHud = true;
    public boolean coordinatesHud = true;
    public boolean keystrokesHud = false;
    public boolean armorHud = true;
    public boolean pingHud = true;
    public String accentColor = "#3B82F6";

    private static ClientConfig current = new ClientConfig();

    public static ClientConfig get() {
        return current;
    }

    public static void load() {
        try {
            if (Files.exists(FILE)) {
                current = GSON.fromJson(
                    Files.readString(FILE), ClientConfig.class);
            } else {
                save();
            }
        } catch (IOException | RuntimeException e) {
            current = new ClientConfig();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(current));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
