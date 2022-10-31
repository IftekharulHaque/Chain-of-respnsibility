public abstract class AbstractLogger {
    public  static  int Console = 1 ;
    public static  int Warning = 2 ;
    public static int Error = 3 ;

    protected int level ;

    protected AbstractLogger nextLogger ;

    public void setNextLogger(AbstractLogger nextLogger)
    {
        this.nextLogger = nextLogger ;
    }
    public void logMessage(int level,String message){
        if(this.level <= level) write(message) ;
        if(nextLogger != null)
            nextLogger.logMessage(level,message);
    }
    abstract protected  void write(String message);
}
