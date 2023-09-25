package net.rober.weatherhud;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.rober.weatherhud.event.PlayerTickHandler;
import net.rober.weatherhud.networking.ModMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeatherHud implements ModInitializer {
	public static int timer = 20;
	public static final String MOD_ID = "weatherhud";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
