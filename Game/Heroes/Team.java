package Game.Heroes;

import java.util.Random;

public class Team {

    private static boolean teamAlive = true;
    private static Random randomCompetitor = new Random();

    public static void TeamInfo(Hero[] team) {
        System.out.println("Состав команды: Имя персонажа  Здоровье  Урон");
        for (Hero t : team) {
            t.info();
        }
        System.out.println("\n");
    }

    public static boolean TeamAlive(Hero[] team) {
        for (Hero hero : team) {
            if (hero.getHealth() > 0) {
                teamAlive = true;
                break;
            } else teamAlive = false;
        }
        return teamAlive;
    }

    public static int returnRandomAliveCompetitor(Hero[] team) {
        int aliveCompetitorNumber;

        do {
            aliveCompetitorNumber = randomCompetitor.nextInt(team.length);
        }while (team[aliveCompetitorNumber].getHealth() <= 0);

        return aliveCompetitorNumber;
    }
}
