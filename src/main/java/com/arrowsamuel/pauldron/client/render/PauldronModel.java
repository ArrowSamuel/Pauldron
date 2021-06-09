package com.arrowsamuel.pauldron.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class PauldronModel extends BipedModel<LivingEntity> {

    private final ModelRenderer Pauldron;
    private final ModelRenderer Top_r1;
    private final ModelRenderer Base_r1;

        public PauldronModel() {
            super(0.5F);

               this.textureWidth = 64;
               this.textureHeight = 32;


            Pauldron = new ModelRenderer(this);
            Pauldron.setRotationPoint(5.0F, 22.0F, 0.0F);


            Top_r1 = new ModelRenderer(this);
            Top_r1.setRotationPoint(-7.6892F, -23.036F, -0.35F);
            Pauldron.addChild(Top_r1);
            setRotationAngle(Top_r1, 0.0F, 0.0F, -0.3927F);
            Top_r1.setTextureOffset(26, 0).addBox(-2.0F, -2.5F, -2.65F, 6.0F, 3.0F, 6.0F, 0.15F, false);

            Base_r1 = new ModelRenderer(this);
            Base_r1.setRotationPoint(-7.0F, -23.0F, 0.0F);
            Pauldron.addChild(Base_r1);
            setRotationAngle(Base_r1, 0.0F, 0.0F, -0.6981F);
            Base_r1.setTextureOffset(0, 0).addBox(-3.0F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, 0.25F, false);

                this.bipedRightArm.addChild(Pauldron);

        }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

            bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);

    }

    protected void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}