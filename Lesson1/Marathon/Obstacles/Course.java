package Lesson1.Marathon.Obstacles;

import Lesson1.Marathon.Competitors.Competitor;
import Lesson1.Marathon.Competitors.Team;

public class Course {

    //Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120), new Water(100)};
    public Obstacle[] course;

    public Course(Obstacle... obstacles){
        this.course = obstacles;
    }


    public void doItAll(Team team){

        for (Competitor c : team.competitors) {
           for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
