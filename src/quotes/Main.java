package quotes;

import java.io.IOException;

public class Main {
    static Graphics view;
    static Quote currentQuote;
    public static void main(String[] args) {
        view = new Graphics();
    }

    static void getQuote() {
        //TODO Wprowadzi� mo�liwo�� dowolnego ustawiania j�zyka
        String language = "pl";
        if (language.matches("\\D\\D")) {
            try {
                Quote formattedQuote = new Quote(language);
                currentQuote = formattedQuote;
                view.displayText(formattedQuote.content, "quote");
                if (view.seeAuthor.isSelected()) {
                    view.displayText(formattedQuote.author, "author");
                }
            } catch (IOException | InterruptedException e) {
                view.displayText(String.format("Wyst�pi� problem: %s", e.getCause()), "quote");
                view.displayText("", "author");
            }
        } else {
            view.displayText("Nieprawid�owy j�zyk.", "quote");
        }
    }
}