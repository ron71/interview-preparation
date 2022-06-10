class Logger{

    static Logger logger = null;
    private Logger(){}
    private Logger(Logger logger){}

    public static Logger getInstance(){
        
        if(logger==null){
            // this will endure that the lock is applied once once. i.e. at the beginning when logger is null.
            synchronized(Logger.class){
                if(logger==null){
                    return new Logger();
                }else{
                    return logger;
                }
            }
        }else{
                return logger; //Since its a statless object therefore lock would not be needed afterwards.
        }
        
    }

    public void info(String msg){
        System.out.println(msg);
    }

}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        Logger logger  = Logger.getInstance();
        logger.info("this is printing a log");
    }
}
