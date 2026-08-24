package ame.mos.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.text.Text;


public class AEM_EnchantmentScreen extends EnchantmentScreen {

    public AEM_EnchantmentScreen(
        EnchantmentScreenHandler handler,
        PlayerInventory inventory,
        Text title
    )

    {
        super(handler,inventory, title);
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    )

    {
        super.render(context, mouseX, mouseY, delta);
        context.drawText(
                this.textRenderer,
                "AEM WORKS",
                10,
                10,
                0x00FF00,
                true
        );
    }
}
