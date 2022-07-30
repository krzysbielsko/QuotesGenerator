package quotes;

import javax.swing.*;
import java.awt.*;

public class Graphics {
    JFrame frame;
    JPanel centerPanel, lowerPanel, upperPanel, authorPanel;
    JLabel quote, author, appTitle, credits, selectLanguage;
    JButton button;
    JCheckBox seeAuthor;
    JList<Language> languages;
    JScrollPane scrollPane;

    Graphics() {
        frame = new JFrame();
        frame.setSize(500, 400);
        frame.setTitle("Generator cytat�w");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout(1, 2));
        frame.add(upperPanel, BorderLayout.NORTH);
        upperPanel.setVisible(true);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 10));
        frame.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setVisible(true);

        authorPanel = new JPanel();
        authorPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(authorPanel, BorderLayout.NORTH);
        credits = new JLabel();
        credits.setText("� KK 2022");
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
        authorPanel.add(credits);
        credits.setVisible(true);

        selectLanguage = new JLabel();
        selectLanguage.setText("Wybierz j�zyk");
        selectLanguage.setHorizontalAlignment(JLabel.CENTER);
        selectLanguage.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        authorPanel.add(selectLanguage);
        selectLanguage.setVisible(true);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(lowerPanel, BorderLayout.SOUTH);
        lowerPanel.setVisible(true);

        appTitle = new JLabel();
        appTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        appTitle.setText("Generator Cytat�w");
        appTitle.setHorizontalAlignment(JLabel.CENTER);
        upperPanel.add(appTitle);
        appTitle.setVisible(true);

        languages = new JList<>(Language.values());
        languages.setVisibleRowCount(3);
        languages.setSelectedIndex(1);
        languages.setVisible(true);

        scrollPane = new JScrollPane(languages);
        upperPanel.add(scrollPane);
        scrollPane.setVisible(true);

        quote = new JLabel("<html><body style='text-align: center'>Tw�j cytat pojawi si� tutaj.", SwingConstants.CENTER);
        quote.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        centerPanel.add(quote, BorderLayout.CENTER);
        quote.setVisible(true);

        seeAuthor = new JCheckBox();
        seeAuthor.setText("Wy�wietl autora");
        seeAuthor.setSelected(true);
        seeAuthor.setSize(100, 50);
        seeAuthor.addActionListener(a -> {
            if (this.author.getText().equals("<html></html>") && Main.currentQuote != null) {
                this.displayText(Main.currentQuote.author, "author");
            } else {
                this.displayText("", "author");
            }
        });
        lowerPanel.add(seeAuthor);
        seeAuthor.setVisible(true);

        author = new JLabel();
        author.setText("");
        author.setHorizontalAlignment(JLabel.CENTER);
        author.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        lowerPanel.add(author);
        author.setVisible(true);

        button = new JButton();
        button.setSize(150, 20);
        button.setText("Generuj cytat");
        button.addActionListener(a -> {
            String previousQuote = quote.getText();
            do {
                Main.getQuote();
            } while (previousQuote.equals(quote.getText()) || quote.getText().length() > 336);
        });
        frame.add(button, BorderLayout.SOUTH);
        button.setVisible(true);

        frame.setVisible(true);
    }

    void displayText(String text, String fieldName) {
        switch (fieldName) {
            case "quote" -> this.quote.setText("<html><body style='text-align: center'>" + text + "</html>");
            case "author" -> this.author.setText("<html>" + text + "</html>");
            default -> this.quote.setText("B��dna nazwa pola wy�wietlania");
        }
    }
}
