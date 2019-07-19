package Lesson2.HW;

public class DayOfWeekMain {

    enum DayOfWeek {
        MONDAY( 8), TUESDAY( 8), WEDNESDAY( 8), THURSDAY( 8), FRIDAY( 7), SATURDAY( 0), SUNDAY( 0);

        private int workingHours; // количество рабочих часов

        //конструктор
        DayOfWeek(int workingHours){
            this.workingHours = workingHours;
        }

        int getWorkingHours(){
            return workingHours;
        }
    }

    public static String getAllWorkingHours(DayOfWeek day){
        String result;
        int sum = 0;

        for(int i = day.ordinal(); i < DayOfWeek.values().length; i++){
            sum += DayOfWeek.values()[i].getWorkingHours();
        }

        if(sum == 0) result = "Это ж выходной! Количество рабочих часов до конца недели: " + sum;
        else result = "Количество рабочих часов до конца недели: " + sum;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getAllWorkingHours(DayOfWeek.SATURDAY));
    }
}
