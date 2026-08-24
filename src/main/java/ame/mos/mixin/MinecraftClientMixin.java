package ame.mos.mixin;

import ame.mos.screen.AEM_EnchantmentScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin{

    @ModifyVariable(
            method = "setScreen",
            at = @At("HEAD"),
            argsOnly = true
    )

    private Screen aem$replaceEnchantmentScreen(Screen screen) {
        if(screen instanceof EnchantmentScreen enchantmentScreen && !(screen instanceof AEM_EnchantmentScreen)) {
            MinecraftClient client = MinecraftClient.getInstance();

            if (client.player != null) {
                return new AEM_EnchantmentScreen(
                        enchantmentScreen.getScreenHandler(),
                        client.player.getInventory(),
                        enchantmentScreen.getTitle()
                );

            }
        }

        return screen;

    }
}
