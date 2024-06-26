package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraLufengosaurus;
import net.lepidodendron.entity.model.entity.ModelLufengosaurus;
import net.lepidodendron.entity.render.tile.RenderDisplays;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLufengosaurus extends RenderLiving<EntityPrehistoricFloraLufengosaurus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/lufengosaurus.png");

    public static float getScaler() {return 0.7272F;}

    public RenderLufengosaurus(RenderManager mgr) {
        super(mgr, new ModelLufengosaurus(), 0.5f);
    }

//    @Override
//    public void doRender(EntityPrehistoricFloraLufengosaurus entity, double x, double y, double z, float entityYaw, float partialTicks) {
//        try {
//            StackTraceElement[] elements = new Throwable().getStackTrace();
//            String  callerClass = elements[4].getClassName();
//        if (callerClass.equalsIgnoreCase("vazkii.patchouli.client.book.page.PageEntity")) {
//            GlStateManager.pushMatrix();
//            GlStateManager.disableCull();
//            GlStateManager.enableAlpha();
//            boolean flag = this.setDoRenderBrightness(entity, partialTicks);
//            if (!this.bindEntityTexture(entity))
//            {
//                return;
//            }
//            RenderDisplays.modelLufengosaurusBook.renderStaticBook(this.prepareScale(entity, partialTicks));
//            if (flag)
//            {
//                this.unsetBrightness();
//            }
//            GlStateManager.depthMask(true);
//            GlStateManager.disableRescaleNormal();
//            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
//            GlStateManager.enableTexture2D();
//            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
//            GlStateManager.enableCull();
//            GlStateManager.popMatrix();
//        }
//        else {
//            super.doRender(entity, x, y, z, entityYaw, partialTicks);
//        }
//        }
//        catch (Exception e)
//        {
//            //Do nothing
//        }
//    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraLufengosaurus entity) {
        return RenderLufengosaurus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraLufengosaurus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraLufengosaurus entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.40F;
    }

}