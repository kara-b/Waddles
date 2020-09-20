package nl.dyonb.waddles.client.model;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.util.math.MathHelper;
import nl.dyonb.waddles.common.entity.AdeliePenguinEntity;

@Environment(EnvType.CLIENT)
public class AdeliePenguinModel<T extends AdeliePenguinEntity> extends AnimalModel<T> {

    private ModelPart head;
    private ModelPart body;
    private ModelPart beak;
    private ModelPart flipperRight;
    private ModelPart flipperLeft;
    private ModelPart feetLeft;
    private ModelPart feetRight;
    private ModelPart tail;

    public AdeliePenguinModel() {
        super(false, 6.0F, 0.0F);
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.beak = new ModelPart(this, 18, 0);
        this.beak.setPivot(0.0F, 0.0F, 0.0F);
        this.beak.addCuboid(-0.5F, -3.0F, -4.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(beak, 0.08726646259971647F, -0.0F, 0.0F);

        this.body = new ModelPart(this, 0, 9);
        this.body.setPivot(0.0F, 12.0F, 1.0F);
        this.body.addCuboid(-2.5F, 0.0F, -2.0F, 5, 11, 5, 0.0F);

        this.feetRight = new ModelPart(this, 0, 25);
        this.feetRight.setPivot(-1.0F, 11.0F, 0.0F);
        this.feetRight.addCuboid(-2.0F, 0.0F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(feetRight, 0.0F, 0.2617993877991494F, 0.0F);

        this.head = new ModelPart(this, 0, 0);
        this.head.setPivot(0.0F, 12.0F, 0.0F);
        this.head.addCuboid(-2.0F, -4.0F, -2.0F, 4, 4, 5, 0.0F);

        this.tail = new ModelPart(this, 20, 20);
        this.tail.setPivot(0.0F, 11.0F, 3.0F);
        this.tail.addCuboid(-1.5F, -1.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(tail, 1.2566370614359172F, 0.0F, 0.0F);

        this.flipperRight = new ModelPart(this, 20, 10);
        this.flipperRight.setPivot(-2.5F, 1.0F, 0.0F);
        this.flipperRight.addCuboid(-1.0F, 0.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(flipperRight, 0.0F, 0.0F, 0.08726646259971647F);

        this.feetLeft = new ModelPart(this, 0, 25);
        this.feetLeft.mirror = true;
        this.feetLeft.setPivot(1.0F, 11.0F, 0.0F);
        this.feetLeft.addCuboid(0.0F, 0.0F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(feetLeft, 0.0F, -0.2617993877991494F, 0.0F);

        this.flipperLeft = new ModelPart(this, 20, 10);
        this.flipperLeft.mirror = true;
        this.flipperLeft.setPivot(2.5F, 1.0F, 0.0F);
        this.flipperLeft.addCuboid(0.0F, 0.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(flipperLeft, 0.0F, 0.0F, -0.08726646259971647F);

        this.head.addChild(this.beak);
        this.body.addChild(this.feetRight);
        this.body.addChild(this.feetLeft);
        this.body.addChild(this.flipperRight);
        this.body.addChild(this.flipperLeft);
        this.body.addChild(this.tail);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body);
    }

    private void setRotateAngle(ModelPart modelPart, float x, float y, float z) {
        modelPart.pitch = x;
        modelPart.yaw = y;
        modelPart.roll = z;
    }

    @Override
    public void setAngles(AdeliePenguinEntity adeliePenguinEntity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.pitch = headPitch * 0.017453292F;
        this.head.yaw = headYaw * 0.017453292F;
        this.head.roll = (MathHelper.cos(limbAngle * 1.3324F) * 1.4F * limbDistance) / 6;

        this.body.roll = (MathHelper.cos(limbAngle * 1.3324F) * 1.4F * limbDistance) / 6;

        this.feetRight.pitch = MathHelper.cos(limbAngle * 1.3324F) * 1.2F * limbDistance;
        this.feetLeft.pitch = MathHelper.cos(limbAngle * 1.3324F + (float) Math.PI) * 1.2F * limbDistance;

        this.flipperRight.roll = 0.08726646259971647F + (MathHelper.cos(adeliePenguinEntity.rotationFlipper) * limbDistance);
        this.flipperLeft.roll = -0.08726646259971647F + (MathHelper.cos((float) adeliePenguinEntity.rotationFlipper + (float) Math.PI) * limbDistance);

        this.tail.yaw = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * 1.4F * limbDistance;
    }

}
