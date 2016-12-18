package ru.innopolis.uni.cource3.homework.BusinessLogic;

/**
 * Created by korot on 16.12.2016.
 *
 * Объект монитор - разделяемы несколькими потоками объект
 */
public interface Monitor {
    boolean isError = false;

    /**
     * Флаг о случившейся ошибке в системе
     * @return возвращает true если ошибка произошла в одном из потоков
     * что является сигналом для остановки данного и  других потоков
     */
    boolean isError();

    /**
     * Задаем флаг наличия ошибки в одном из потоков,
     * что является сигналом для остановки данного потока и других потоков
     * @param error
     */
    void setError(boolean error);

    /**
     * Метод для обработки данных в соответствии с логикой программы
     * @param str получает распарсенную строку для дальнейше обработки
     */
    void processing(String str);
}
