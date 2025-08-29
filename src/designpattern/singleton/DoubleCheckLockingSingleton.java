package designpattern.singleton;

public class DoubleCheckLockingSingleton {
    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton(){}

    private static DoubleCheckLockingSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckLockingSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}
