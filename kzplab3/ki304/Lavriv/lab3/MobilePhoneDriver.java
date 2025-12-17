package ki304.Lavriv.lab3;

import java.io.IOException;

/**
 * Клас `PhoneDriver` містить метод `main`, який демонструє використання класу `Phone`.
 * Створюється екземпляр телефону, викликаються методи для керування його станом,
 * заряджання, встановлення та видалення додатків, а також інші функції.
 */
public class MobilePhoneDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телефоном шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            MobilePhone mobilePhone = new MobilePhone("iPhone 10", 128000, "+380991234567");

            mobilePhone.turnOn();
            mobilePhone.chargeBattery(30);
            mobilePhone.changeScreenBrightness(75);
            mobilePhone.updateOSVersion("15.0");
            mobilePhone.checkBatteryLevel();
            mobilePhone.installApp("WhatsApp", 200);
            mobilePhone.makeCall("+380997654321");
            mobilePhone.sendSMS("+380997654321", "Привіт! Як справи?");
            System.out.println(mobilePhone.getInfo());
            System.out.println("Тип телефону: " + mobilePhone.getPhoneType());
            System.out.println("Мобільний номер: " + mobilePhone.getMobileNumber());
            mobilePhone.turnOff();

            mobilePhone.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
