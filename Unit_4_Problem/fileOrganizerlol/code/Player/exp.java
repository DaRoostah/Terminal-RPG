package fileOrganizerlol.code.Player;

public class exp {
    public static int experiencePerLevel(player player) {
        return (int) (50 * (Math.pow(player.getLevel(), 2)) - (50 * player.getLevel()));
    }
}
