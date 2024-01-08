package com.github.thedeathlycow.whitelist.fix;

import com.mojang.authlib.GameProfileRepository;

import java.lang.reflect.Field;

public class UpdatedGameProfileRepository {

    /**
     * Patches an instance of {@link GameProfileRepository} to use the updated profile lookup url.
     *
     * Use this method only if working with a loader that doesn't allow mixin to {@link com.mojang} packages
     * (cough, Forge).
     *
     * @param repository Repository instance to patch
     * @return Returns true on successful patching
     */
    public static boolean fixSearchUrl(GameProfileRepository repository) {

        boolean success = true;

        try {
            Field searchPageUrl = repository.getClass().getDeclaredField("searchPageUrl");

            searchPageUrl.setAccessible(true); //NOSONAR
            searchPageUrl.set(repository, Constants.PROFILES_URL); //NOSONAR

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            Constants.LOG.error("Unable to fix whitelist: {0}", e);
            success = false;
        }

        return success;
    }

    private UpdatedGameProfileRepository() {

    }
}
