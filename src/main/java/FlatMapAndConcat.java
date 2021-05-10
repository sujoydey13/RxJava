import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FlatMapAndConcat {
    public static void main(String[] args) {
//        exFlatMap();
//        exFlatMapBiFunction();
        exConcat();
    }

    private static void exFlatMap() {
        Observable<String> observable = Observable.just("good","better","best");
        observable.flatMap((string) -> {
            if(string.equals("best")) return Observable.empty();
            else return Observable.fromArray(string.split(""));
        } )
                .subscribe(System.out::println);
    }
    private static void exFlatMapBiFunction() {
        Observable<String> observable = Observable.just("good","better","best");
        observable.flatMap((string) -> Observable.fromArray(string.split("")),
                (actual,second) -> actual + " " + second)
                .subscribe(System.out::println);
    }

    private static void exConcat() {
        Observable<Long> observable1 = Observable.interval(1,1,TimeUnit.SECONDS).take(5);
        Observable<Long> observable2 = Observable.interval(300,TimeUnit.MILLISECONDS);
        Observable.concat(observable1,observable2).subscribe(System.out::println);

        pause(10000);
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
