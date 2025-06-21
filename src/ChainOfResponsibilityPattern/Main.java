package ChainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args){
        LogProcessor logger = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));
        logger.log(10, "Info message");
    }
}
