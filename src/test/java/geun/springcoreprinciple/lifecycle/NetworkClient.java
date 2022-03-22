package geun.springcoreprinciple.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// @Bean을 사용하면 NetworkClient Bean이 더이상 스프링 코드에 의존적이지 않는다.
public class NetworkClient { //implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message: "+ message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("disconnect: " + url);
    }

//    @Override       //의존관계 주입이 끝나면
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

//    @Override       //빈이 소멸되기 직전
    public void close() throws Exception {
        disconnect();
    }
}
