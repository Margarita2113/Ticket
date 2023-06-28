package Ticket.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void sortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOSCOW", "ANAPA", 13_500, 12, 9);
        Ticket ticket2 = new Ticket("MOSCOW", "BARNAUL", 7_600, 9, 15);
        Ticket ticket3 = new Ticket("MOSCOW", "ANAPA", 10_000, 10, 14);
        Ticket ticket4 = new Ticket("MOSCOW", "ANAPA", 11_500, 11, 15);
        Ticket ticket5 = new Ticket("MOSCOW", "SIMFEROPOL", 15_156, 14, 21);
        Ticket ticket6 = new Ticket("MOSCOW", "BARNAUL", 5_900, 8, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MOSCOW", "ANAPA");
        Ticket[] expected = {ticket3, ticket4, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOSCOW", "ANAPA", 13_500, 12, 19);//7
        Ticket ticket2 = new Ticket("MOSCOW", "BARNAUL", 7_600, 9, 15);
        Ticket ticket3 = new Ticket("MOSCOW", "ANAPA", 10_000, 10, 15);//5
        Ticket ticket4 = new Ticket("MOSCOW", "ANAPA", 11_500, 11, 15);//4
        Ticket ticket5 = new Ticket("MOSCOW", "SIMFEROPOL", 15_156, 14, 21);
        Ticket ticket6 = new Ticket("MOSCOW", "BARNAUL", 5_900, 8, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MOSCOW", "ANAPA", comparator);
        Ticket[] expected = {ticket4, ticket3, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOSCOW", "ANAPA", 13_500, 12, 9);
        Ticket ticket2 = new Ticket("MOSCOW", "BARNAUL", 7_600, 9, 15);
        Ticket ticket3 = new Ticket("MOSCOW", "ANAPA", 10_000, 10, 14);
        Ticket ticket4 = new Ticket("MOSCOW", "ANAPA", 11_500, 11, 15);
        Ticket ticket5 = new Ticket("MOSCOW", "SIMFEROPOL", 15_156, 14, 21);
        Ticket ticket6 = new Ticket("MOSCOW", "BARNAUL", 5_900, 8, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MOSCOW", "SPB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOSCOW", "ANAPA", 13_500, 12, 9);
        Ticket ticket2 = new Ticket("MOSCOW", "BARNAUL", 7_600, 9, 15);
        Ticket ticket3 = new Ticket("MOSCOW", "ANAPA", 10_000, 10, 14);
        Ticket ticket4 = new Ticket("MOSCOW", "ANAPA", 11_500, 11, 15);
        Ticket ticket5 = new Ticket("MOSCOW", "SIMFEROPOL", 15_156, 14, 21);
        Ticket ticket6 = new Ticket("MOSCOW", "BARNAUL", 5_900, 8, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MOSCOW", "SIMFEROPOL");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }
}