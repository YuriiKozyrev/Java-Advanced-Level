package Game;

import Game.Heroes.*;
import java.util.Random;

public  class GameEngine {

    private Random randomStep = new Random();

    public void LetsGo(Hero[] team1, Hero[] team2) {

        Team.TeamInfo(team1);
        Team.TeamInfo(team2);

        int j = 0;
        while (Team.TeamAlive(team1) & Team.TeamAlive(team2)) {
            System.out.println("Раунд: " + ++j);

            for (int i = 0; i < team1.length; i++) {

                if (randomStep.nextInt(2) == 0) {

                    //если попался доктор и он живой, то лечим случайного живого из своей команды, даже самого доктора
                    if (team1[i] instanceof Doctor & team1[i].getHealth() > 0)
                        team1[i].healing(team1[Team.returnRandomAliveCompetitor(team1)]);

                    //иначе если просто попался живой, то бъет любого случайного живого из другой команды
                    else if (team1[i].getHealth() > 0)
                        team1[i].hit(team2[Team.returnRandomAliveCompetitor(team2)]);


                } else {
                    if (team2[i] instanceof Doctor & team2[i].getHealth() > 0)
                        team2[i].healing(team2[Team.returnRandomAliveCompetitor(team2)]);

                    else if (team2[i].getHealth() > 0)
                        team2[i].hit(team1[Team.returnRandomAliveCompetitor(team1)]);

                }
            }
            System.out.println("------------------------------------------------\n");
            Team.TeamInfo(team1);
            Team.TeamInfo(team2);

        }
    }
}