/**
 * Created by borislav on 03.08.16.
 */
import java.util.concurrent.*;
import java.lang.Runnable;

class QueueElement{
    QueueElement next;
    int data;
}

public class SQueue implements Runnable{

    private QueueElement head;
    private QueueElement tail;

    private static final Semaphore semaphoreQueue = new Semaphore(1);

    public void run()
    {
        this.add(1);
        this.add(2);
        this.add(3);
    }

    public void add(int data)
    {
        try {
            semaphoreQueue.acquire();
            addElement(data);
            semaphoreQueue.release();
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int get()
    {
        int data = 0;
        try {
            semaphoreQueue.acquire();
            data = getElement();
            semaphoreQueue.release();
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void addElement(int data)
    {
        QueueElement a = new QueueElement();
        a.data = data;
        if (head == null)
        {
            head = a;
            tail = a;
        }
        else
        {
            tail.next = a;
            tail = a;
        }
    }

    private int getElement()
    {
        if (head == null)
            return 0;
        int data;
        if (head == tail)
        {
            data = head.data;
            head = null;
            tail = null;
            return data;
        }
        data = head.data;
        head = head.next;
        return data;
    }
}
