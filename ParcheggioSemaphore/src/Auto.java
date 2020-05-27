public class Auto extends Thread{
    private Parcheggio park;
    public Auto(String nome, Parcheggio p) 
    {
        super(nome);
        this.park = p;
        start();
    }   
    public void run() 
    {
        while (true) 
        {   
            try { 
                sleep((int)(Math.random() * 5000));
            } catch (InterruptedException e) {e.printStackTrace();} 
            synchronized(park)
            {
                park.entra();
                System.out.println(getName()+": è entrata nel parcheggio\n"
                        + "posti liberi:"+park.getPosti());
            }
            try { 
                sleep((int)(Math.random() * 10000)); 
            } catch (InterruptedException e) {e.printStackTrace();} 
            synchronized(park)
            {
                park.esce();
                System.out.println(getName()+": è uscita dal parcheggio\n"
                        + "posti liberi:"+park.getPosti());
            } 
        } 
    } 
}
