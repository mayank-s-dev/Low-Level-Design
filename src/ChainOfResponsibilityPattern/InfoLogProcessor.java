package ChainOfResponsibilityPattern;

public class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == INFO){
            System.out.println("INFO:" + message);
        }else {
            System.out.println("info nhi hai");
            super.log(logLevel, message);
        }
    }
}
