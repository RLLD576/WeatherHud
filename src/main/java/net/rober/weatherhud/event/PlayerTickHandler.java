package net.rober.weatherhud.event;

import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldProperties;
import net.minecraft.world.level.ServerWorldProperties;
import net.rober.weatherhud.mixin.ServerWorldMixin;
import net.rober.weatherhud.networking.ModMessages;

public class PlayerTickHandler implements ServerTickEvents.StartTick{
    @Override
    public void onStartTick(MinecraftServer server) {
        WorldProperties properties = server.getOverworld().getLevelProperties();
        ServerWorldProperties worldProperties = ((ServerWorldMixin)server.getOverworld()).getWorldProperties();
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(worldProperties.getRainTime());
        buf.writeInt(worldProperties.getThunderTime());
        buf.writeBoolean(properties.isRaining());
        buf.writeBoolean(properties.isThundering());
        for(ServerPlayerEntity player: server.getPlayerManager().getPlayerList()){
            ServerPlayNetworking.send(player, ModMessages.SEND_WEATHER_DATA_ID,buf);
        }
    }
}
