package Lesson1.Marathon.Competitors;



public class Team {

    private String commandName;  //имя команды
    public Competitor[] competitors; // участники команды

    public Team(String commandName, Competitor... competitors){
        this.commandName = commandName;
        this.competitors = competitors;
    }

    //метод вызова сведений о всех членах команды
    public void fullTeamInfo(){
        System.out.println("Выступает команда: " + commandName);
        System.out.println("В составе: ");

        for (Competitor c: competitors) c.infoShort();

        System.out.println("\n");
    }

    //метод вывода инфомрации о членах команды и о статусе прохождения дистанции
    public void checkTeamInfo(){
        System.out.println("\n");
        for (Competitor c : competitors) c.info();

    }
}
