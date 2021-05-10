import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ErrorHandling {
    public static void main(String[] args) {
        exDoOnError();
        exOnErrorResumeNext();
        exOnErrorReturn();
        exOnReturnItem();
        exRetryWithPredicate();
        exRetry();
        exRetryUntil();
    }

    private static void exRetryUntil() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.error(new Exception("This is error handling"))
                .doOnError(error -> {
                    System.out.println(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> {
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exRetry() {
        Observable.error(new Exception("This is error handling"))
                .retry(3)
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exRetryWithPredicate() {
        Observable.error(new IOException("This is error handling"))
                .retry(error -> {
                    if(error instanceof IOException){
                        System.out.println("retrying");
                        return true;
                    }
                    else{
                        return false;
                    }
                })
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exOnReturnItem() {
        Observable.error(new Exception("This is error handling"))
                .onErrorReturnItem("Hello World")
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exDoOnError() {
        Observable.error(new Exception("This is error handling"))
                .doOnError(error -> System.out.println("Hello "+error.getMessage()))
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exOnErrorResumeNext() {
        Observable.error(new Exception("This is error handling"))
                .onExceptionResumeNext(Observable.just(1,2,3,4,5))
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

    private static void exOnErrorReturn() {
        Observable.error(new Exception("This is an IOException"))
                .onErrorReturn(error -> {
                    if(error instanceof IOException) return 0;
                    else return 1;
                })
                .subscribe(System.out::println,error -> System.out.println("Error Occurred: "+error.getMessage()),() -> System.out.println("Completed"));
    }

}
