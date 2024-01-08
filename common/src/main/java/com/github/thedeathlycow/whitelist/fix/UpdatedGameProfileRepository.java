package com.github.thedeathlycow.whitelist.fix;

import com.mojang.authlib.GameProfileRepository;

import java.lang.reflect.Field;

public class UpdatedGameProfileRepository {

    public static boolean fixSearchUrl(GameProfileRepository repository) {

        boolean success = true;

        try {
            Field searchPageUrl = repository.getClass().getDeclaredField("searchPageUrl");
            searchPageUrl.setAccessible(true);
            searchPageUrl.set(repository, Constants.PROFILES_URL);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            Constants.LOG.error("Unable to fix whitelist: {0}", e);
            success = false;
        }

        return success;
    }
}
