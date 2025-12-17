class Phone:
    """
    Клас Phone представляє базовий телефон.
    """

    def __init__(self, brand, model):
        """
        Ініціалізує телефон.

        :param brand: Бренд телефону.
        :param model: Модель телефону.
        """
        self.brand = brand
        self.model = model
        self.is_powered_on = True

    def make_call(self, number):
        """
        Виконує дзвінок на вказаний номер.

        :param number: Номер телефону.
        """
        if self.is_powered_on:
            print(f"Дзвонимо на номер {number}...")
        else:
            print("Телефон вимкнений. Увімкніть його для здійснення дзвінків.")

    def receive_call(self, number):
        """
        Приймає дзвінок від вказаного номера.

        :param number: Номер телефону.
        """
        if self.is_powered_on:
            print(f"Вхідний дзвінок від номера {number}.")
        else:
            print("Телефон вимкнений. Ви не можете прийняти дзвінок.")

    def power_on(self):
        """
        Увімкнення телефону.
        """
        self.is_powered_on = True
        print("Телефон увімкнений.")

    def power_off(self):
        """
        Вимкнення телефону.
        """
        self.is_powered_on = False
        print("Телефон вимкнений.")

    def get_status(self):
        """
        Отримує статус телефону.
        """
        power_status = "увімкнений" if self.is_powered_on else "вимкнений"
        return f"Телефон {self.brand} {self.model} - {power_status}."