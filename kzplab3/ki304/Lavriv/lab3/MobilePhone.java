package ki304.Lavriv.lab3;

import java.io.IOException;

/**
 * Клас, що представляє мобільний телефон, який розширює клас {@link Phone}
 * та реалізує інтерфейс {@link MobileDevice}. Надає можливості здійснення дзвінків
 * та відправки SMS-повідомлень.
 */
public class MobilePhone extends Phone implements MobileDevice {
    private String mobileNumber;

    /**
     * Конструктор для створення мобільного телефону.
     *
     * @param name Назва телефону.
     * @param storage Доступне сховище в MB.
     * @param mobileNumber Мобільний номер телефону.
     * @throws IOException якщо виникає помилка при ініціалізації логера.
     */
    public MobilePhone(String name, int storage, String mobileNumber) throws IOException {
        super(name, storage);
        this.mobileNumber = mobileNumber;
    }

    /**
     * Повертає тип телефону.
     *
     * @return Строка, що вказує на тип телефону: "Мобільний телефон".
     */
    @Override
    public String getPhoneType() {
        return "Мобільний телефон";
    }

    /**
     * Здійснює дзвінок на вказаний номер.
     *
     * @param number Номер телефону, на який здійснюється дзвінок.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    @Override
    public void makeCall(String number) throws IOException {
        logger.log(String.format("Здійснено дзвінок на номер %s", number));
        System.out.printf("Здійснено дзвінок на номер %s\n", number);
    }

    /**
     * Відправляє SMS-повідомлення на вказаний номер.
     *
     * @param number Номер телефону, на який надсилається повідомлення.
     * @param message Текст повідомлення.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    @Override
    public void sendSMS(String number, String message) throws IOException {
        logger.log(String.format("Відправлено SMS на номер %s: %s", number, message));
        System.out.printf("Відправлено SMS на номер %s: %s\n", number, message);
    }

    /**
     * Метод для отримання мобільного номера телефону.
     *
     * @return Мобільний номер телефону.
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
}