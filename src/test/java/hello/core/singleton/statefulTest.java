package hello.core.singleton;

public class statefulTest {

    private int price; //상태 유지

    //문제되는 함수
//    public void order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;
//    }
    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;
        return price;
    }


//    public int getPrice() {
//        return price;
//    }
}
