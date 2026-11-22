package org.example.iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
class CateringFrontToBackWithInfantsIterator implements Iterator<Passenger> {
    private final List<Passenger> orderedPassengers = new ArrayList<>();
    private int cursor = 0;

    public CateringFrontToBackWithInfantsIterator(CabinLayout cabin) {
        for (int row : cabin.getOrderedRowNumbers()) {
            orderedPassengers.addAll(cabin.getRowPassengers(row));
        }
        orderedPassengers.addAll(cabin.getInfantsWithoutSeat());
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
