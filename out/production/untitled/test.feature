Feature: Напоминалка
  Scenario: Добавление друга
    Given список friends пуст
    When вызывается функция addFriend с параметрами "Иван" и LocalDate.of(2000, 3, 15)
    Then список friends содержит одного друга с именем "Иван" и датой рождения 15 марта 2000 года

  Scenario: Вывод предстоящих дней рождения
    Given список friends содержит несколько друзей с предстоящими днями рождениями
    When вызывается функция remindUpcomingBirthdays
    Then список after содержит сообщения о предстоящих днях рождения друзей

  Scenario: Вывод прошедших дней рождения
    Given список friends содержит несколько друзей с прошедшими днями рождениями
    When вызывается функция showPastBirthdays
    Then список before содержит сообщения о прошедших днях рождения друзей