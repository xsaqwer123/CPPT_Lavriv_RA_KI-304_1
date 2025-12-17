package lab6;

/**
 * Клас, що представляє слово з його частотою використання.
 * Реалізує інтерфейс Comparable для порівняння слів за частотою.
 * @version 1.0
 */
class Word implements Comparable<Word> {
    private String value;
    private int frequency;

    /**
     * Конструктор класу Word.
     * @param value слово
     * @param frequency частота використання
     */
    public Word(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    /**
     * Повертає значення слова.
     * @return слово
     */
    public String getValue() {
        return value;
    }

    /**
     * Повертає частоту використання.
     * @return частота використання
     */
    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Word{value='" + value + "', frequency=" + frequency + "}";
    }

    @Override
    public int compareTo(Word other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}

