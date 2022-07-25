package quotes;

public enum Language {

    ENGLISH("English", "en"), POLISH("Polski", "pl"), SPANISH("Espanol", "es"),
    PORTUGAL("Portugues", "pt"), GERMAN("Deutsch", "de"),
    FRENCH("Fran�ais", "fr"), ITALIAN("Italiano", "it"),
    SLOVAK("Slovensk�", "sk");

    Language(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    @Override
    public String toString() {
        return this.name;
    }

    String name, shortcut;

}
