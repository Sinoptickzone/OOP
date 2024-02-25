package Main;

import Classes.*;
import Interfaces.iActorBehaviour;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The App class represents the main application entry point.
 */
public class App {
    /**
     * The logger instance for logging information.
     */
    public static final Logger logger = Logger.getLogger(App.class.getName());

    /**
     * The main method of the application.
     *
     * @param args The command-line arguments.
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

        Market magnit = new Market();

        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new OrdinaryClient("masha");
        iActorBehaviour client3 = new SpecialClient("prezident", 1);
        iActorBehaviour client4 = new TaxInspector();
        iActorBehaviour client5;
        iActorBehaviour client6;

        if (ActionalClient.numberOfParticipants > 0) {
            client5 = new ActionalClient("misha", 5);
            App.logger.info("misha участвует в акции");
            ActionalClient.numberOfParticipants--;
        } else {
            App.logger.info("Достигнут лимит количества участников акции.");
            client5 = new OrdinaryClient("misha");
        }

        if (ActionalClient.numberOfParticipants > 0) {
            client6 = new ActionalClient("igor", 6);
            App.logger.info("igor участвует в акции");
            ActionalClient.numberOfParticipants--;
        } else {
            App.logger.info("Достигнут лимит количества участников акции.");
            client6 = new OrdinaryClient("igor");
        }

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);
        magnit.acceptToMarket(client6);

        magnit.update();
    }
}
