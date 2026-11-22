package org.example.iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
class BoardingRearToFrontIterator implements Iterator<Passenger> {
    private final List<Passenger> orderedPassengers = new ArrayList<>();
    private int cursor = 0;

    public BoardingRearToFrontIterator(CabinLayout cabin) {
        List<Integer> rowNumbers = cabin.getOrderedRowNumbers();
        for (int i = rowNumbers.size() - 1; i >= 0; i--) {
            int row = rowNumbers.get(i);
            orderedPassengers.addAll(cabin.getRowPassengers(row));
        }
    }

    @Override
    public boolean hasNext() {
        return cursor < orderedPassengers.size();
    }

    @Override
    public Passenger next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return orderedPassengers.get(cursor++);
    }
}