package net.potterplaysgames.leatherplus.api;

import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

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
