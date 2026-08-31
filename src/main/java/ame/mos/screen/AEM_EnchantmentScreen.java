package ame.mos.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.text.Text;


public class AEM_EnchantmentScreen extends EnchantmentScreen {

    //Temp screen dimensions to change the table texture
    private static final int AEM_backgroundWidth = 300;
    private static final int AEM_backgroundHeight = 220;

    //Temp colors for new screen (ARGB colors)
    private static final int panelBorderColor = 0xFF303030;
    private static final int panelColor = 0xFF606060;

    public AEM_EnchantmentScreen(
        EnchantmentScreenHandler handler,
        PlayerInventory inventory,
        Text title
    )

    {
        super(handler,inventory, title);

        //values that determine the GUI's top-left position
        this.backgroundWidth = AEM_backgroundWidth;
        this.backgroundHeight = AEM_backgroundHeight;
    }

    @Override
    protected void drawBackground(
        DrawContext context,
        float delta,
        int mouseX,
        int mouseY
    )

    {
        //The x & y taken from HandledScreen, it's the top left of Minecraft's screen and centers the screen
        int left = this.x;
        int top = this.y;

        //small dark border for the new screen
        context.fill(
                left - 2,
                top - 2,
                left + this.backgroundWidth + 2,
                top + this.backgroundHeight + 2,
                panelBorderColor
        );

        context.fill(
                left,
                top,
                left + this.backgroundWidth,
                top + this.backgroundHeight,
                panelColor
        );
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    )

    {
        //test display message that ensures that the mod is loaded
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
