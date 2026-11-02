package com.swordgamerz.client;

import net.fabricmc.api.ClientModInitializer;

public class OwnClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("OWN CLIENT - Your Game. Your Rules.");
    }
}
