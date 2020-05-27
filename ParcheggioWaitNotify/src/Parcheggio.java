public class Parcheggio {
    private int posti;

    public int getPosti() {
        return posti;
    }
    
    public Parcheggio(int posti) {this.posti= posti;}
    public synchronized void entra() {
    while (posti==0) 
    {
        try {
            wait();
        }catch (InterruptedException e) {e.printStackTrace();}
    }
        posti--;
    }
    public synchronized void esce() 
    {
        posti++;
        notifyAll();
    } 
}
