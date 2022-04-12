package fileOrganizerlol.code.Player;

public class exp {
    public static int experiencePerLevel(int level) {
        return (int) (50 * (Math.pow(level, 2)) - (50 * level));
    }
}
