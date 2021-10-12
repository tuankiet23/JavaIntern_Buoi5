package Bai12;

import java.util.*;

public class Manager implements Task{
    public static List<Driver> drivers=new ArrayList<>();
    public static List<Route> routes=new ArrayList<>();
    public static List<Assignment> assignments=new ArrayList<>();
    public void run(){
        try {
            while (true) {
                System.out.println("Danh sach chuc nang:");
                System.out.println("1.Nhập danh sách lái xe");
                System.out.println("2.In ra danh sach lái xe:");
                System.out.println("3.Nhập danh sách tuyến");
                System.out.println("4.In ra danh sách tuyến");
                System.out.println("5.Nhap lich phân công");
                System.out.println("6.In danh sách lịch phân công");
                System.out.println("7.Sx theo ten ");
                System.out.println("8.Sx theo so lượt chạy");
                System.out.println("9.Tổng số quãng đường mà tài xế đi trong một ngày.");
                boolean flag = true;
                do {
                    flag = true;
                    int chosse = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Chon chuc nang");
                    chosse = scanner.nextInt();
                    switch (chosse) {
                        case 1:
                            CreaterDriver();
                            break;
                        case 2:
                            DisplayDriver();
                            break;
                        case 3:
                            CreateRoute();
                            break;
                        case 4:
                            DisplayRoute();
                            break;
                        case 5:
                            input();
                            break;
                        case 6:
                            DisplayAssignment();
                            break;
                        case 7:
                            SortByName();
                            break;
                        case 8:
                            SortByTotalStops();
                            break;
                        case 9:
                            TotalDistance();
                            break;
                        default:
                            System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                            flag = false;
                            break;
                    }
                }
                while (!flag);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void CreaterDriver(){
        Driver driver=new Driver();
        driver.input();
        drivers.add(driver);
    }
    public static void CreateRoute(){
        Route route=new Route();
        route.input();
        routes.add(route);
    }
    public static void DisplayDriver(){
        drivers.forEach(e -> System.out.println(e));
    }
    public static void DisplayRoute(){
        routes.forEach(e -> System.out.println(e));
    }
    @Override
    public void input() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhap id lái xe:");
            boolean flag=false;
            int a;
            Driver  driver;
            do {
                a = sc.nextInt();
                driver=SearchDreiver(a);
                if (driver==null) {
                    System.out.println("nhap lại id:");
                    flag = true;
                }
                else flag=false;
            }while (flag);
            Assignment assignmentcheck=null;
            int e=0;
            for(Assignment assignment:assignments){
                e=e+1;
                if(assignment.driver.getiD()==a){
                    flag=true;
                    assignmentcheck=assignment;
                    break;
                }
            }


            Route  route;
            int b=0;
            boolean check=false;
            System.out.println("nhap id :");
            do {
                b = sc.nextInt();
                route=SearchRoute(b);
                if (route==null) {
                    System.out.println("nhap lại id:");
                    check = true;
                }
                else check=false;
            }while (check);
            if(flag==true){
                int sl=0;
                boolean c=true;
                for(Route route1: assignmentcheck.getRouteList()){
                    if(route.getiD()==route1.getiD()){
                        System.out.println("Không the thêm tuyến đường này.");
                        c=false;
                        break;
                    }
                }
                sl=TotalStops(assignmentcheck);
                if(c==true){
                    System.out.println("Nhập số lượt chạy");
                    boolean k=false;
                    int soluot;
                    do {
                        soluot = sc.nextInt();
                        if ((sl+soluot)>15) {
                            System.out.println("nhap lại so lượt:");
                            k = true;
                        }
                        else k=false;
                    }while (k);

                    assignmentcheck.quantity.add(soluot);
                    assignmentcheck.routeList.add(route);
                    assignments.remove(e-1);
                    assignments.add(assignmentcheck);
                }
                else System.out.println("số lượt chạy quá hạn mức.");
            }
            else {
                System.out.println("Nhập số lượt chạy");
                List<Integer> quantity=new ArrayList<>();
                List<Route> routes=new ArrayList<>();
                routes.add(route);
                boolean k=false;
                int soluot;
                do {
                    soluot = sc.nextInt();
                    if (soluot>15 ||soluot<0) {
                        System.out.println("nhap lại so lượt:");
                        k = true;
                    }
                    else k=false;
                }while (k);
                quantity.add(soluot);
                Assignment assignment = new Assignment(driver,routes,quantity);
                assignments.add(assignment);
            }

        }catch (Exception e){
            System.out.println("lỗi:"+e);
        }

    }
    public static void DisplayAssignment(){
        assignments.forEach(e -> System.out.println(e));
    }
    public Driver SearchDreiver(int id){
        for(Driver driver: drivers){
            if(id==driver.getiD())
                return driver;
        }
        return null;
    }

    public Route SearchRoute(int id){
        for(Route route: routes){
            if(id==route.getiD())
                return route;
        }
        return null;
    }
    public void TotalDistance(){
        for(Assignment assignment: assignments){
            double total=0;
            for(int i=0; i<assignment.routeList.size(); i++){
                total= total+assignment.getQuantity().get(i)*assignment.getRouteList().get(i).getDistance();
            }
            System.out.println(assignment.driver.getiD()+"  "+assignment.driver.getName()+" quãng đường đi: "+ total+"km");
        }
    }

    public int TotalStops(Assignment assignment){
        int sl=0;
        for(int i:assignment.getQuantity()){
            sl=sl+i;
        }
        return sl;
    }
    public void SortByTotalStops(){
        Collections.sort(assignments, new Comparator<Assignment>() {
            @Override
            public int compare(Assignment o1, Assignment o2) {
                return TotalStops(o1)- TotalStops(o2);
            }
        });
    }
    public void SortByName(){
        Collections.sort(assignments, new Comparator<Assignment>() {
            @Override
            public int compare(Assignment o1, Assignment o2) {
                return o1.driver.getName().compareTo(o2.driver.getName());
            }
        });

    }
}
