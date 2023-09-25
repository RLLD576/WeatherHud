package net.rober.weatherhud.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.rober.weatherhud.WeatherHudClient;
import net.rober.weatherhud.networking.packets.WeatherDataS2CPacket;

public class WeatherHudOverlay implements HudRenderCallback {
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if(WeatherHudClient.rendering){
            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
            final int height = renderer.fontHeight;
            final int x = 1;
            final int y = 30;
            renderer.draw(matrixStack,"Rain counter: "+ WeatherDataS2CPacket.rainCounter,x,y,WeatherDataS2CPacket.raining?0xFF55FF55:0xFFFF5555);
            renderer.draw(matrixStack,"Thunder counter: "+ WeatherDataS2CPacket.thunderCounter,x,height+y,WeatherDataS2CPacket.thundering?0xFF55FF55:0xFFFF5555);
        }
    }
}
