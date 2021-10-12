package Bai12;

import java.util.List;
import java.util.Map;

public class Assignment {
    public Driver driver;
    public List<Route> routeList;
    public List<Integer> quantity;

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public Assignment(Driver driver, List<Route> routeList, List<Integer> quantity) {
        this.driver = driver;
        this.routeList = routeList;
        this.quantity = quantity;
    }


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "driver=" + driver +
                ", driverlist=" + routeList +
                ", quantity=" + quantity +
                '}';
    }
}
