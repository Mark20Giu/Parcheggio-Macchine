
import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int posti;
    private Semaphore s;
    
    public int getPosti() {
        return posti;
    }
    
    public Parcheggio(int posti) {this.posti= posti; s = new Semaphore(posti);}
    public synchronized void entra() {
    while (posti==0) 
    {
        try {
            s.acquire();
        }catch (InterruptedException e) {e.printStackTrace();}
    }
        posti--;
    }
    public synchronized void esce() 
    {
        posti++;
        s.release();
    } 
}
