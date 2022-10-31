public class ConseoleLogger extends AbstractLogger {
    public ConseoleLogger (int level)
    {
        this.level = level ;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console Logger ✅ Normal:: Logger "+message);
    }
}
