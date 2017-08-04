package Task1_3_Bus.Database;

import Task1_3_Bus.Entity.Driver;

public class Database {

    public final Driver[] namesOfDrivers = {
            new Driver("Sonny", "Landham"),
            new Driver("Arnold", "Schwarzenegger"),
            new Driver("Carl", "Weathers"),
            new Driver("Bill", "Duke")};

    public final String[] namesOfBusMarks = {"Icarus", "Bogdan ", "Mercedes", "Tata"};
    public final String[] busesNumbers = {"AA1111AA", "AA2222AA", "AA3333AA", "AA4444AA", "AA5555AA", "AA6666AA", "AA7777AA"};
    public final int[] routesNumbers = {04, 11, 16, 18, 24, 28, 666};
}
