package walksy.shieldstatus.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import walksy.shieldstatus.manager.ConfigManager;
import walksy.shieldstatus.manager.ShieldDataManager;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "tick()V", at = @At("HEAD"))
    private void onTick(CallbackInfo ci)
    {
        if (!ConfigManager.modEnabled) return;
        ShieldDataManager.INSTANCE.tick();
    }
}
