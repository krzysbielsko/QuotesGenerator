package quotes;

public enum Language {

    ENGLISH("English", "en"), SPANISH("Espanol", "es"), PORTUGAL("Portugues", "pt"),
    GERMAN("Deutsch", "de"), FRENCH("Fran�ais", "fr"), ITALIAN("Italiano", "it"),
    SLOVAK("Slovensk�", "sk"), POLISH("Polski", "pl");

    Language(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    String name, shortcut;

}
