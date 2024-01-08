package com.github.thedeathlycow.whitelist.fix;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.HttpAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class Constants {

	public static final String MOD_ID = "whitelistfix";
	public static final String MOD_NAME = "Whitelist Fix";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final URL PROFILES_URL = HttpAuthenticationService.constantURL(
			"https://api.minecraftservices.com/minecraft/profile/lookup/bulk/byname"
	);
}