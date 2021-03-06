# DDD Exception

Проект призван описать работу с исключениями в доменной области.

## Резюме
1. В домене **все** исключения **дожны** быть проверяемые
1. В приложении разработчик не должен возбуждать исключение с описанием:
 
    > Произошла непредвиденная ошибка
1. Название любого исключения должно раскрывать контекст в котором оно возбуждается
1. Каждое доменное исключение является полноценным классом предметной области
1. Каждое доменное исключение должно содержать исчерпывающее литературное описание для конечного пользователя
1. Каждое доменное исключение должно содержать детальное сообщение для логирование

## Функционал приложения

1. Приложению на вход подаётся пользователь для регистрации
1. Пользователь сохраняется в БД
1. Можно запросить список пользователь  

1. Чистые методы, свободные от исключений
1. Изменение прикладных классов под влиянием доменной модели