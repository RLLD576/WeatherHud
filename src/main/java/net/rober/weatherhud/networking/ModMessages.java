package net.rober.weatherhud.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.rober.weatherhud.WeatherHud;
import net.rober.weatherhud.networking.packets.WeatherDataS2CPacket;

public class ModMessages {
    public static final Identifier SEND_WEATHER_DATA_ID = Identifier.of(WeatherHud.MOD_ID,"weather_data");

    public static void registerS2CPackets(){
        //? <=1.19.4 {
        /*ClientPlayNetworking.registerGlobalReceiver(SEND_WEATHER_DATA_ID, WeatherDataS2CPacket::recieve);
        *///?} else {
        ClientPlayNetworking.registerGlobalReceiver(WeatherDataS2CPacket.ID, (payload, context)->{
            context.client().execute(()-> {
                WeatherDataS2CPacket.recieve(payload);
            });
        });
        //?}
    }
}