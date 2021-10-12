package Bai12;

import java.util.Scanner;

public class Route implements Task{
    public static int iDAuto=100;
    public int iD;
    public double distance;
    public int stops;

    public Route(int iD, double distance, int stops) {
        this.iD = iD;
        this.distance = distance;
        this.stops = stops;
    }
    public Route(){
        this.iD=iDAuto++;
    }

    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Route.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Route{" +
                "iD=" + iD +
                ", distance='" + distance + '\'' +
                ", stops=" + stops +
                '}';
    }
    @Override
    public void input() {
        this.setiD(iD);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập khoảng cách(Km):");
        this.setDistance(scanner.nextDouble());
        System.out.println("Nhập số điêm dừng");
        this.setStops(scanner.nextInt());
    }
}
