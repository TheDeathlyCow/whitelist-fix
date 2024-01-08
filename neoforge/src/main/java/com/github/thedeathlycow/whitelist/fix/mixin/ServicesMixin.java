package com.github.thedeathlycow.whitelist.fix.mixin;

import com.github.thedeathlycow.whitelist.fix.UpdatedGameProfileRepository;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.server.Services;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;

@Mixin(Services.class)
public class ServicesMixin {

    @Inject(
            method = "create",
            at = @At("TAIL")
    )
    private static void createUpdatedRepository(YggdrasilAuthenticationService service, File file, CallbackInfoReturnable<Services> cir) {
        Services repository = cir.getReturnValue();

        UpdatedGameProfileRepository.fixSearchUrl(
                repository.profileRepository()
        );
    }

}
