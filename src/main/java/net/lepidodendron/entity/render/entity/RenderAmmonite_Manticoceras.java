package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAmmonite_Manticoceras;
import net.lepidodendron.entity.model.entity.ModelAmmonite50cm;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAmmonite_Manticoceras extends RenderLiving<EntityPrehistoricFloraAmmonite_Manticoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/ammonite_manticoceras.png");

    public RenderAmmonite_Manticoceras(RenderManager mgr) {
        super(mgr, new ModelAmmonite50cm(), 0.2f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAmmonite_Manticoceras entity) {
        return RenderAmmonite_Manticoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAmmonite_Manticoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraAmmonite_Manticoceras entity, float f) {
        float scale = entity.getAgeScale();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.45F;
    }

}