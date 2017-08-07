package task3_1.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public void add(Day day) {
        days.add(day);
    }

    public Calendar findAllHolidays() {
        Calendar results = new Calendar();
        for (Day day : days) {
            if (day.getDayType() == DayType.HOLIDAY) {
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

        public Day(int day, Months month, int year, DayType dayType) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayType = dayType;
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

        @Override
        public String toString() {
            return "Day{" +
                    "day=" + day +
                    ", month=" + month +
                    ", year=" + year +
                    ", dayType=" + dayType +
                    '}';
        }
    }

    enum DayType {HOLIDAY, WORKDAY};

    enum Months {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
}
