package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraTriopus;
import net.lepidodendron.entity.model.entity.ModelTriopus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTriopus extends RenderLivingBaseWithBook<EntityPrehistoricFloraTriopus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/triopus.png");

    public static float getScaler() {return 0.15F;}

    public RenderTriopus(RenderManager mgr) {
        super(mgr, new ModelTriopus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraTriopus entity) {
        return RenderTriopus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraTriopus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraTriopus entity, float f) {
        float scale = getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.00F;
    }


}


