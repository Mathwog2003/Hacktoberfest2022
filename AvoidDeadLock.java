    public class AvoidDeadlock
    {  
    public static void main(String[] args) throws InterruptedException   
    {  
    //creating object of the Object class  
    Object object1 = new Object();  
    Object object2 = new Object();  
    Object object3 = new Object();  
    //creating constructor of the Thread class and passing SynchroniseThread object as a parameter  
    Thread thread1 = new Thread(new SynchroniseThread(object1, object2), "thread1");  
    Thread thread2 = new Thread(new SynchroniseThread(object2, object3), "thread2");  
    //executing thread1  
    thread1.start();  
    //the sleep() method suspends the execution of the current thread (thread1) for the specific period  
    Thread.sleep(2000);  
    //executing thread2  
    thread2.start();  
    //suspends the execution of the current thread (thread2) for the specific period  
    Thread.sleep(2000);  
    }  
    }  
    class SynchroniseThread implements Runnable   
    {  
    private Object object1;  
    private Object object2;  
    public SynchroniseThread(Object o1, Object o2)  
    {  
    this.object1=o1;  
    this.object2=o2;  
    }  
    //overriding run() method of the Thread class  
    @Override  
    //it allows two threads are running concurrently  
    public void run()   
    {  
    //getteing the current thread name  
    String name = Thread.currentThread().getName();    
    System.out.println(name + " acquire lock on " + object1);  
    //Synchronized() method is used to lock an object for any shared resource. When a thread invokes the synchronized() method,   
    //it automatically acquires the lock for that object and releases it when the thread completes its task.  
    synchronized (object1)   
    {  
    System.out.println(name + " acquired lock on " + object1);  
    //calling work() method  
    work();  
    }  
    System.out.println(name + " released lock of " + object1);  
    System.out.println(name + " acquire lock on " + object2);  
    synchronized (object2)   
    {  
    System.out.println(name + " acquire lock on " + object2);  
    work();  
    }  
    System.out.println(name + " released lock of " + object2);  
    System.out.println(name + " execution is completed.");  
    }  
    private void work()   
    {  
    try   
    {  
    //the sleep() method suspends the execution of the current thread for 5 seconds  
    Thread.sleep(5000);  
    }   
    catch (InterruptedException e)   
    {  
    e.printStackTrace();  
    }  
    }  
    }  

