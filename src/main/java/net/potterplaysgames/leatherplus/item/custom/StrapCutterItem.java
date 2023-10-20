package net.potterplaysgames.leatherplus.item.custom;

import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class StrapCutterItem extends Item {
    public StrapCutterItem(Properties pProperties) {
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
        }
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

    private void reduceDurability(ItemStack stack, int amount) {
        int currentDamage = stack.getDamageValue(); // Get the current durability (damage)
        int newDamage = Math.min(currentDamage + amount, stack.getMaxDamage()); // Calculate the new durability

        stack.setDamageValue(newDamage); // Set the updated durability
    }

    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        // Check if the repair item is a StrapCutterItem
        if (pRepair.getItem() instanceof StrapCutterItem) {
            // Implement your custom logic to check if the StrapCutterItem can be repaired using the "Steel" item
            if (canBeRepairedWithSteel(pRepair)) {
                // This StrapCutterItem can be repaired with the "Steel" item
                return true;
            }
        }

        return super.isValidRepairItem(pToRepair, pRepair);
    }

    private boolean canBeRepairedWithSteel(ItemStack stack) {
        // Implement your custom logic here to check if the StrapCutterItem can be repaired with "Steel"
        // Return true if it can, false otherwise
        // You can consider various factors such as custom attributes or other item properties
        return stack.getDamageValue() < stack.getMaxDamage();
    }
}