package lab6;

/**
 * Клас-драйвер для демонстрації роботи класу Dictionary.
 * Даний клас містить метод main, який реалізує тестування
 * функціональності словника для слів та перекладів.
 * @version 1.0
 */
public class DictionaryDriver {
    public static void main(String[] args) {
        // Створюємо словник для слів
        Dictionary<String, Word> wordDictionary = new Dictionary<>();

        // Додаємо слова
        wordDictionary.add("hello", new Word("hello", 100));
        wordDictionary.add("world", new Word("world", 80));
        wordDictionary.add("java", new Word("java", 120));

        // Знаходимо слово з найбільшою частотою
        Word maxWord = wordDictionary.findMaxValue();
        System.out.println("Слово з найбільшою частотою: " + maxWord);

        // Створюємо словник перекладів
        Dictionary<String, Translation> translationDictionary = new Dictionary<>();

        // Додаємо переклади
        translationDictionary.add("cat", new Translation("ukrainian", "кіт", 50));
        translationDictionary.add("dog", new Translation("ukrainian", "собака", 70));
        translationDictionary.add("bird", new Translation("ukrainian", "птах", 30));

        // Знаходимо найпопулярніший переклад
        Translation maxTranslation = translationDictionary.findMaxValue();
        System.out.println("Найпопулярніший переклад: " + maxTranslation);

        // Демонструємо видалення
        Word removedWord = wordDictionary.remove("hello");
        System.out.println("Видалене слово: " + removedWord);

        // Виводимо розмір словників
        System.out.println("Розмір словника слів: " + wordDictionary.size());
        System.out.println("Розмір словника перекладів: " + translationDictionary.size());
    }
}
