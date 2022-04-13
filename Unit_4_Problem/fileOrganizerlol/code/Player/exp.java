package fileOrganizerlol.code.Player;

public class exp {
    public int experiencePerLevel(int level) {
      if(level==1) 
        return 10;
      else
        return (int) (50 * (Math.pow(level, 2)) - (50 * level));
    }
}
