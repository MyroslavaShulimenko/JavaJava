package org.example.task0109;

public class SimpleExchanger<T> {
    private T message;
    private boolean isFirstCame;
    private boolean isSecondCame;

    public T exchange(T msg) {
        synchronized (this) {
            if (!isFirstCame ) {
                message = msg;
                isFirstCame=true;
                try {
                    while (!isSecondCame){
                        wait();
                    }
                    isSecondCame=false;
                    isFirstCame=false;
                    T msgTmp=message;
                    message=null;
                    return msgTmp;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                T tmp = message;
                message = msg;
                isSecondCame=true;
                notifyAll();
                return tmp;
            }
        }
        //      throw new RuntimeException("Not implemented");
    }
}
