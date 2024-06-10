package net.lepidodendron.entity.model.entity;

import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.lepidodendron.entity.base.EntityPrehistoricFloraInsectFlyingBase;
import net.lepidodendron.entity.model.ModelBasePalaeopedia;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPalaeodictyopteraLarge extends ModelBasePalaeopedia {
    private final AdvancedModelRenderer body;
    private final AdvancedModelRenderer subwingR;
    private final AdvancedModelRenderer subwingL;
    private final AdvancedModelRenderer forewingR;
    private final AdvancedModelRenderer forewingL;
    private final AdvancedModelRenderer hindwingR;
    private final AdvancedModelRenderer hindwingL;
    private final AdvancedModelRenderer abdomen;
    private final AdvancedModelRenderer cube_r1;
    private final AdvancedModelRenderer cube_r2;
    private final AdvancedModelRenderer cerciR;
    private final AdvancedModelRenderer cerciL;
    private final AdvancedModelRenderer legR;
    private final AdvancedModelRenderer legL;
    private final AdvancedModelRenderer legR2;
    private final AdvancedModelRenderer legL2;
    private final AdvancedModelRenderer legR3;
    private final AdvancedModelRenderer legL3;
    private final AdvancedModelRenderer head;
    private final AdvancedModelRenderer antennaR;
    private final AdvancedModelRenderer antennaL;
    private final AdvancedModelRenderer mouth;
    private final AdvancedModelRenderer cube_r3;
    private final AdvancedModelRenderer cube_r4;
    private final AdvancedModelRenderer cube_r5;

    public ModelPalaeodictyopteraLarge() {
        this.textureWidth = 120;
        this.textureHeight = 55;

        this.body = new AdvancedModelRenderer(this);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.body.cubeList.add(new ModelBox(body, 29, 39, -2.0F, -2.0F, -4.0F, 4, 2, 7, 0.0F, false));
        this.body.cubeList.add(new ModelBox(body, 0, 36, -1.5F, -2.0F, -8.0F, 3, 2, 4, 0.01F, false));

        this.subwingR = new AdvancedModelRenderer(this);
        this.subwingR.setRotationPoint(-1.0F, -1.5F, -6.25F);
        this.body.addChild(subwingR);
        this.subwingR.cubeList.add(new ModelBox(subwingR, 0, 0, -3.25F, 0.0F, -2.0F, 3, 0, 4, 0.0F, false));

        this.subwingL = new AdvancedModelRenderer(this);
        this.subwingL.setRotationPoint(1.0F, -1.5F, -6.25F);
        this.body.addChild(subwingL);
        this.subwingL.cubeList.add(new ModelBox(subwingL, 0, 0, 0.25F, 0.0F, -2.0F, 3, 0, 4, 0.0F, true));

        this.forewingR = new AdvancedModelRenderer(this);
        this.forewingR.setRotationPoint(-1.5F, -1.45F, -2.5F);
        this.body.addChild(forewingR);
        this.setRotateAngle(forewingR, 0.0F, 0.0F, -0.0436F);
        this.forewingR.cubeList.add(new ModelBox(forewingR, 0, 10, -26.0F, 0.0F, -3.5F, 26, 0, 10, 0.0F, false));

        this.forewingL = new AdvancedModelRenderer(this);
        this.forewingL.setRotationPoint(1.5F, -1.45F, -2.5F);
        this.body.addChild(forewingL);
        this.setRotateAngle(forewingL, 0.0F, 0.0F, 0.0436F);
        this.forewingL.cubeList.add(new ModelBox(forewingL, 0, 10, 0.0F, 0.0F, -3.5F, 26, 0, 10, 0.0F, true));

        this.hindwingR = new AdvancedModelRenderer(this);
        this.hindwingR.setRotationPoint(-1.5F, -1.4F, 0.5F);
        this.body.addChild(hindwingR);
        this.setRotateAngle(hindwingR, 0.0F, 0.0873F, -0.0873F);
        this.hindwingR.cubeList.add(new ModelBox(hindwingR, 0, 0, -25.75F, 0.0F, -1.5F, 26, 0, 10, 0.0F, false));

        this.hindwingL = new AdvancedModelRenderer(this);
        this.hindwingL.setRotationPoint(1.5F, -1.4F, 0.5F);
        this.body.addChild(hindwingL);
        this.setRotateAngle(hindwingL, 0.0F, -0.0873F, 0.0873F);
        this.hindwingL.cubeList.add(new ModelBox(hindwingL, 0, 0, -0.25F, 0.0F, -1.5F, 26, 0, 10, 0.0F, true));

        this.abdomen = new AdvancedModelRenderer(this);
        this.abdomen.setRotationPoint(0.0F, -1.25F, 3.0F);
        this.body.addChild(abdomen);
        this.setRotateAngle(abdomen, -0.0436F, 0.0F, 0.0F);
        this.abdomen.cubeList.add(new ModelBox(abdomen, 23, 20, -1.0F, -0.75F, 0.0F, 2, 2, 17, 0.0F, false));

        this.cube_r1 = new AdvancedModelRenderer(this);
        this.cube_r1.setRotationPoint(0.0F, 1.25F, 0.0F);
        this.abdomen.addChild(cube_r1);
        this.setRotateAngle(cube_r1, 0.0F, -0.0524F, 0.0F);
        this.cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 27, 1.0F, -1.5F, -0.1F, 1, 1, 17, 0.01F, true));

        this.cube_r2 = new AdvancedModelRenderer(this);
        this.cube_r2.setRotationPoint(0.0F, 1.25F, 0.0F);
        this.abdomen.addChild(cube_r2);
        this.setRotateAngle(cube_r2, 0.0F, 0.0524F, 0.0F);
        this.cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 27, -2.0F, -1.5F, -0.1F, 1, 1, 17, 0.01F, false));

        this.cerciR = new AdvancedModelRenderer(this);
        this.cerciR.setRotationPoint(-0.5F, 0.5F, 17.0F);
        this.abdomen.addChild(cerciR);
        this.setRotateAngle(cerciR, 0.0F, -0.3927F, -0.1309F);
        this.cerciR.cubeList.add(new ModelBox(cerciR, 0, -12, 0.0F, -6.5F, 0.0F, 0, 7, 60, 0.0F, false));

        this.cerciL = new AdvancedModelRenderer(this);
        this.cerciL.setRotationPoint(0.5F, 0.5F, 17.0F);
        this.abdomen.addChild(cerciL);
        this.setRotateAngle(cerciL, 0.0F, 0.3927F, 0.1309F);
        this.cerciL.cubeList.add(new ModelBox(cerciL, 0, -12, 0.0F, -6.5F, 0.0F, 0, 7, 60, 0.0F, true));

        this.legR = new AdvancedModelRenderer(this);
        this.legR.setRotationPoint(-1.5F, -0.75F, -6.0F);
        this.body.addChild(legR);
        this.setRotateAngle(legR, 0.0F, -0.7418F, 0.0F);
        this.legR.cubeList.add(new ModelBox(legR, 19, 27, -10.0F, -0.25F, 0.0F, 10, 5, 0, 0.0F, false));

        this.legL = new AdvancedModelRenderer(this);
        this.legL.setRotationPoint(1.5F, -0.75F, -6.0F);
        this.body.addChild(legL);
        this.setRotateAngle(legL, 0.0F, 0.7418F, 0.0F);
        this.legL.cubeList.add(new ModelBox(legL, 19, 27, 0.0F, -0.25F, 0.0F, 10, 5, 0, 0.0F, true));

        this.legR2 = new AdvancedModelRenderer(this);
        this.legR2.setRotationPoint(-2.0F, -0.75F, -2.25F);
        this.body.addChild(legR2);
        this.setRotateAngle(legR2, 0.0F, 0.2182F, 0.0F);
        this.legR2.cubeList.add(new ModelBox(legR2, 44, 25, -11.0F, -0.25F, 0.0F, 11, 5, 0, 0.0F, false));

        this.legL2 = new AdvancedModelRenderer(this);
        this.legL2.setRotationPoint(2.0F, -0.75F, -2.25F);
        this.body.addChild(legL2);
        this.setRotateAngle(legL2, 0.0F, -0.2182F, 0.0F);
        this.legL2.cubeList.add(new ModelBox(legL2, 44, 25, 0.0F, -0.25F, 0.0F, 11, 5, 0, 0.0F, true));

        this.legR3 = new AdvancedModelRenderer(this);
        this.legR3.setRotationPoint(-2.0F, -0.75F, 1.25F);
        this.body.addChild(legR3);
        this.setRotateAngle(legR3, 0.0F, 0.7418F, 0.0F);
        this.legR3.cubeList.add(new ModelBox(legR3, 44, 20, -12.0F, -0.25F, 0.0F, 12, 5, 0, 0.0F, false));

        this.legL3 = new AdvancedModelRenderer(this);
        this.legL3.setRotationPoint(2.0F, -0.75F, 1.25F);
        this.body.addChild(legL3);
        this.setRotateAngle(legL3, 0.0F, -0.7418F, 0.0F);
        this.legL3.cubeList.add(new ModelBox(legL3, 44, 20, 0.0F, -0.25F, 0.0F, 12, 5, 0, 0.0F, true));

        this.head = new AdvancedModelRenderer(this);
        this.head.setRotationPoint(0.0F, -1.25F, -8.0F);
        this.body.addChild(head);
        this.setRotateAngle(head, 0.0873F, 0.0F, 0.0F);
        this.head.cubeList.add(new ModelBox(head, 0, 4, -1.0F, -0.25F, -2.0F, 2, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(head, 0, 7, -1.5F, -0.25F, -1.5F, 3, 1, 1, -0.01F, false));

        this.antennaR = new AdvancedModelRenderer(this);
        this.antennaR.setRotationPoint(-0.65F, 0.25F, -1.5F);
        this.head.addChild(antennaR);
        this.setRotateAngle(antennaR, -0.2618F, 0.3491F, -0.1745F);
        this.antennaR.cubeList.add(new ModelBox(antennaR, 0, 0, 0.0F, -6.75F, -20.0F, 0, 7, 20, 0.0F, false));

        this.antennaL = new AdvancedModelRenderer(this);
        this.antennaL.setRotationPoint(0.65F, 0.25F, -1.5F);
        this.head.addChild(antennaL);
        this.setRotateAngle(antennaL, -0.2618F, -0.3491F, 0.1745F);
        this.antennaL.cubeList.add(new ModelBox(antennaL, 0, 0, 0.0F, -6.75F, -20.0F, 0, 7, 20, 0.0F, true));

        this.mouth = new AdvancedModelRenderer(this);
        this.mouth.setRotationPoint(0.0F, 0.5F, -1.0F);
        this.head.addChild(mouth);
        this.setRotateAngle(mouth, 0.0873F, 0.0F, 0.0F);


        this.cube_r3 = new AdvancedModelRenderer(this);
        this.cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth.addChild(cube_r3);
        this.setRotateAngle(cube_r3, 0.0436F, -0.1309F, 0.0F);
        this.cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 19, 0.4F, -0.75F, -8.25F, 0, 1, 8, 0.0F, true));

        this.cube_r4 = new AdvancedModelRenderer(this);
        this.cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth.addChild(cube_r4);
        this.setRotateAngle(cube_r4, 0.0436F, 0.1309F, 0.0F);
        this.cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 19, -0.4F, -0.75F, -8.25F, 0, 1, 8, 0.0F, false));

        this.cube_r5 = new AdvancedModelRenderer(this);
        this.cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth.addChild(cube_r5);
        this.setRotateAngle(cube_r5, 0.2182F, 0.0F, 0.0F);
        this.cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 28, -0.5F, -0.75F, -7.75F, 1, 1, 7, 0.0F, false));

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
    }

    public void renderStaticSuspended(float f) {
        this.setRotateAngle(body, 0.3F, 0.0F, -0.3F);
        this.setRotateAngle(head, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(abdomen, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindwingL, 0.0F, 0.0F, 0.2F);
        this.setRotateAngle(hindwingR, 0.0F, 0.0F, -0.2F);
        this.setRotateAngle(forewingL, 0.0F, 0.0F, -0.2F);
        this.setRotateAngle(forewingR, 0.0F, 0.0F, 0.2F);
        this.body.offsetY = -0.07F;
        this.body.offsetX = 0.005F;
        this.body.render(0.01f);
    }

    public void renderStaticFloor(float f) {
        this.setRotateAngle(body, 0.0F, 0.0F, 0.1F);
        this.setRotateAngle(head, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(abdomen, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindwingL, 0.0F, 0.0F, 0.2F);
        this.setRotateAngle(hindwingR, 0.0F, 0.0F, -0.2F);
        this.setRotateAngle(forewingL, 0.0F, 0.0F, -0.2F);
        this.setRotateAngle(forewingR, 0.0F, 0.0F, 0.2F);
        this.setRotateAngle(legL, 0.0F, 0.0F, 0.9F);
        this.setRotateAngle(legL2, 0.0F, 0.0F, 0.8F);
        this.setRotateAngle(legL3, 0.0F, 0.0F, 0.7F);
        this.setRotateAngle(legR, 0.0F, 0.0F, -0.9F);
        this.setRotateAngle(legR2, 0.0F, 0.0F, -0.8F);
        this.setRotateAngle(legR3, 0.0F, 0.0F, -0.7F);
        this.setRotateAngle(cerciL, 0.0F, 0.3F, 0.0F);
        this.setRotateAngle(cerciR, 0.0F, -0.3F, 0.0F);
        this.body.offsetY = -0.265F;
        this.body.offsetX = 0.003F;
        this.body.render(0.01f);
    }

    public void renderStaticWall(float f) {
        this.setRotateAngle(body, -1.56F, 3.15F, 0.0F);
        this.setRotateAngle(legL, 0.0F, 0.3F, 0.0F);
        this.setRotateAngle(legL2, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(legL3, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(legR, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(legR2, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(legR3, 0.0F, 0.3F, 0.0F);
        this.body.offsetY = -0.32F;
        this.body.offsetZ = -0.035F;
        this.body.render(0.01F);
        resetToDefaultPose();
    }

    public void renderStaticDisplayCase(float f) {
        this.setRotateAngle(body, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(abdomen, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(forewingL, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(forewingR, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindwingL, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindwingR, 0.0F, 0.0F, 0.0F);
        this.body.offsetY = -0.0F;
        this.body.render(0.01f);
        resetToDefaultPose();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        this.resetToDefaultPose();
        //this.body.offsetY = 0.7F;

        EntityPrehistoricFloraInsectFlyingBase ee = (EntityPrehistoricFloraInsectFlyingBase) e;
        if (ee.flyProgress != 0 && ee.getAttachmentPos() == null) {
            this.setRotateAngle(legR3, 0.0F, 0.0F, -0.7854F);
            this.setRotateAngle(legR2, 0.0F, 0.0F, -0.7854F);
            this.setRotateAngle(legL3, 0.0F, 0.0F, 0.7854F);
            this.setRotateAngle(legL2, 0.0F, 0.0F, 0.7854F);
            this.setRotateAngle(legR, 0.0F, 0.0F, -0.7854F);
            this.setRotateAngle(legL, 0.0F, 0.0F, 0.7854F);
            this.setRotateAngle(hindwingR, 0.0F, 0.3491F, 0.0F);
            this.setRotateAngle(forewingR, 0.0F, -0.3491F, 0.0F);
            this.setRotateAngle(forewingL, 0.0F, 0.3491F, 0.0F);
            this.setRotateAngle(hindwingL, 0.0F, -0.3491F, 0.0F);
            //this.setRotateAngle(cerciL, 0.0F, 0.2618F, 0.0F);
            //this.setRotateAngle(cerciR, 0.0F, -0.2618F, 0.0F);
            this.setRotateAngle(antennaL, -0.2618F, -0.2618F, 0.0F);
            this.setRotateAngle(antennaR, -0.2618F, 0.2618F, 0.0F);
            this.setRotateAngle(mouth, 0.4363F, 0.0F, 0.0F);

            //this.swing(cerciL, 1F, -0.4F, false, 0, -0.1F, f2, 0.8F);
            //this.swing(cerciR, 1F, 0.4F, false, 0, 0.1F, f2, 0.8F);
            float modifier = 1F;
            //modifier = 0.02F;
            this.flap(forewingL,2.2F * modifier, 0.5F, true, 0,0, f2, 1F);
            this.flap(hindwingL,2.2F * modifier, 0.5F, true, 3,0, f2, 1F);
            //this.flap(forewingL,2.2F * modifier, 0.5F, true, -1,0.2F, f2, 1F);
            this.flap(forewingR,2.2F * modifier, 0.5F, false, 0,0, f2, 1F);
            this.flap(hindwingR,2.2F * modifier, 0.5F, false, 3,0F, f2, 1F);
            //this.flap(forewingR,2.2F * modifier, 0.5F, false, -1,0.2F, f2, 1F);
        }

        this.walk(antennaL, 0.3F, -0.15F, false,0,0.1F, f2, 1F);
        this.walk(antennaR, 0.3F, 0.15F, false,0,0.1F, f2, 1F);
        this.swing(antennaL, 0.3F, -0.25F, false, 0, -0.1F, f2, 0.8F);
        this.swing(antennaR, 0.3F, 0.25F, false, 0, 0.1F, f2, 0.8F);
        //this.swing(mouth, 1.3F, 0.2F, false, 0, 0.1F, f2, 0.8F);
        this.swing(cerciL, 0.12F, -0.22F, false, 0, -0.1F, f2, 0.8F);
        this.swing(cerciR, 0.12F, 0.22F, false, 0, 0.1F, f2, 0.8F);

    }
}
