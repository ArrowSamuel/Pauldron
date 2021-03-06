package com.arrowsamuel.pauldron.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class PauldronCurio implements ICurio, ICapabilityProvider {
    private final ItemStack stack;

    public PauldronCurio(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public <ICurio> LazyOptional<ICurio> getCapability(Capability<ICurio> cap) {
        return cap == CuriosCapability.ITEM ? LazyOptional.of(() -> (ICurio)this) : LazyOptional.empty();
    }

    @Override
    public <ICurio> LazyOptional<ICurio> getCapability(Capability<ICurio> cap, Direction side) {
        return getCapability(cap);
    }
}