package ki304.Lavriv.lab3;

import java.io.IOException;

/**
 * Інтерфейс для мобільних пристроїв, що надає базові функції, такі як дзвінки та відправка SMS.
 */
public interface MobileDevice {

    /**
     * Здійснює дзвінок на вказаний номер.
     *
     * @param number Номер телефону, на який здійснюється дзвінок.
     * @throws IOException якщо виникає помилка під час здійснення дзвінка.
     */
    void makeCall(String number) throws IOException;

    /**
     * Відправляє SMS-повідомлення на вказаний номер.
     *
     * @param number Номер телефону, на який надсилається повідомлення.
     * @param message Текст повідомлення.
     * @throws IOException якщо виникає помилка під час відправки повідомлення.
     */
    void sendSMS(String number, String message) throws IOException;
}