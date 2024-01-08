package com.github.thedeathlycow.whitelist.fix;

import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class WhitelistFixForge {
    
    public WhitelistFixForge() {
        WhitelistFixCommon.init();
    }
}