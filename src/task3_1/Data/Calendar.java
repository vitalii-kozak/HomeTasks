package task3_1.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Calendar implements Serializable {
    private List<Day> days;
    private int count;

    public Calendar() {
        this.days = new ArrayList<>();
        this.count = days.size();
    }

    public Calendar(List<Day> days) {
        this.days = days;
        this.count = days.size();
    }

    public void fillTheCalendar(){

        days.add(new Day(1,Months.JUN,2017, DayType.HOLIDAY, HolidayType.NATIONAL, "New Year"));
        days.add(new Day(7,Months.JUN,2017, DayType.HOLIDAY, HolidayType.CHURCH, "Cristmas"));
        days.add(new Day(14,Months.FEB,2017, DayType.HOLIDAY, HolidayType.ORDINARY, "Saint Valentine day"));
        days.add(new Day(28,Months.JUN,2017, DayType.HOLIDAY, HolidayType.NATIONAL, "Day of Constitution"));
        days.add(new Day(24,Months.AUG,2017, DayType.HOLIDAY, HolidayType.NATIONAL, "Day of independence"));
        days.add(new Day(24,Months.DEC,2017, DayType.HOLIDAY, HolidayType.CHURCH, "Catholic Cristmas"));
    }

    public void add(Day day) {
        days.add(day);
    }

//    public void addCalendar(Calendar days) { this = days;}

    public Calendar findAllHolidays() {
        Calendar results = new Calendar();
        for (Day day : days) {
            if (day.getDayType() == DayType.HOLIDAY) {
                results.add(day);
            }
        }
        return results;
    }

    public Calendar findAllChurchHolidays() {
        Calendar results = new Calendar();
        for (Day day : days) {
            if ((day.getDayType() == DayType.HOLIDAY)&&((day.getHolidayType() == HolidayType.CHURCH))) {
                results.add(day);
            }
        }
        return results;
    }

    private class Day implements Serializable {
        private int day;
        private Months month;
        private int year;
        private DayType dayType;
        private HolidayType holidayType;
        private String dayDescription;

        public Day(int day, Months month, int year, DayType dayType, HolidayType holidayType, String dayDescription) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayType = dayType;
            this.holidayType = holidayType;
            this.dayDescription = dayDescription;
        }

        public int getDay() {
            return day;
        }

        public Months getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }

        public DayType getDayType() {
            return dayType;
        }

        public HolidayType getHolidayType() {
            return holidayType;
        }

        public String getDayDescription() {
            return dayDescription;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "day=" + day +
                    ", month=" + month +
                    ", year=" + year +
                    ", dayType=" + dayType +
                    ", holidayType=" + holidayType +
                    ", dayDescription='" + dayDescription + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Day day : days) {
            joiner.add(day.toString());
        }
        return "Days:\n" + joiner.toString();
    }


    enum DayType {HOLIDAY, WORKDAY};

    enum HolidayType {CHURCH, NATIONAL, ORDINARY};

    enum Months {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
}
