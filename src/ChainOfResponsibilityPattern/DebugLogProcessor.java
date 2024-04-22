package ChainOfResponsibilityPattern;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == DEBUG){
            System.out.println("DEBUG:" + message);
        }else {
            System.out.println("debug nhi hai");
            super.log(logLevel, message);
        }
    }
}
