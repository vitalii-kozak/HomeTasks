package task3_1.Tools;

import task3_1.Data.Calendar;

import java.io.*;

public class CalendarStore {
    public static boolean exportToFile(String fileName, Object object) {

        try (ObjectOutputStream file = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            file.writeObject(object);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Calendar importFromFile(String fileName) {

        Calendar days = null;
        try (ObjectInputStream file = new ObjectInputStream(
                new FileInputStream(fileName))) {
            days = (Calendar) file.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return days;
    }
}
