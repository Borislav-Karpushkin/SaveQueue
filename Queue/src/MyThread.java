/**
 * Created by borislav on 05.08.16.

public class MyThread implements Runnable {

    public MyThread(SQueue q) {
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            q.add(i);
        }
    }

}*/
