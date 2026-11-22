package org.example.iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.NoSuchElementException;
class SecuritySpecialMarkIterator implements Iterator<Passenger> {
    private final List<Passenger> filteredPassengers = new ArrayList<>();
    private int cursor = 0;

    public SecuritySpecialMarkIterator(CabinLayout cabin) {
        for (int row : cabin.getOrderedRowNumbers()) {
            for (Passenger p : cabin.getRowPassengers(row)) {
                if (p.hasSpecialMark()) {
                    filteredPassengers.add(p);
                }
            }
        }
        for (Passenger infant : cabin.getInfantsWithoutSeat()) {
            if (infant.hasSpecialMark()) {
                filteredPassengers.add(infant);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cursor < filteredPassengers.size();
    }

    @Override
    public Passenger next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return filteredPassengers.get(cursor++);
    }
}
