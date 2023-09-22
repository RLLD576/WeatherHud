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
            int color = 0xFFFFFFFF;
            renderer.draw(matrixStack,"Rain counter: "+ WeatherDataS2CPacket.rainCounter,x,1,color);
            renderer.draw(matrixStack,"Thunder counter: "+ WeatherDataS2CPacket.thunderCounter,x,height+1,color);
            renderer.draw(matrixStack,"Is raining: "+ WeatherDataS2CPacket.raining,x,height*2+1,color);
            renderer.draw(matrixStack,"Is thundering: "+ WeatherDataS2CPacket.thundering,x,height*3+1,color);
        }
    }
}
