import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Merge {
    public static void main(String[] args) {
        exMerge();
        exMergeArray();
        exMergeIterable();
        exMergeWith();
        exMergeInfinite();
        exZip();
        exZipWith();
        exZipIterable();
    }

    private static void exZipIterable() {
    }

    private static void exZipWith() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        observable1.zipWith(observable2,Integer::sum).subscribe(System.out::println);
    }

    private static void exZip() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        Observable<Integer> observable3 = Observable.just(11,12,13,14,15);

        Observable.zip(observable1,observable2,observable3,(a,b,c) -> a+b+c)
                .subscribe(System.out::println);
    }

    private static void exMerge() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        Observable.merge(observable1,observable2).subscribe(System.out::println);
    }

    private static void exMergeArray() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        Observable<Integer> observable3 = Observable.just(11,12,13,14,15);
        Observable<Integer> observable4 = Observable.just(16,17,18,19,20);
        Observable.mergeArray(observable1,observable2,observable3,observable4).subscribe(System.out::println);
    }

    private static void exMergeIterable() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        Observable<Integer> observable3 = Observable.just(11,12,13,14,15);
        Observable<Integer> observable4 = Observable.just(16,17,18,19,20);
        List<Observable<Integer>> observableList = Arrays.asList(observable1,observable2,observable3,observable4);
        Observable.merge(observableList).subscribe(System.out::println);
    }

    private static void exMergeWith() {
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        observable1.mergeWith(observable2).subscribe(System.out::println);
    }

    private static void exMergeInfinite() {
        Observable<String> infinite1 = Observable.interval(1,TimeUnit.SECONDS).map(item -> "Infinite1: "+item);
        Observable<String> infinite2 = Observable.interval(2,TimeUnit.SECONDS).map(item -> "Infinite2: "+item);
        infinite1.mergeWith(infinite2).subscribe(System.out::println);
        pause(6000);
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
