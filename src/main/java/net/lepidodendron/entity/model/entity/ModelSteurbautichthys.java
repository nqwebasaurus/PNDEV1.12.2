package net.lepidodendron.entity.model.entity;

import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.lepidodendron.entity.model.ModelBasePalaeopedia;
import net.minecraft.client.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class ModelSteurbautichthys extends ModelBasePalaeopedia {
    private final AdvancedModelRenderer Steurbautichthys;
    private final AdvancedModelRenderer Head;
    private final AdvancedModelRenderer cube_r1;
    private final AdvancedModelRenderer cube_r2;
    private final AdvancedModelRenderer cube_r3;
    private final AdvancedModelRenderer cube_r4;
    private final AdvancedModelRenderer cube_r5;
    private final AdvancedModelRenderer cube_r6;
    private final AdvancedModelRenderer Jaw;
    private final AdvancedModelRenderer cube_r7;
    private final AdvancedModelRenderer Body1;
    private final AdvancedModelRenderer PectoralL;
    private final AdvancedModelRenderer cube_r8;
    private final AdvancedModelRenderer PectoralR;
    private final AdvancedModelRenderer cube_r9;
    private final AdvancedModelRenderer Body2;
    private final AdvancedModelRenderer cube_r10;
    private final AdvancedModelRenderer cube_r11;
    private final AdvancedModelRenderer PelvicL;
    private final AdvancedModelRenderer PelvicR;
    private final AdvancedModelRenderer Body3;
    private final AdvancedModelRenderer cube_r12;
    private final AdvancedModelRenderer cube_r13;
    private final AdvancedModelRenderer Body4;
    private final AdvancedModelRenderer cube_r14;
    private final AdvancedModelRenderer cube_r15;
    private final AdvancedModelRenderer Body5;

    public ModelSteurbautichthys() {
        this.textureWidth = 60;
        this.textureHeight = 55;

        this.Steurbautichthys = new AdvancedModelRenderer(this);
        this.Steurbautichthys.setRotationPoint(0.0F, 27.0F, -3.0F);


        this.Head = new AdvancedModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -7.0F, -2.0F);
        this.Steurbautichthys.addChild(Head);
        this.Head.cubeList.add(new ModelBox(Head, 31, 21, -2.5F, -3.0F, -2.0F, 5, 6, 3, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(Head, 24, 11, -3.0F, -3.0F, 0.0F, 6, 6, 3, 0.001F, false));

        this.cube_r1 = new AdvancedModelRenderer(this);
        this.cube_r1.setRotationPoint(0.0F, 1.5F, -2.0F);
        this.Head.addChild(cube_r1);
        this.setRotateAngle(cube_r1, -0.6021F, 0.0F, 0.0F);
        this.cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 7, -2.0F, -1.9F, -2.1F, 4, 2, 3, 0.0F, false));

        this.cube_r2 = new AdvancedModelRenderer(this);
        this.cube_r2.setRotationPoint(0.0F, -2.4F, -3.8F);
        this.Head.addChild(cube_r2);
        this.setRotateAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
        this.cube_r2.cubeList.add(new ModelBox(cube_r2, 48, 21, -1.0F, 0.034F, -1.9412F, 2, 2, 2, 0.0F, false));

        this.cube_r3 = new AdvancedModelRenderer(this);
        this.cube_r3.setRotationPoint(0.0F, -3.9F, -1.1F);
        this.Head.addChild(cube_r3);
        this.setRotateAngle(cube_r3, 0.0349F, 0.0F, 0.0F);
        this.cube_r3.cubeList.add(new ModelBox(cube_r3, 27, 31, -2.0F, -0.017F, -0.0294F, 4, 2, 4, 0.002F, false));

        this.cube_r4 = new AdvancedModelRenderer(this);
        this.cube_r4.setRotationPoint(0.0F, -3.4F, -2.0F);
        this.Head.addChild(cube_r4);
        this.setRotateAngle(cube_r4, 0.5236F, 0.0F, 0.0F);
        this.cube_r4.cubeList.add(new ModelBox(cube_r4, 41, 35, -2.0F, 0.0F, -2.0F, 4, 2, 3, 0.0F, false));

        this.cube_r5 = new AdvancedModelRenderer(this);
        this.cube_r5.setRotationPoint(0.0F, 3.0F, -2.0F);
        this.Head.addChild(cube_r5);
        this.setRotateAngle(cube_r5, -0.2443F, 0.0F, 0.0F);
        this.cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 39, -2.0F, -1.1F, 0.2F, 4, 1, 4, 0.001F, false));

        this.cube_r6 = new AdvancedModelRenderer(this);
        this.cube_r6.setRotationPoint(0.0F, -3.9F, -2.5F);
        this.Head.addChild(cube_r6);
        this.setRotateAngle(cube_r6, -0.3229F, 0.0F, 0.0F);
        this.cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 26, -2.5F, 1.9993F, 0.6185F, 5, 1, 1, 0.04F, false));
        this.cube_r6.cubeList.add(new ModelBox(cube_r6, 43, 13, -2.5F, 1.4993F, 0.1185F, 5, 2, 2, 0.03F, false));

        this.Jaw = new AdvancedModelRenderer(this);
        this.Jaw.setRotationPoint(0.0F, 1.6F, -1.95F);
        this.Head.addChild(Jaw);
        this.setRotateAngle(Jaw, -0.0873F, 0.0F, 0.0F);


        this.cube_r7 = new AdvancedModelRenderer(this);
        this.cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addChild(cube_r7);
        this.setRotateAngle(cube_r7, -0.5934F, 0.0F, 0.0F);
        this.cube_r7.cubeList.add(new ModelBox(cube_r7, 20, 0, -1.0F, 0.0F, -4.1F, 2, 1, 2, -0.01F, false));
        this.cube_r7.cubeList.add(new ModelBox(cube_r7, 42, 0, -2.0F, 0.0F, -2.1F, 4, 1, 3, -0.01F, false));

        this.Body1 = new AdvancedModelRenderer(this);
        this.Body1.setRotationPoint(0.0F, -1.0F, 3.0F);
        this.Head.addChild(Body1);
        this.Body1.cubeList.add(new ModelBox(Body1, 0, 0, -3.5F, -3.0F, -1.0F, 7, 8, 5, 0.0F, false));

        this.PectoralL = new AdvancedModelRenderer(this);
        this.PectoralL.setRotationPoint(3.5F, 4.0F, 1.6F);
        this.Body1.addChild(PectoralL);


        this.cube_r8 = new AdvancedModelRenderer(this);
        this.cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PectoralL.addChild(cube_r8);
        this.setRotateAngle(cube_r8, 0.0F, 0.48F, 0.0F);
        this.cube_r8.cubeList.add(new ModelBox(cube_r8, 43, 26, 0.0F, -1.0F, 0.0F, 0, 2, 5, 0.0F, false));

        this.PectoralR = new AdvancedModelRenderer(this);
        this.PectoralR.setRotationPoint(-3.5F, 4.0F, 1.6F);
        this.Body1.addChild(PectoralR);


        this.cube_r9 = new AdvancedModelRenderer(this);
        this.cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PectoralR.addChild(cube_r9);
        this.setRotateAngle(cube_r9, 0.0F, -0.48F, 0.0F);
        this.cube_r9.cubeList.add(new ModelBox(cube_r9, 43, 26, 0.0F, -1.0F, 0.0F, 0, 2, 5, 0.0F, true));

        this.Body2 = new AdvancedModelRenderer(this);
        this.Body2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Body1.addChild(Body2);
        this.Body2.cubeList.add(new ModelBox(Body2, 0, 14, -3.0F, -2.0F, -1.0F, 6, 6, 5, 0.0F, false));

        this.cube_r10 = new AdvancedModelRenderer(this);
        this.cube_r10.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Body2.addChild(cube_r10);
        this.setRotateAngle(cube_r10, -0.1309F, 0.0F, 0.0F);
        this.cube_r10.cubeList.add(new ModelBox(cube_r10, 26, 38, -2.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F, false));

        this.cube_r11 = new AdvancedModelRenderer(this);
        this.cube_r11.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Body2.addChild(cube_r11);
        this.setRotateAngle(cube_r11, 0.1309F, 0.0F, 0.0F);
        this.cube_r11.cubeList.add(new ModelBox(cube_r11, 13, 35, -2.0F, -1.0F, 0.0F, 4, 1, 4, 0.0F, false));

        this.PelvicL = new AdvancedModelRenderer(this);
        this.PelvicL.setRotationPoint(2.0F, 4.5F, 1.1F);
        this.Body2.addChild(PelvicL);
        this.setRotateAngle(PelvicL, 0.0F, 0.0F, 1.0908F);
        this.PelvicL.cubeList.add(new ModelBox(PelvicL, 43, 18, -1.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F, false));

        this.PelvicR = new AdvancedModelRenderer(this);
        this.PelvicR.setRotationPoint(-2.0F, 4.5F, 1.1F);
        this.Body2.addChild(PelvicR);
        this.setRotateAngle(PelvicR, 0.0F, 0.0F, -1.0908F);
        this.PelvicR.cubeList.add(new ModelBox(PelvicR, 43, 18, -2.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F, true));

        this.Body3 = new AdvancedModelRenderer(this);
        this.Body3.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Body2.addChild(Body3);
        this.Body3.cubeList.add(new ModelBox(Body3, 25, 0, -2.0F, -2.0F, -1.0F, 4, 5, 4, -0.001F, false));

        this.cube_r12 = new AdvancedModelRenderer(this);
        this.cube_r12.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.Body3.addChild(cube_r12);
        this.setRotateAngle(cube_r12, -0.1309F, 0.0F, 0.0F);
        this.cube_r12.cubeList.add(new ModelBox(cube_r12, 7, 45, 0.0F, -3.0F, -0.1F, 0, 3, 3, 0.0F, false));
        this.cube_r12.cubeList.add(new ModelBox(cube_r12, 26, 44, -1.0F, 0.0F, -0.1F, 2, 1, 3, 0.0F, false));

        this.cube_r13 = new AdvancedModelRenderer(this);
        this.cube_r13.setRotationPoint(0.0F, 4.4F, 0.0F);
        this.Body3.addChild(cube_r13);
        this.setRotateAngle(cube_r13, 0.4363F, 0.0F, 0.0F);
        this.cube_r13.cubeList.add(new ModelBox(cube_r13, 39, 41, -1.0F, -2.0F, 0.0F, 2, 2, 4, 0.0F, false));

        this.Body4 = new AdvancedModelRenderer(this);
        this.Body4.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Body3.addChild(Body4);
        this.Body4.cubeList.add(new ModelBox(Body4, 0, 30, -1.5F, -2.0F, -1.0F, 3, 3, 5, -0.002F, false));

        this.cube_r14 = new AdvancedModelRenderer(this);
        this.cube_r14.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Body4.addChild(cube_r14);
        this.setRotateAngle(cube_r14, 0.5236F, 0.0F, 0.0F);
        this.cube_r14.cubeList.add(new ModelBox(cube_r14, 0, 45, 0.0F, 0.0F, 0.0F, 0, 3, 3, 0.0F, false));

        this.cube_r15 = new AdvancedModelRenderer(this);
        this.cube_r15.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Body4.addChild(cube_r15);
        this.setRotateAngle(cube_r15, 0.4363F, 0.0F, 0.0F);
        this.cube_r15.cubeList.add(new ModelBox(cube_r15, 13, 41, -1.0F, -2.025F, 0.15F, 2, 2, 4, -0.01F, false));

        this.Body5 = new AdvancedModelRenderer(this);
        this.Body5.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.Body4.addChild(Body5);
        this.Body5.cubeList.add(new ModelBox(Body5, 14, 48, -1.0F, -0.5F, 0.0F, 2, 2, 2, 0.0F, false));
        this.Body5.cubeList.add(new ModelBox(Body5, 16, 19, 0.0F, -3.5F, 1.0F, 0, 8, 7, 0.0F, false));

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Steurbautichthys.render(f5);
    }

    public void renderStaticWall(float f) {
        this.Steurbautichthys.rotateAngleY = (float) Math.toRadians(90);
        this.Steurbautichthys.offsetZ = 0.05F;
        this.Steurbautichthys.offsetY = -0.2F;
        this.Steurbautichthys.offsetX = -0.06F;
        this.Steurbautichthys.render(0.01F);
        resetToDefaultPose();
    }
    public void renderStaticFloor(float f) {
        this.setRotateAngle(Steurbautichthys, -0.1F, 0.0F, 0.05F);
        this.setRotateAngle(Body1, 0.0F, 0.1F, 0.0F);
        this.setRotateAngle(Body2, 0.0F, 0.2F, 0.0F);
        this.setRotateAngle(Body3, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(Body4, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(Body5, 0.0F, -0.3F, 0.0F);
        this.Steurbautichthys.offsetY = -0.14F;
        this.Steurbautichthys.render(0.01F);
        resetToDefaultPose();
    }
    public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        this.resetToDefaultPose();
       // this.Steurbautichthys.offsetY = 0F;

        //this.Tailfin.setScale(1.1F, 1.1F, 1.1F);
        AdvancedModelRenderer[] fishTail = {this.Body3, this.Body4, this.Body5};
        float speed = 0.3F;
        if (!e.isInWater()) {
            speed = 0.5F;
        }
        if (e instanceof EntityLiving && !((EntityLiving) e).isAIDisabled()) {
            this.chainSwing(fishTail, speed*0.75F, 0.15F, 0, f2, 1);
            this.walk(Jaw, (float) (speed * 0.75), 0.3F, true, 0, 0, f2, 1);

            this.walk(PectoralL, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.swing(PectoralL, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.walk(PectoralR, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.swing(PectoralR, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.walk(PelvicL, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.swing(PelvicL, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.walk(PelvicR, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);
            this.swing(PelvicR, (float) (speed * 0.75), 0.15F, true, 0, 0, f2, 1);


            this.swing(Steurbautichthys, speed*0.75F, 0.2F, true, 0, 0, f2, 1);
             if (!e.isInWater()) {
                this.Steurbautichthys.rotateAngleZ = (float) Math.toRadians(90);
                this.Steurbautichthys.offsetY = -0.28F;
                this.bob(Steurbautichthys, speed*1.5F, 5F, false, f2, 1);
            }
        }
    }
}
