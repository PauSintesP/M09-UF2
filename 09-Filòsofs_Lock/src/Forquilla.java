import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int id;
    private final Lock bloqueig;

    public Forquilla(int id) {
        this.id = id;
        this.bloqueig = new ReentrantLock();
    }

    public int getId() {
        return id;
    }

    public boolean agafar() {
        return bloqueig.tryLock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}