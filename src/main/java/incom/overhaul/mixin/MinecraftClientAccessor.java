package incom.overhaul.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public interface MinecraftClientAccessor {
    @Accessor
    int getItemUseCooldown();

    // private int itemUseCooldown = ((MinecraftClientAccessor) MinecraftClient.getInstance()).getItemUseCooldown();

    @Accessor("itemUseCooldown")
    public void setItemUseCooldown(int itemUseCooldown);

    // ((MinecraftClientAccessor) MinecraftClient.getInstance()).setItemUseCooldown(100);
}