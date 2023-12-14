package hello.core.lifeCycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
        connet();
        call("시작 ");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connet() {
        System.out.println("cont url = " + url);
    }

    public void call(String msg) {
        System.out.println("url : "+url + "msg = " + msg);
    }

    public void disconnect() {
        System.out.println("close : " + url);
    }


    @PostConstruct
    public void init()  {
        connet();
        call("시작한다잉");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
