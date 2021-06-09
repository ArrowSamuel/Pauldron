package com.arrowsamuel.pauldron.common.items;

import com.arrowsamuel.pauldron.Pauldron;
import com.arrowsamuel.pauldron.client.render.PauldronModel;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class PauldronIron extends Item {
    UUID ATTR_ID = new UUID(4563789645740263556l, -6212454071367548373l);
    public PauldronIron(Properties properties) {
        super(properties);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT unused) {
        return new PauldronCurio(stack) {

            private Object model;

            private final ResourceLocation PAULDRON_IRON_TEXTURE = new ResourceLocation(Pauldron.MOD_ID,
                    "textures/entity/pauldron_iron_texture.png");

            @Override
            public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
                return true;
            }

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack,
                               IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity,
                               float limbSwing, float limbSwingAmount, float partialTicks,
                               float ageInTicks, float netHeadYaw, float headPitch) {

                if (!(this.model instanceof PauldronModel)) {
                    this.model = new PauldronModel();
                }
                PauldronModel pauldronIron = (PauldronModel) this.model;
                pauldronIron.setLivingAnimations(livingEntity, limbSwing, limbSwingAmount, partialTicks);
                pauldronIron.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
                        headPitch);
                ICurio.RenderHelper.followBodyRotations(livingEntity, pauldronIron);
                IVertexBuilder vertexBuilder = ItemRenderer
                        .getBuffer(renderTypeBuffer, pauldronIron.getRenderType(PAULDRON_IRON_TEXTURE), false,
                                stack.hasEffect());
                pauldronIron
                        .render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
                                1.0F);
            }



            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext,
                                                                                UUID uuid) {
                Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();

                atts.put(Attributes.ARMOR_TOUGHNESS,
                        new AttributeModifier(uuid, Pauldron.MOD_ID + ":armor_bonus", 1,
                                AttributeModifier.Operation.ADDITION));

                atts.put(Attributes.ARMOR,
                        new AttributeModifier(uuid, Pauldron.MOD_ID + ":armor_bonus", 2,
                                AttributeModifier.Operation.ADDITION));
                return atts;
            }

            @Override
            public boolean canEquipFromUse(SlotContext slot) {
                return true;
            }

            @Override
            public SoundInfo getEquipSound(SlotContext slotContext) {
                return new SoundInfo(SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f, 1.0f);
            }
        };
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}
