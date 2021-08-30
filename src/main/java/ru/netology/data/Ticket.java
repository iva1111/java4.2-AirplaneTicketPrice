package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;   // аэропорт вылета
    private String to;   // аэропорт прилета
    private int time;

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

}
