package net.potterplaysgames.leatherplus.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.potterplaysgames.leatherplus.api.ApiUtils;
import net.potterplaysgames.leatherplus.util.ModTags;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class StrapCuttingItem extends Item {
    public StrapCuttingItem(Properties pProperties) {
        super(pProperties);
        MinecraftForge.EVENT_BUS.register(this); // Register this item as an event listener
    }

    // Handle durability reduction when used in crafting
    @SubscribeEvent
    public void onCraftedBy(PlayerEvent.ItemCraftedEvent event) {
        ItemStack stack = event.getCrafting();
        boolean hasLeather = hasLeatherInCrafting((CraftingContainer) event.getInventory());

        // If leather is used, reduce the durability
        if (hasLeather) {
            reduceDurability(stack, 1); // Reduce the durability by 1 (or the appropriate amount)
            if (stack.getDamageValue() >= stack.getMaxDamage()) {
                // The Strap Cutter has run out of durability, so it will be consumed
            } else {
                // Set the count to 1 to ensure it stays in the crafting result slot
                stack.setCount(1);
            }
        }
    }

    @Nonnull
    @Override
    public ItemStack getCraftingRemainingItem(@Nonnull ItemStack stack)
    {
        ItemStack container = stack.copy();
        if(container.hurt(1, ApiUtils.RANDOM_SOURCE, null))
            return ItemStack.EMPTY;
        else
            return container;
    }

    @Override
    public boolean hasCraftingRemainingItem(@Nonnull ItemStack stack)
    {
        return true;
    }

    private boolean hasLeatherInCrafting(CraftingContainer container) {
        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack ingredient = container.getItem(i);
            if (!ingredient.isEmpty() && ingredient.getItem() == Items.LEATHER) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.leathermod.strap_cutter.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void reduceDurability(ItemStack stack, int amount) {
        int currentDamage = stack.getDamageValue(); // Get the current durability (damage)
        int newDamage = Math.min(currentDamage + amount, stack.getMaxDamage()); // Calculate the new durability

        stack.setDamageValue(newDamage); // Set the updated durability
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ModTags.Items.STEELTAG) || super.isValidRepairItem(pToRepair, pRepair);
    }

}