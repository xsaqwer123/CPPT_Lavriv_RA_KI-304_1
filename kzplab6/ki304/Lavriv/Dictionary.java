package ki304.Lavriv.lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Параметризований клас, що реалізує словник
 * @param <K> тип ключа
 * @param <V> тип значення
 */
public class Dictionary<K extends Comparable<K>, V extends Comparable<V>> {
    private Map<K, V> dictionary;

    /**
     * Конструктор класу Dictionary
     */
    public Dictionary() {
        dictionary = new HashMap<>();
    }

    /**
     * Додає новий елемент до словника
     * @param key ключ
     * @param value значення
     * @return попереднє значення, якщо ключ вже існував
     */
    public V add(K key, V value) {
        return dictionary.put(key, value);
    }

    /**
     * Видаляє елемент зі словника за ключем
     * @param key ключ елемента для видалення
     * @return видалене значення або null якщо ключ не знайдено
     */
    public V remove(K key) {
        return dictionary.remove(key);
    }

    /**
     * Знаходить максимальне значення у словнику
     * @return максимальне значення
     * @throws NoSuchElementException якщо словник порожній
     */
    public V findMaxValue() {
        if (dictionary.isEmpty()) {
            throw new NoSuchElementException("Dictionary is empty");
        }
        return dictionary.values().stream()
                .max(V::compareTo)
                .orElseThrow();
    }

    /**
     * Знаходить максимальний ключ у словнику
     * @return максимальний ключ
     * @throws NoSuchElementException якщо словник порожній
     */
    public K findMaxKey() {
        if (dictionary.isEmpty()) {
            throw new NoSuchElementException("Dictionary is empty");
        }
        return dictionary.keySet().stream()
                .max(K::compareTo)
                .orElseThrow();
    }

    /**
     * Повертає розмір словника
     * @return кількість елементів у словнику
     */
    public int size() {
        return dictionary.size();
    }

    /**
     * Очищає словник
     */
    public void clear() {
        dictionary.clear();
    }

    /**
     * Повертає усі пари ключ-значення
     * @return Map з усіма елементами словника
     */
    public Map<K, V> getAll() {
        return new HashMap<>(dictionary);
    }
}
