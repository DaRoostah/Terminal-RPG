package fileOrganizerlol.code.Player;

public class exp {
    public int experiencePerLevel(player player) {
        return 50 * (player.getLevel() ^ 2) - (50 * player.getLevel());
    }
}
