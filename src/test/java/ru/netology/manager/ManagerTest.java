package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    private Ticket ticket1 = new Ticket(1, 5000, "Пермь", "Москва", 120);
    private Ticket ticket2 = new Ticket(2, 8000, "Пермь", "Сочи", 200);
    private Ticket ticket3 = new Ticket(3, 6500, "Пермь", "Москва", 120);
    private Ticket ticket4 = new Ticket(4, 9000, "Пермь", "Симферополь", 180);
    private Ticket ticket5 = new Ticket(5, 3000, "Москва", "Прага", 120);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
        // сортировка по цене
    void shouldSortByPrice() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = new Ticket[]{ticket4, ticket2, ticket3, ticket1, ticket5};
        Arrays.sort(actual);
    }

    @Test // должен найти все билеты
    void shouldFindAllTicket() {
        Ticket[] expected = new Ticket[]{ticket1, ticket3};
        Ticket[] actual = manager.findAll("Пермь", "Москва");
        assertArrayEquals(expected, actual);
    }

    @Test
        // нет билетов по указанным направлениям
    void souldNoTicketsForIndicatedDirections() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Париж", "Лондон");
        assertArrayEquals(expected, actual);
    }

    @Test
        // не правильно указан прилет-отлет
    void arrivalDepartureNotCorrect() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Прага", "Москва");
        assertArrayEquals(expected, actual);
    }

}




