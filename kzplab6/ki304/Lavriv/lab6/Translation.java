package lab6;

/**
 * Клас, що представляє переклад слова.
 * Реалізує інтерфейс Comparable для порівняння перекладів за популярністю.
 * @version 1.0
 */
class Translation implements Comparable<Translation> {
    private String language;
    private String translation;
    private int popularity;

    /**
     * Конструктор класу Translation.
     * @param language мова перекладу
     * @param translation переклад
     * @param popularity популярність перекладу
     */
    public Translation(String language, String translation, int popularity) {
        this.language = language;
        this.translation = translation;
        this.popularity = popularity;
    }

    /**
     * Повертає мову перекладу.
     * @return мова перекладу
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Повертає переклад.
     * @return переклад
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Повертає популярність перекладу.
     * @return популярність перекладу
     */
    public int getPopularity() {
        return popularity;
    }

    @Override
    public String toString() {
        return "Translation{language='" + language + "', translation='" +
                translation + "', popularity=" + popularity + "}";
    }

    @Override
    public int compareTo(Translation other) {
        return Integer.compare(this.popularity, other.popularity);
    }
}


