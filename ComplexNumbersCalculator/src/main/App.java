package main;

import view.ComplexCalculatorUI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The main application class that starts the Complex Numbers Calculator.
 */
public class App {
    /**
     * The logger used for logging messages in the application.
     */
    public static final Logger logger = Logger.getLogger(App.class.getName());

    /**
     * The main method that starts the application by initializing the logger and creating an instance of view.ComplexCalculatorUI.
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        FileHandler fh;
        String logFileName = "MyLogFile.log";
        try {
            fh = new FileHandler(logFileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException | SecurityException e) {
            throw new RuntimeException(e);
        }

        logger.info("ComplexNumbersCalculator started.");
        new ComplexCalculatorUI(); // start application
    }
}