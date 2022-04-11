package fileOrganizerlol.Store;

import fileOrganizerlol.code.Player.player;

/**
 * INCREASE HEALTH:	       +1
 * INCREASE DEFENCE: 	   +1
 * INCREASE ATTACK: 	   +1
 * INCREASE INTELLIGENCE:  +1
 */
public class LevelUp {
    private String[][] stats = {{"+1"},
                                {"1. INCREASE HEALTH:	   ", "2. INCREASE DEFENCE: 	   ", "3. INCREASE ATTACK: 	   ", "4. INCREASE INTELLIGENCE:  "}};
    public String showStore(player player) {
        String statInfo = "";
        String addInfo = "";
        for(String[] statIncrements : stats) {
            for(String increments : statIncrements) {
                if(increments.indexOf("+") != -1)
                    addInfo += increments;
                if(increments.indexOf("INCREASE") != -1)
                statInfo += increments + addInfo + "\n";
            }
        }
        return statInfo;
    }
}
