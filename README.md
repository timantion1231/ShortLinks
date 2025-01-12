# Инструкция по использованию сервиса сокращения ссылок

## Описание
Данный сервис позволяет создавать короткие ссылки, управлять ими и переходить по ним. После запуска программы пользователь попадает в главное меню, где доступны различные функции.

## Главное меню

При запуске программы отображается главное меню с следующими пунктами:

- **register: 1** - Регистрация нового пользователя. Вам выдается ваш ID, который вы можете использовать при входе в систему для редактирования ваших коротких ссылок. При регистрации вы автоматически авторизуетесь в системе.
- **log in: 2** - Авторизация пользователя. Введите ваш ID, который вы получили при регистрации.
- **log out: 3** - Выход из системы. После завершения работы с вашими ссылками выйдите из системы, чтобы другие пользователи могли работать со своими ссылками и не имели доступа к редактированию ваших ссылок.
- **create short link: 4** - Создание короткой ссылки. Введите полный адрес ресурса, сокращенную ссылку которого вы хотите получить. Если пользователь не авторизован, то автоматически происходит регистрация нового пользователя.
- **follow to short link: 5** - Переход по сокращенной ссылке. Вставьте сокращенную ссылку, и если переход возможен, автоматически откроется браузер с ресурсом, на который ведет ссылка.
- **show all links: 6** - Вывод всех созданных вами ссылок.
- **edit your links: 7** - Редактирование ваших ссылок. При выборе этого пункта откроется новое меню для редактирования созданных вами ссылок (см. инструкцию ниже).
- **exit: -1** - Завершение работы программы.

Для выбора действия введите в консоль цифру, указанную справа от действия.

## Редактирование ссылок

При выборе пункта **edit your links: 7** (редактирование созданных вами ссылок) откроется следующее меню:

- **your links:** Здесь отображены ваши ссылки.
- **remove: 1** - Удаление ссылки. После выбора данного действия вставьте ссылку, которую вы хотите удалить.
- **change count of clicks: 2** - Изменение количества переходов. После выбора данного действия вставьте ссылку и после нажатия Enter введите число максимальных переходов по ссылке.
- **change live days: 3** - Изменение количества дней жизни ссылки. После выбора данного действия вставьте ссылку и после нажатия Enter введите число дней, после которых ссылка автоматически удалится.
- **back: 0** - Возврат в главное меню.

## Важно
По умолчанию после создания ссылки по ней можно перейти 1 раз и только в течение суток.