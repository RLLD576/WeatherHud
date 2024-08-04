package net.rober.weatherhud.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import net.rober.weatherhud.WeatherHudClient;
import net.rober.weatherhud.networking.packets.WeatherDataS2CPacket;

//? >=1.20.6
import net.minecraft.client.gui.DrawContext;

public class WeatherHudOverlay implements HudRenderCallback {
    //? <1.20.6 {
    /*@Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if(WeatherHudClient.rendering){
            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
            final int height = renderer.fontHeight;
            final int x = 1;
            final int y = 30;
            renderer.draw(matrixStack,"Rain counter: "+ WeatherDataS2CPacket.SrainCounter,x,y,WeatherDataS2CPacket.Sraining?0xFF55FF55:0xFFFF5555);
            renderer.draw(matrixStack,"Thunder counter: "+ WeatherDataS2CPacket.SthunderCounter,x,height+y,WeatherDataS2CPacket.Sthundering?0xFF55FF55:0xFFFF5555);
        }
    }
    *///?} elif =1.20.6 {
    /*@Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        if(WeatherHudClient.rendering){
            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
            final int height = renderer.fontHeight;
            final int x = 1;
            final int y = 30;
            drawContext.drawText(renderer,"Rain counter: "+ WeatherDataS2CPacket.SrainCounter,x,y,WeatherDataS2CPacket.Sraining?0xFF55FF55:0xFFFF5555,false);
            drawContext.drawText(renderer,"Thunder counter: "+ WeatherDataS2CPacket.SthunderCounter,x,height+y,WeatherDataS2CPacket.Sthundering?0xFF55FF55:0xFFFF5555,false);
        }
    }
    *///?} else {
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        if(WeatherHudClient.rendering){
            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
            final int height = renderer.fontHeight;
            final int x = 1;
            final int y = 30;
            drawContext.drawText(renderer,"Rain counter: "+ WeatherDataS2CPacket.SrainCounter,x,y,WeatherDataS2CPacket.Sraining?0xFF55FF55:0xFFFF5555,false);
            drawContext.drawText(renderer,"Thunder counter: "+ WeatherDataS2CPacket.SthunderCounter,x,height+y,WeatherDataS2CPacket.Sthundering?0xFF55FF55:0xFFFF5555,false);
        }
    }
    //?}
}
