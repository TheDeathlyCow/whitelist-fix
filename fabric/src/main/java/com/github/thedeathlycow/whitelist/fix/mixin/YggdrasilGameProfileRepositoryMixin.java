package com.github.thedeathlycow.whitelist.fix.mixin;

import com.github.thedeathlycow.whitelist.fix.Constants;
import com.mojang.authlib.yggdrasil.YggdrasilGameProfileRepository;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.net.URL;

/**
 * Updates the URL of the findProfiles end point. This patch makes the `/whitelist add` command work like normal
 * for Fabric, Quilt, Forge, and NeoForge.
 *
 * Note that Bukkit/Spigot/Paper users must use the `/whitelistfix add` instead, as Mixins are not supported on that platform.
 */
@Mixin(value = YggdrasilGameProfileRepository.class, remap = false)
public class YggdrasilGameProfileRepositoryMixin {

    @ModifyArg(
            method = "findProfilesByNames",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/authlib/minecraft/client/MinecraftClient;post(Ljava/net/URL;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;"
            )
    )
    private URL changeEnvironmentForSearch(final URL url) {
        Constants.LOG.info("Applying Whitelist fix url");
        return Constants.PROFILES_URL;
    }

}
