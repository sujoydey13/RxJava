import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class TakeSkip {
    public static void main(String[] args) {
        takeOperator();
        takeWithInterval();
        takeWhile();
        skipOperator();
        skipWhile();
        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedOperator();
        distinctUntilChangedOperatorWithKeySelector();
    }

    private static void distinctUntilChangedOperatorWithKeySelector() {
        Observable.just("foo","red","fool","good","bad","hat","better","best","blue","bye")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }

    private static void distinctUntilChangedOperator() {
        Observable.just(1,1,2,2,2,3,3,2,1,5)
                .distinctUntilChanged()
                .subscribe(System.out::println);

    }

    private static void distinctWithKeySelector() {
        Observable.just("foo","fool","good","bad","better")
                .distinct(item -> item.length())
                .subscribe(System.out::println);
    }

    private static void distinctOperator() {
        Observable.just(1,1,2,2,2,3,3,3,4,5)
                .distinct()
                .subscribe(System.out::println);
    }

    private static void skipWhile() {
        Observable.just(1,2,3,4,1,2,7,8)
                .skipWhile(item -> item<=3)
                .subscribe(System.out::println);
    }

    private static void skipOperator() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .skip(2)
                .subscribe(System.out::println);
    }

    private static void takeWhile() {
        Observable.just(1,2,3,4,1,2,7,8)
                .takeWhile(item -> item<=3)
                .subscribe(System.out::println);
    }

    private static void takeWithInterval() {
        Observable.interval(300,TimeUnit.MILLISECONDS)
                .take(2,TimeUnit.SECONDS)
                .subscribe(System.out::println,System.out::println,() -> System.out.println("Completed"));
        pause(5000);
    }

    private static void takeOperator() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .take(2)
                .subscribe(System.out::println);
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
