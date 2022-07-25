package quotes;

import java.io.IOException;

public class Main {
    static Graphics view;
    static Quote currentQuote;
    public static void main(String[] args) {
        view = new Graphics();
    }

    static void getQuote() {
        Language chosen_language = view.languages.getSelectedValue();
        if (chosen_language.shortcut.matches("\\D\\D")) {
            try {
                currentQuote = new Quote(chosen_language);
                view.displayText(currentQuote.content, "quote");
                if (view.seeAuthor.isSelected()) {
                    view.displayText(currentQuote.author, "author");
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