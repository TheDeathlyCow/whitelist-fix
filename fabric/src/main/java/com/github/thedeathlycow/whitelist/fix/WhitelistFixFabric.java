package com.github.thedeathlycow.whitelist.fix;

import net.fabricmc.api.ModInitializer;

public class WhitelistFixFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        WhitelistFixCommon.init();
    }
}
