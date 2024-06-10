package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraTitanokorys;
import net.lepidodendron.entity.model.entity.ModelTitanokorys;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.lepidodendron.entity.render.tile.RenderDisplays;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTitanokorys extends RenderLivingBaseWithBook<EntityPrehistoricFloraTitanokorys> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/titanokorys.png");

    public RenderTitanokorys(RenderManager mgr) {
        super(mgr, new ModelTitanokorys(), RenderDisplays.modelTitanokorysBook, 0.0f);
    }

    public static float getScaler() {return 0.4F; }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraTitanokorys entity) {
        return RenderTitanokorys.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraTitanokorys entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraTitanokorys entity, float f) {
        float scale = this.getScaler();
        GlStateManager.scale(scale, scale, scale);
    }
}