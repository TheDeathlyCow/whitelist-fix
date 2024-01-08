package com.github.thedeathlycow.whitelist.fix;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class WhitelistFixFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        WhitelistFixCommon.init();
    }
}
