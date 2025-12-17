from Phone import Phone


class MobilePhone(Phone):
    """
    Клас MobilePhone розширює функціональність базового класу Phone.
    """

    def __init__(self, brand, model, os, battery_capacity, screen_size):
        """
        Ініціалізує мобільний телефон.

        :param brand: Бренд телефону.
        :param model: Модель телефону.
        :param os: Операційна система.
        :param battery_capacity: Ємність батареї у мА·год.
        :param screen_size: Розмір екрану в дюймах.
        """
        super().__init__(brand, model)
        self.os = os
        self.battery_capacity = battery_capacity
        self.screen_size = screen_size
        self.battery_level = 100
        self.contacts = {}
        self.wifi_connection = ""

    def send_message(self, number, message):
        """
        Надсилає повідомлення на вказаний номер.

        :param number: Номер телефону.
        :param message: Текст повідомлення.
        """
        if self.is_powered_on and self.battery_level > 0:
            print(f"Надсилаємо повідомлення на номер {number}: {message}")
            self.battery_level -= 2  # Витрата батареї
        else:
            print("Телефон вимкнений або батарея розряджена.")

    def receive_message(self, number, message):
        """
        Отримує повідомлення від вказаного номера.

        :param number: Номер телефону.
        :param message: Текст повідомлення.
        """
        print(f"Отримано повідомлення від номера {number}: {message}")

    def charge(self, amount):
        """
        Заряджає телефон.

        :param amount: Кількість заряду (від 1 до 100%).
        """
        if self.battery_level < 100:
            self.battery_level = min(100, self.battery_level + amount)
            print(f"Телефон заряджено на {amount}%.")
        else:
            print("Батарея вже повністю заряджена.")

    def add_contact(self, name, number):
        """
        Додає контакт до телефонної книги.

        :param name: Ім'я контакту.
        :param number: Номер телефону.
        """
        self.contacts[name] = number
        print(f"Додано контакт: {name} - {number}")

    def delete_contact(self, name):
        """
        Видаляє контакт із телефонної книги.

        :param name: Ім'я контакту.
        """
        if name in self.contacts:
            del self.contacts[name]
            print(f"Контакт '{name}' видалено.")
        else:
            print(f"Контакт '{name}' не знайдено.")

    def list_contacts(self):
        """
        Виводить список контактів.
        """
        if self.contacts:
            print("Контакти:")
            for name, number in self.contacts.items():
                print(f"{name}: {number}")
        else:
            print("Список контактів порожній.")

    def connect_to_wifi(self, network_name):
        """
        Підключається до Wi-Fi мережі.

        :param network_name: Назва Wi-Fi мережі.
        """
        if self.wifi_connection == "":
            print(f"Телефон було під'єднано до Wi-Fi мережі: {self.wifi_connection}")
            print(f"Зміна мережі на: {network_name}")
            self.wifi_connection = network_name
            print(f"Підключення до Wi-Fi мережі '{network_name}' успішне.")
        else:
            self.wifi_connection = network_name
            print(f"Підключення до Wi-Fi мережі '{network_name}' успішне.")

    def open_app(self, app_name):
        """
        Відкриває додаток.

        :param app_name: Назва додатка.
        """
        if self.is_powered_on:
            print(f"Відкрито додаток '{app_name}'.")
        else:
            print("Телефон вимкнений. Увімкніть його для відкриття додатків.")