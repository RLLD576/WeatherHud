package net.rober.weatherhud.networking.packets;


//? <=1.19.4 {
/*import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class WeatherDataS2CPacket {
    public static int SrainCounter;
    public static int SthunderCounter;
    public static boolean Sraining;
    public static boolean Sthundering;
    public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        SrainCounter=buf.readInt();
        SthunderCounter=buf.readInt();
        Sraining=buf.readBoolean();
        Sthundering=buf.readBoolean();
    }
}
*///?} else {

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.rober.weatherhud.networking.ModMessages;

public record WeatherDataS2CPacket(int rainCounter, int thunderCounter, boolean raining, boolean thundering) implements CustomPayload{
    public static final CustomPayload.Id<WeatherDataS2CPacket> ID = new CustomPayload.Id<>(ModMessages.SEND_WEATHER_DATA_ID);
    public static final PacketCodec<RegistryByteBuf, WeatherDataS2CPacket> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, WeatherDataS2CPacket::rainCounter,
            PacketCodecs.INTEGER, WeatherDataS2CPacket::thunderCounter,
            PacketCodecs.BOOL, WeatherDataS2CPacket::raining,
            PacketCodecs.BOOL, WeatherDataS2CPacket::thundering,
            WeatherDataS2CPacket::new
             );
    public static int SrainCounter;
    public static int SthunderCounter;
    public static boolean Sraining;
    public static boolean Sthundering;
    public static void recieve(WeatherDataS2CPacket payload) {
        SrainCounter = payload.rainCounter;
        SthunderCounter = payload.thunderCounter;
        Sraining = payload.raining;
        Sthundering = payload.thundering;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
//?}