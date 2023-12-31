package net.minecraft.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

public record InclusiveRange<T extends Comparable<T>>(T minInclusive, T maxInclusive) {
   public static final Codec<InclusiveRange<Integer>> INT = codec(Codec.INT);

   public InclusiveRange {
      if (minInclusive.compareTo(maxInclusive) > 0) {
         throw new IllegalArgumentException("min_inclusive must be less than or equal to max_inclusive");
      }
   }

   public static <T extends Comparable<T>> Codec<InclusiveRange<T>> codec(Codec<T> pCodec) {
      return ExtraCodecs.intervalCodec(pCodec, "min_inclusive", "max_inclusive", InclusiveRange::create, InclusiveRange::minInclusive, InclusiveRange::maxInclusive);
   }

   public static <T extends Comparable<T>> Codec<InclusiveRange<T>> codec(Codec<T> p_184575_, T p_184576_, T p_184577_) {
      return ExtraCodecs.validate(codec(p_184575_), (p_274898_) -> {
         if (p_274898_.minInclusive().compareTo(p_184576_) < 0) {
            return DataResult.error(() -> {
               return "Range limit too low, expected at least " + p_184576_ + " [" + p_274898_.minInclusive() + "-" + p_274898_.maxInclusive() + "]";
            });
         } else {
            return p_274898_.maxInclusive().compareTo(p_184577_) > 0 ? DataResult.error(() -> {
               return "Range limit too high, expected at most " + p_184577_ + " [" + p_274898_.minInclusive() + "-" + p_274898_.maxInclusive() + "]";
            }) : DataResult.success(p_274898_);
         }
      });
   }

   public static <T extends Comparable<T>> DataResult<InclusiveRange<T>> create(T p_184581_, T p_184582_) {
      return p_184581_.compareTo(p_184582_) <= 0 ? DataResult.success(new InclusiveRange<>(p_184581_, p_184582_)) : DataResult.error(() -> {
         return "min_inclusive must be less than or equal to max_inclusive";
      });
   }

   public boolean isValueInRange(T pValue) {
      return pValue.compareTo(this.minInclusive) >= 0 && pValue.compareTo(this.maxInclusive) <= 0;
   }

   public boolean contains(InclusiveRange<T> pValue) {
      return pValue.minInclusive().compareTo(this.minInclusive) >= 0 && pValue.maxInclusive.compareTo(this.maxInclusive) <= 0;
   }

   public String toString() {
      return "[" + this.minInclusive + ", " + this.maxInclusive + "]";
   }
}