# Десктопный интерфейс пользователя SearchStat
### версия 3.0

#### Создано для проекта HardDevTeam SearchStat https://github.com/AlexAlizar/SearchStat/
#### (Сбор статистики популярности личностей на различных сайтах)

## Настройка параметров сервера базы данных
Для тестового режима укажите в реквизите URL сервера значение "demo" (без кавычек).
В тестовом режиме в момент авторизации пользователя достаточно нажать кнопку "ОК" без ввода логина и пароля; в этом режиме система не извлекает информацию из базы данных, а использует предопределенные данные.

## Использование
### Просмотр общей статистики.
* Пользователь выбирает необходимый сайт из списка, предоставляемого системой.
* Система извлекает из базы данных данные по количеству упоминаний всех элементов из справочника имен по указанному сайту.
* Система отображает информацию в виде таблицы с полями: «Имя», «Количество упоминаний».
* На закладке "Диаграмма" выводится та же информацие в виде круговой диаграммы.
### Просмотр ежедневной статистики.
* Пользователь выбирает необходимый сайт из списка, предоставляемого системой.
* Пользователь выбирает необходимое имя из списка, предоставляемого системой.
* Пользователь выбирает интервал, за который требуется получить ежедневную статистику.
* Система извлекает из базы данных информацию по количеству новых страниц с упоминаниями выбранного имени по указанному сайту за каждый день выбранного интервала.
* Система отображает в доступном для пользователя виде информацию в виде таблицы с полями: «Дата», «Количество новых страниц».
* На закладке "Диаграмма" выводится та же информацие в виде линейного графика.

## Разработка
Гринштейн Дмитрий
dgrin2005@mail.ru