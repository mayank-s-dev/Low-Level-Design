package ChainOfResponsibilityPattern;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == ERROR){
            System.out.println("ERROR:" + message);
        }else {
            System.out.println("error nhi hai");
            super.log(logLevel, message);
        }
    }
}
