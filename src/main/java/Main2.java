import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observables.ConnectableObservable;

import static java.lang.Thread.sleep;

public class Main2 {
    public static void main(String[] args) {
//        createColdObservable();
        createHotAndConnectableObservable();
    }

    private static void createHotAndConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8,9).publish();
        observable.subscribe(item -> System.out.println("1: "+item));
        pause(3000);
        observable.subscribe(item -> System.out.println("2: "+item));
        observable.connect();

    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);

        observable.subscribe(item -> System.out.println("1: "+item));

        pause(3000);

        observable.subscribe(item -> System.out.println("2: "+item));

    }

    private static void pause(int duration){
        try{
            sleep(duration);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
