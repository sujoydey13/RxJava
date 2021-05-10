import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(123,321,890,4569);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error is"+throwable.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };
        observable.subscribe(observer);
    }
}
