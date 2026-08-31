package ame.mos.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.ButtonWidget;


public class AEM_EnchantmentScreen extends EnchantmentScreen {

    // "Enum" is a data type used for constants, which seems to be used here for the three screen states
    private enum Tab {
        ENCHANT,
        TEXT,
        GLINT
    }

    //Starts the enchanting table on the enchant menu
    private Tab currentTab = Tab.ENCHANT;

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

    //override for button addition
    @Override
    protected void init() {
        super.init();

        int tabY = this.y + 6;

        int buttonWidth = 70;
        int buttonHeight = 20;
        int spacing = 4;

        int firstButtonX = this.x + 8;

        this.addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Enchant"),
                        button -> this.currentTab = Tab.ENCHANT
                )
                        .position(firstButtonX, tabY)
                        .size(buttonWidth,buttonHeight)
                        .build()
        );
        this.addDrawableChild(
                ButtonWidget.builder(
                                Text.literal("Text"),
                                button -> this.currentTab = Tab.TEXT
                        )
                        .position(firstButtonX + buttonWidth + spacing, tabY)
                        .size(buttonWidth,buttonHeight)
                        .build()
        );
        this.addDrawableChild(
                ButtonWidget.builder(
                                Text.literal("Glint"),
                                button -> this.currentTab = Tab.GLINT
                        )
                        .position(firstButtonX + (buttonWidth + spacing) * 2, tabY)
                        .size(buttonWidth,buttonHeight)
                        .build()
        );
    }

    //Override for rendering in the menu
    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    )
    {
        //Test display message that ensures that the mod is loaded
        super.render(context, mouseX, mouseY, delta);
        context.drawText(
                this.textRenderer,
                "AEM WORKS",
                10,
                10,
                0x00FF00,
                true
        );


    //Renderer for the button tabs
    String tabText;
    switch (this.currentTab) {
        case ENCHANT -> tabText = "ENCHANT TAB";
        case TEXT -> tabText = "TEXT TAB";
        case GLINT -> tabText = "GLINT TAB";
        default -> tabText = "";
    }
    context.drawText(
            this.textRenderer,
            tabText,
            this.x + 10,
            this.y + 35,
            0xFFFFFF,
            true
            );
    }
}
