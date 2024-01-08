# Whitelist Fix

Fixes the "That player does not exist" error that shows up when attempting to whitelist players who have never joined the server before.

It does this by simply updating the Mojang API endpoint for the getting profile IDs lookup in the Yggdrasil Game 
Profile Repository to `https://api.minecraftservices.com/minecraft/profile/lookup/bulk/byname`.


## Related Issues

* Minecraft: https://bugs.mojang.com/browse/MC-267771
* Minecraft Web: https://bugs.mojang.com/browse/WEB-5959
* Paper: https://github.com/PaperMC/Paper/issues/10141