package Lesson1.Marathon;

import Lesson1.Marathon.Competitors.*;
import Lesson1.Marathon.Obstacles.*;

public class Main {

    public static void main(String[] args) {
        // команда может состоять из: Dog, Human, Cat
        Team team1 = new Team ("Happy Tree Friends", new Dog("Bobik"), new Human("Jon"), new Cat("Murzik"));
        Team team2 = new Team("Justice Team", new Dog("SuperDog"), new Human("SuperMan"));

        //препятствия могут быть: Wall, Water, Cross
        Course c1 = new Course(new Wall(3), new Water(4), new Cross(10), new Wall(7));

        team2.fullTeamInfo();
        //c1.doItAll(team1);
        c1.doItAll(team2);
        team2.checkTeamInfo();
    }
}