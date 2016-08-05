/**
 * Created by borislav on 04.08.16.
 */
public class Tests {
    static SQueue q;
    public static void main(String[] args) {
        q = new SQueue();
        int ThreadCount = 8;
        Thread[] myThreads = new Thread[ThreadCount];
        int i;
        for (i = 0; i < ThreadCount; i++)
            myThreads[i] = new Thread(q);
        for (i = 0; i < ThreadCount; i++)
            myThreads[i].start();
        for (i = 0; i < ThreadCount*3+3; i++)
            System.out.println(q.get());
        System.out.println("Tests done.");
    }
}
