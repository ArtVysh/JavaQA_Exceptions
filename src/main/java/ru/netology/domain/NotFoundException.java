package ru.netology.domain;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Товар с индексом: " + id + " не найден");
    }

}
