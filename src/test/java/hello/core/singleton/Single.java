package hello.core.singleton;

public class Single {
    //클래스 레벨이라 하나만 존재 자바 시작 시, 바로 생성
    private static final Single instance = new Single();

    public static Single getInstance() {
        return instance;
    }

    //priate로 생성자
    //1개의 인스턴스만 존재해야함 > new 키워드로 새로운 인스턴스 생성 x
    private Single() {
    }
}
