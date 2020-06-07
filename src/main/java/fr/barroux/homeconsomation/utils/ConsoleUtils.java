package fr.barroux.homeconsomation.utils;

public class ConsoleUtils {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static String textWarning(String textToSend)
    {
        return ANSI_RED + textToSend + ANSI_RESET;
    }

    public static String textInfo(String textToSend)
    {
        return ANSI_YELLOW + textToSend + ANSI_RESET;
    }

    public static String textSuccess(String textToSend)
    {
        return ANSI_GREEN + textToSend + ANSI_RESET;
    }


}