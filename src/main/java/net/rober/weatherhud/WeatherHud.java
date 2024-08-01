package net.rober.weatherhud;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.rober.weatherhud.event.PlayerTickHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//? >1.19.4 {
import net.rober.weatherhud.networking.packets.WeatherDataS2CPacket;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.impl.networking.PayloadTypeRegistryImpl;
//?}

public class WeatherHud implements ModInitializer {
	public static int timer = 20;
	public static final String MOD_ID = "weatherhud";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
		//? >=1.20.6
		PayloadTypeRegistry.playS2C().register(WeatherDataS2CPacket.ID, WeatherDataS2CPacket.CODEC);
	}
}
