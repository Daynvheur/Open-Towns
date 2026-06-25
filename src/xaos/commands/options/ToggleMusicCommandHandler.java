package xaos.commands.options;

import xaos.commands.CommandContext;
import xaos.commands.CommandHandler;
import xaos.main.Game;
import xaos.utils.Utils;
import xaos.utils.UtilsAL;

public final class ToggleMusicCommandHandler implements CommandHandler {

    @Override
    public void execute(CommandContext context) {
        Game.setMusicON(!Game.isMusicON());
        Utils.saveOptions();

        if (!Game.isMusicON()) {
            UtilsAL.stopMusic();
            return;
        }

        UtilsAL.initAL(Game.getVolumeMusic(), Game.getVolumeFX());

        if (Game.getPanelMainMenu().isActive()) {
            UtilsAL.play(UtilsAL.SOURCE_MUSIC_MAINMENU);
        } else {
            UtilsAL.play(UtilsAL.SOURCE_MUSIC_INGAME);
        }
    }
}