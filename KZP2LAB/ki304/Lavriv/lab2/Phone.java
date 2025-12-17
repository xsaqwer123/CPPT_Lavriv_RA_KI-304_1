package ki304.Lavriv.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє телефон з основними функціями, такими як увімкнення, вимкнення,
 * встановлення додатків, зарядка батареї тощо.
 */
public class Phone {
    private Battery battery;
    private Screen screen;
    private OperatingSystem operatingSystem;
    private Logger logger;
    private String name;
    private boolean isOn;
    private List<String> installedApps;
    private int availableStorage;

    /**
     * Конструктор для створення телефону з іменем та доступним сховищем.
     * @param name Назва телефону.
     * @param storage Доступне сховище в MB.
     * @throws IOException якщо виникає помилка при ініціалізації логера.
     */
    public Phone(String name, int storage) throws IOException {
        this.name = name;
        this.isOn = false;
        this.installedApps = new ArrayList<>();
        this.availableStorage = storage;
        this.battery = new Battery(100, 100);
        this.screen = new Screen(6.2, "Super Retina XDR OLED");
        this.operatingSystem = new OperatingSystem("IOS", "18");

        this.logger = new Logger("phone_log.txt");
        logger.log(String.format("Телефон %s створений.", this.toString()));
    }

    /**
     * Конструктор для створення телефону з наданими параметрами.
     * @param battery Батарея телефону.
     * @param screen Екран телефону.
     * @param operatingSystem Операційна система телефону.
     * @param name Назва телефону.
     * @param storage Доступне сховище в MB.
     * @throws IOException якщо виникає помилка при ініціалізації логера.
     */
    public Phone(Battery battery, Screen screen, OperatingSystem operatingSystem, String name, int storage) throws IOException {
        this.battery = battery;
        this.screen = screen;
        this.operatingSystem = operatingSystem;
        this.name = name;
        this.isOn = false;
        this.installedApps = new ArrayList<>();
        this.availableStorage = storage;

        this.logger = new Logger("phone_log.txt");
        logger.log(String.format("Телефон %s створений.", this.toString()));
    }

    /**
     * Вмикає телефон.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void turnOn() throws IOException {
        isOn = true;
        logger.log(String.format("Телефон %s увімкнено", name));
        System.out.printf("Телефон %s увімкнено\n", name);
    }

    /**
     * Вимикає телефон.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void turnOff() throws IOException {
        isOn = false;
        logger.log(String.format("Телефон %s вимкнено", name));
        System.out.printf("Телефон %s вимкнено\n", name);
    }

    /**
     * Заряджає батарею телефону.
     * @param minutes Кількість хвилин зарядки.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void chargeBattery(int minutes) throws IOException {
        int oldCharge = battery.getChargeLevel();
        battery.charge(minutes);
        logger.log(String.format("Заряджено батарею з %s до %s", oldCharge, battery.getChargeLevel()));
        System.out.printf("Заряджено батарею з %s до %s\n", oldCharge, battery.getChargeLevel());
    }

    /**
     * Змінює яскравість екрану.
     * @param brightness Нове значення яскравості (0-100).
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void changeScreenBrightness(int brightness) throws IOException {
        screen.setBrightness(brightness);
        logger.log(String.format("Змінено яскравість екрану на %s", brightness));
        System.out.printf("Змінено яскравість екрану на %s\n", brightness);
    }

    /**
     * Оновлює версію операційної системи.
     * @param newVersion Нова версія ОС.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void updateOSVersion(String newVersion) throws IOException {
        String oldVersion = operatingSystem.getVersion();
        operatingSystem.setVersion(newVersion);
        logger.log(String.format("Оновлено ОС з версії %s до %s", oldVersion, newVersion));
        System.out.printf("Оновлено ОС з версії %s до %s\n", oldVersion, newVersion);
    }

    /**
     * Перевіряє рівень заряду батареї.
     * @return Рівень заряду батареї у відсотках.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public int checkBatteryLevel() throws IOException {
        int level = battery.getChargeLevel();
        logger.log(String.format("Перевірено рівень заряду батареї: %s", level));
        System.out.printf("Перевірено рівень заряду батареї: %s\n", level);
        return level;
    }

    /**
     * Встановлює нову програму на телефон.
     * @param appName Назва програми для встановлення.
     * @param appSize Розмір програми в MB.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void installApp(String appName, int appSize) throws IOException {
        if (appSize <= availableStorage) {
            installedApps.add(appName);
            availableStorage -= appSize;
            logger.log(String.format("Встановлено нову програму: %s (розмір: %d MB)", appName, appSize));
            System.out.printf("Встановлено нову програму: %s (розмір: %d MB)\n", appName, appSize);
        } else {
            logger.log(String.format("Не вдалося встановити програму %s. Недостатньо місця.", appName));
            System.out.printf("Не вдалося встановити програму %s. Недостатньо місця.\n", appName);
        }
    }

    /**
     * Видаляє програму з телефону.
     * @param appName Назва програми для видалення.
     * @param appSize Розмір програми в MB.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public void uninstallApp(String appName, int appSize) throws IOException {
        if (installedApps.remove(appName)) {
            availableStorage += appSize;
            logger.log(String.format("Видалено програму: %s (звільнено %d MB)", appName, appSize));
            System.out.printf("Видалено програму: %s (звільнено %d MB)\n", appName, appSize);
        } else {
            logger.log(String.format("Не вдалося видалити програму %s. Програма не знайдена.", appName));
            System.out.printf("Не вдалося видалити програму %s. Програма не знайдена.\n", appName);
        }
    }

    /**
     * Перевіряє доступне місце на телефоні.
     * @return Доступне місце в MB.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public int checkAvailableStorage() throws IOException {
        logger.log(String.format("Перевірено доступне місце: %d MB", availableStorage));
        System.out.printf("Перевірено доступне місце: %d MB\n", availableStorage);
        return availableStorage;
    }

    /**
     * Перевіряє, чи ввімкнений телефон.
     * @return true, якщо телефон ввімкнений, false - якщо вимкнений.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public boolean isPhoneOn() throws IOException {
        logger.log(String.format("Перевірено стан телефону: %s", isOn ? "ввімкнений" : "вимкнений"));
        System.out.printf("Перевірено стан телефону: %s\n", isOn ? "ввімкнений" : "вимкнений");
        return isOn;
    }

    /**
     * Отримує інформацію про телефон.
     * @return Рядок з інформацією про телефон.
     * @throws IOException якщо виникає помилка при записі в лог.
     */
    public String getInfo() throws IOException {
        String info = "Телефон: " + name + ", ОС: " + operatingSystem.getName() + " " + operatingSystem.getVersion()
                + ", Екран: " + screen.getSize() + "\" " + screen.getType()
                + ", Батарея: " + battery.getCapacity() + "mAh";

        logger.log("Отримано інформацію про телефон");
        System.out.println("Отримано інформацію про телефон");
        return info;
    }

    /**
     * Закриває логер для збереження даних у файл.
     *
     * @throws IOException якщо виникає помилка під час закриття логера.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}

