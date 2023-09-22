package net.rober.weatherhud.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class WeatherDataS2CPacket {
    public static int rainCounter;
    public static int thunderCounter;
    public static boolean raining;
    public static boolean thundering;
    public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        rainCounter=buf.readInt();
        thunderCounter=buf.readInt();
        raining=buf.readBoolean();
        thundering=buf.readBoolean();
    }
}
