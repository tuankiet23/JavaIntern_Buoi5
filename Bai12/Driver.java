package Bai12;

import java.util.Scanner;

public class Driver extends Person implements Task {
    public String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Driver(String level) {
        this.level = level;
    }

    public Driver(int iD, String name, String adress, String phone, String level) {
        super(iD, name, adress, phone);
        this.level = level;
    }
    public Driver(){}

    @Override
    public String toString() {
        return "Driver{" +
                " iD=" + iD +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ",level='" + level + '\'' +
                '}';
    }
    @Override
    public void input(){
        try {
            super.input();
            Scanner sc=new Scanner(System.in);
            String[] arr = {"A", "B", "C", "D", "E", "F"};
            boolean check = true;
            do {
                check = true;
                int a = 0;
                System.out.println("Trình độ lái xe:");
                System.out.println("1.A----2.B----3.C----4.D----5.E----6.F");
                a = sc.nextInt();
                switch (a) {
                    case 1:
                        this.setLevel(arr[0]);
                        break;
                    case 2:
                        this.setLevel(arr[1]);
                        break;
                    case 3:
                        this.setLevel(arr[2]);
                        break;
                    case 4:
                        this.setLevel(arr[3]);
                        break;
                    case 5:
                        this.setLevel(arr[4]);
                        break;
                    case 6:
                        this.setLevel(arr[5]);
                        break;
                    default:
                        System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                        check = false;
                        break;
                }
            }
            while (!check) ;
        }catch (Exception e){
            System.out.println(e);
        }


    }


}
