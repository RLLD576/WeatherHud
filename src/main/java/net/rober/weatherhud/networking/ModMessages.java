package net.rober.weatherhud.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.rober.weatherhud.WeatherHud;
import net.rober.weatherhud.networking.packets.WeatherDataS2CPacket;

public class ModMessages {
    public static final Identifier SEND_WEATHER_DATA_ID = new Identifier(WeatherHud.MOD_ID,"weather_data");

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(SEND_WEATHER_DATA_ID, WeatherDataS2CPacket::recieve);
    }
}