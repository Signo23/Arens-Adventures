package it.aren.io;

public class Logger {
    private Logger(){}

    public static void debug(String msg){
        System.out.println("DEBUG: [" + msg + "]");
    }

    public static void error(String msg){
        System.err.println("ERROR: [" + msg + "]");
    }
}
