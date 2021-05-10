import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] args) {
        Observable observable = Observable.interval(1,TimeUnit.SECONDS);

        observable.subscribe(item -> System.out.println("Observer 1: "+item));
        pause(2000);

        observable.subscribe(item -> System.out.println("Observer 2: "+item));
        pause(5000);
    }
    public static void pause(int duration){
        try{
            Thread.sleep(duration);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
