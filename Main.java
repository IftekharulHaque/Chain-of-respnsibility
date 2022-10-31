import java.util.Scanner;

public class Main {
    private static AbstractLogger getLogger(){
        AbstractLogger conseoleLogger =
                new ConseoleLogger(AbstractLogger.Console);
        AbstractLogger warningLogger =
                new WarningLogger(AbstractLogger.Warning) ;
        AbstractLogger errorLogger =
                new ErrorLogger(AbstractLogger.Error);

        errorLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(conseoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("Enter a input :\n1:(normal)\n" +
                "2:(warning)\n" +
                "3:(Error)\n" +
                "4:(Show all)\n"
        );
       int a = input.nextInt() ;
        AbstractLogger loggerChain = getLogger();


        switch (a){
            case 1 : loggerChain.logMessage(AbstractLogger.Console,"This is normal Logger ✅"); break ;
            case 2 : loggerChain.logMessage(AbstractLogger.Warning,"This is Warning message ⚠"); break ;
            case 3 : loggerChain.logMessage(AbstractLogger.Error,"This is an Error Message ❌"); break ;
            case 4 : {
                loggerChain.logMessage(AbstractLogger.Console,"This is normal Logger ✅");
                loggerChain.logMessage(AbstractLogger.Warning,"This is Warning message ⚠");
                loggerChain.logMessage(AbstractLogger.Error,"This is an Error Message ❌");
                break ;
            }
            default:
                System.out.println("Invalid : type 1/2/3/4");
        }

    }
}
