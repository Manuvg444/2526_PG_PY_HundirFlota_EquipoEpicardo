package util;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Utility class to beautify console output.
 * Provides ANSI codes for colors and Emoji support.
 */
public class ConsoleHelper {

    // --- FOREGROUND COLORS ---
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // --- BACKGROUND COLORS ---
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    /**
     * Enables UTF-8 support in the console to display Emojis correctly
     * and clears the screen.
     */
    public static void init() {
        // Force UTF-8 on standard output
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        clearScreen();
        
        System.out.println(CYAN + "🎮 Console initialized with Emoji support." + RESET);
    }

    /**
     * Returns text formatted with colors.
     */
    public static String colorize(String text, String color) {
        return color + text + RESET;
    }

    /**
     * Creates a board cell effect with background and symbol.
     */
    public static String cell(String symbol, String backgroundColor) {
        return backgroundColor + " " + symbol + " " + RESET;
    }

    // --- PRINTING METHODS (SHORTHAND) ---

    /**
     * Writes an object to the console without a newline.
     */
    public static void write(Object msg) {
        System.out.print(msg);
    }

    /**
     * Writes an object to the console with a newline.
     */
    public static void writeLn(Object msg) {
        System.out.println(msg);
    }

    /**
     * Writes colored text and resets formatting without a newline.
     */
    public static void writeColor(Object msg, String color) {
        System.out.print(colorize(msg.toString(), color));
    }

    /**
     * Writes colored text and resets formatting with a newline.
     */
    public static void writeColorLn(Object msg, String color) {
        System.out.println(colorize(msg.toString(), color));
    }

    /**
     * Clears the console screen.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
