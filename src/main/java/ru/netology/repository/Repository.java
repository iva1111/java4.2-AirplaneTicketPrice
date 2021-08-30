package ru.netology.repository;

import ru.netology.data.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];
    private Repository repository;

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int price) {
        for (Ticket item : tickets) {
            if (item.getId() == price) {
                return item;
            }
        }
        return null;
    }

    public Ticket[] removeById(int price) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : tickets) {
            if (item.getId() != price) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
        return tmp;
    }


   public Ticket[] findAll() {
       return tickets;
   }



}

