# Задание НТ Performance Lab
Решения четырёх задач тестового задания Performance Lab на Java
---
Язык: Java. Для запуска требуется JDK 21.

## Задание 1

Аргументы: n1 m1 n2 m2

**Передаём значения в Terminal в IDE** (пример):
```shell
java task1/src/task1.java 6 3 5 4
```

## Задание 2

Аргументы:
1. Путь к файлу с центром и полуосями эллипса
2. Путь к файлу с координатами точек

**Прописываем в Terminal в IDE**:

```shell
java task2/src/task2.java task2/ellipse.txt task2/points.txt
```

## Задание 3

Для работы с JSON используется Gson 2.14.0
Библиотека включена в репозиторий: lib/gson-2.14.0.jar
При запуске она подключается через параметр -cp

Аргументы:
1. Путь к файлу с результатами тестов — values.json
2. Путь к файлу со структурой отчёта — tests.json
3. Путь для сохранения отчёта — report.json

**Прописываем в Terminal в IDE**:

```shell
java -cp "lib/gson-2.14.0.jar" task3/src/task3.java task3/values.json task3/tests.json task3/report.json
```
| Выходной файл создаётся или перезаписывается
| Папка для его сохранения должна существовать
| Выходной путь должен отличаться от входных

## Задание 4

Аргумент: путь к файлу с целыми числами

**Прописываем в Terminal в IDE**:

```shell
java task4/src/task4.java task4/numbers.txt
```
