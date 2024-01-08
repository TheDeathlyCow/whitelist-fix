package com.github.thedeathlycow.whitelist.fix;


import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class WhitelistFixNeoForge {

    public WhitelistFixNeoForge() {
        WhitelistFixCommon.init();
    }
}