package eecs448_first_team.calender_app;


public class SafeDate {
    private int date = 0;
    private String name = "";
    private SafeDate( String date){
        this.name = name;
    }
    private SafeDate( int date) {
        this.date = date;
    }


    public int getDate() {
        return date;
    }

    public String getName(){
        return name;
    }


    public static final SafeDate January = new SafeDate(1);
    public static final SafeDate February = new SafeDate(2);
    public static final SafeDate March = new SafeDate(3);
    public static final SafeDate April = new SafeDate(4);
    public static final SafeDate May = new SafeDate(5);
    public static final SafeDate June = new SafeDate(6);
    public static final SafeDate July = new SafeDate(7);
    public static final SafeDate August = new SafeDate(8);
    public static final SafeDate September = new SafeDate(9);
    public static final SafeDate October = new SafeDate(10);
    public static final SafeDate November = new SafeDate(11);
    public static final SafeDate December = new SafeDate(12);


    public static final SafeDate stringJanuary = new SafeDate("January");
    public static final SafeDate stringFebruary = new SafeDate("February");
    public static final SafeDate stringMarch = new SafeDate("March");
    public static final SafeDate stringApril = new SafeDate("April");
    public static final SafeDate stringMay = new SafeDate("May");
    public static final SafeDate stringJune = new SafeDate("June");
    public static final SafeDate stringJuly = new SafeDate("July");
    public static final SafeDate stringAugust = new SafeDate("August");
    public static final SafeDate stringSeptember = new SafeDate("September");
    public static final SafeDate stringOctober = new SafeDate("October");
    public static final SafeDate stringNovember = new SafeDate("November");
    public static final SafeDate stringDecember = new SafeDate("December");


    public static final SafeDate fallYear = new SafeDate(2016);
    public static final SafeDate springYear = new SafeDate(2017);


    public static final SafeDate stringFallYear = new SafeDate("2016");
    public static final SafeDate stringSpringYear = new SafeDate("2017");


    public static final SafeDate day00 = new SafeDate(0);
    public static final SafeDate day01 = new SafeDate(1);
    public static final SafeDate day02 = new SafeDate(2);
    public static final SafeDate day03 = new SafeDate(3);
    public static final SafeDate day04 = new SafeDate(4);
    public static final SafeDate day05 = new SafeDate(5);
    public static final SafeDate day06 = new SafeDate(6);
    public static final SafeDate day07 = new SafeDate(7);
    public static final SafeDate day08 = new SafeDate(8);
    public static final SafeDate day09 = new SafeDate(9);
    public static final SafeDate day10 = new SafeDate(10);
    public static final SafeDate day11 = new SafeDate(11);
    public static final SafeDate day12 = new SafeDate(12);
    public static final SafeDate day13 = new SafeDate(13);
    public static final SafeDate day14 = new SafeDate(14);
    public static final SafeDate day15 = new SafeDate(15);
    public static final SafeDate day16 = new SafeDate(16);
    public static final SafeDate day17 = new SafeDate(17);
    public static final SafeDate day18 = new SafeDate(18);
    public static final SafeDate day19 = new SafeDate(19);
    public static final SafeDate day20 = new SafeDate(20);
    public static final SafeDate day21 = new SafeDate(21);
    public static final SafeDate day22 = new SafeDate(22);
    public static final SafeDate day23 = new SafeDate(23);
    public static final SafeDate day24 = new SafeDate(24);
    public static final SafeDate day25 = new SafeDate(25);
    public static final SafeDate day26 = new SafeDate(26);
    public static final SafeDate day27 = new SafeDate(27);
    public static final SafeDate day28 = new SafeDate(28);
    public static final SafeDate day29 = new SafeDate(29);
    public static final SafeDate day30 = new SafeDate(30);
    public static final SafeDate day31 = new SafeDate(31);
}
