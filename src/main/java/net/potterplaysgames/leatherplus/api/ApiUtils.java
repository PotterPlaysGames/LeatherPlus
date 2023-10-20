package net.potterplaysgames.leatherplus.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.JsonUtils;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class ApiUtils {
    /**
     * Random instance for general use. The "usual" per-world random instance can have unexpected behavior with
     * ghostloading (in some cases the seed is set directly), this instance does not have this problem.
     */
    public static final Random RANDOM = new Random();

    public static final RandomSource RANDOM_SOURCE = RandomSource.createNewThreadLocalInstance();



    public static double getDim(Vec3 vec, int dim)
    {
        return dim==0?vec.x: (dim==1?vec.y: vec.z);
    }

}
