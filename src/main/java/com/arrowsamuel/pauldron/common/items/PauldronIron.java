package com.arrowsamuel.pauldron.common.items;

import com.arrowsamuel.pauldron.Pauldron;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class PauldronIron extends Item {
    UUID ATTR_ID = new UUID(4563789645740263556l, -6212454071367548373l);
    public PauldronIron(Properties properties) {
        super(properties);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT unused) {
        return new PauldronCurio(stack) {

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext,
                                                                                UUID uuid) {
                Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
                /*
                atts.put(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(uuid, Pauldron.MOD_ID + ":speed_bonus", 0.1,
                                AttributeModifier.Operation.MULTIPLY_TOTAL));
                                */
                atts.put(Attributes.ARMOR,
                        new AttributeModifier(uuid, Pauldron.MOD_ID + ":armor_bonus", 5,
                                AttributeModifier.Operation.ADDITION));
                return atts;
            }

            @Override
            public boolean canEquipFromUse(SlotContext slot) {
                return true;
            }


        };
    }
}