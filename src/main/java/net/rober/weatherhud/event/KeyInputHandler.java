package net.rober.weatherhud.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.rober.weatherhud.WeatherHudClient;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_WEATHER_HUD = "WeatherHud";
    public static final String WEATHERHUD_KEYBING_TOGGLE = "Toggle render";

    public static KeyBinding toggleKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(toggleKey.wasPressed()){
                WeatherHudClient.rendering=!WeatherHudClient.rendering;
            }
        });
    }
    public static void register(){
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                WEATHERHUD_KEYBING_TOGGLE,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_WEATHER_HUD
        ));
        registerKeyInputs();
    }
}
