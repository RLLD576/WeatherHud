package net.rober.weatherhud;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.rober.weatherhud.client.WeatherHudOverlay;
import net.rober.weatherhud.event.KeyInputHandler;
import net.rober.weatherhud.networking.ModMessages;

public class WeatherHudClient implements ClientModInitializer {
    public static boolean rendering = true;
    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        HudRenderCallback.EVENT.register(new WeatherHudOverlay());
        KeyInputHandler.register();
    }
}
