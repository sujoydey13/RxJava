import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class Dispose {
    public static void main(String[] args) {
        handleDisposable();
        handleDisposableInObserver();
        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    private static void compositeDisposable() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1,TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1: "+item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2: "+item));
        compositeDisposable.addAll(disposable1,disposable2);
        pause(3000);
        compositeDisposable.dispose();
        pause(3000);
    }

    private static void handleDisposableOutsideObserver() {

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>() {

            Disposable d;

            @Override
            public void onNext(Integer integer) {
                if(integer == 4){
                    d.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribeWith(observer);

    }

    private static void handleDisposableInObserver() {

        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        Observer<Integer> observer = new Observer<Integer>() {

            Disposable d;

            @Override
            public void onSubscribe(Disposable disposable) {
                d = disposable;
            }

            @Override
            public void onNext(Integer integer) {
                if(integer == 4){
                    d.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);

    }

    private static void handleDisposable() {
        Observable<Long> observable = Observable.interval(1,TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        pause(3000);
        disposable.dispose();
        pause(2000);
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
