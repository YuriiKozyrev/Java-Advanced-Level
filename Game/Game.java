package Game;

import Game.Heroes.*;

class Game {
    public static void main(String[] args) {

        GameEngine GE = new GameEngine();

        Hero[] team1 = new Hero[]{new Warrior(250, "Тигрил", 50, 0)
                , new Assasin(150, "Акали", 70, 0)
                , new Doctor(120, "Жанна", 0, 10)};

        Hero[] team2 = new Hero[]{new Warrior(290, "Минотавр", 60, 0)
                , new Assasin(160, "Джинкс", 90, 0)
                , new Doctor(110, "Зои", 0, 10)};

        GE.LetsGo(team1, team2);
    }
}
