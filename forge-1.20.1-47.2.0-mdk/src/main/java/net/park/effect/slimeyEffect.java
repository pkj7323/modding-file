package net.park.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// Distributed under MIT
public class slimeyEffect extends MobEffect {
    protected slimeyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.horizontalCollision){
            Vec3 initialVec=pLivingEntity.getDeltaMovement();
            Vec3 climVec=new Vec3(initialVec.x,0.2D,initialVec.z);
            pLivingEntity.setDeltaMovement(climVec.x*0.91D,climVec.y*0.98D,climVec.z*0.91D);
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
    
}
