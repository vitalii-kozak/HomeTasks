package Task1_3_Bus.Entity;

public class Bus {
    private Driver driver;
    private double distance;
    private int startYear;
    private String busNumber;
    private int routeNumber;
    private String busMark;

    public Bus(Driver driver, double distance, int startyear, String busNumber, int routeNumber, String busMark) {
        this.driver = driver;
        this.distance = distance;
        this.startYear = startyear;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.busMark = busMark;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startyear) {
        this.startYear = startyear;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getBusMark() {
        return busMark;
    }

    public void setBusMark(String busMark) {
        this.busMark = busMark;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "driver=" + driver +
                ", distance=" + distance +
                ", startyear=" + startYear +
                ", busNumber='" + busNumber + '\'' +
                ", routeNumber=" + routeNumber +
                ", busMark='" + busMark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (Double.compare(bus.distance, distance) != 0) return false;
        if (startYear != bus.startYear) return false;
        if (routeNumber != bus.routeNumber) return false;
        if (driver != null ? !driver.equals(bus.driver) : bus.driver != null) return false;
        if (busNumber != null ? !busNumber.equals(bus.busNumber) : bus.busNumber != null) return false;
        return busMark != null ? busMark.equals(bus.busMark) : bus.busMark == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = driver != null ? driver.hashCode() : 0;
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + startYear;
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        result = 31 * result + routeNumber;
        result = 31 * result + (busMark != null ? busMark.hashCode() : 0);
        return result;
    }

}
