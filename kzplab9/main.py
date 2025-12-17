from MobilePhone import MobilePhone

if __name__ == "__main__":
    # Створюємо мобільний телефон
    my_phone = MobilePhone("Samsung", "Galaxy S21", "Android", 4000, 5.5)

    # Виводимо початковий статус телефону
    print("\n1. Початковий статус:")
    print(my_phone.get_status())

    # Виконуємо дзвінок
    print("\n2. Дзвінок:")
    my_phone.make_call("+380671234567")
    print(f"Залишок заряду: {my_phone.battery_level}%")

    # Отримуємо повідомлення
    print("\n3. Отримання повідомлення:")
    my_phone.receive_message("+380671234567", "Привіт! Як справи?")

    # Надсилаємо повідомлення
    print("\n4. Відправка повідомлення:")
    my_phone.send_message("+380671234567", "Все добре, дякую!")

    # Заряджаємо телефон
    print("\n5. Заряджання телефону:")
    my_phone.charge(20)
    print(f"Залишок заряду: {my_phone.battery_level}%")

    # Додаємо контакт
    print("\n6. Додавання контакту:")
    my_phone.add_contact("Іван", "+380671234567")
    my_phone.list_contacts()

    # Видаляємо контакт
    print("\n7. Видалення контакту:")
    my_phone.delete_contact("Іван")
    my_phone.list_contacts()

    # Встановлюємо Wi-Fi
    print("\n8. Підключення до Wi-Fi:")
    my_phone.connect_to_wifi("Домашня мережа")

    # Підключення до нового Wi-Fi
    print("\n9. Підключення до нового Wi-Fi:")
    my_phone.connect_to_wifi("Tenda")

    # Відкриваємо програму
    print("\n10. Відкриття програми:")
    my_phone.open_app("Камера")

    # Вимикаємо телефон
    print("\n11. Вимикання телефону:")
    my_phone.power_off()
    print(my_phone.get_status())