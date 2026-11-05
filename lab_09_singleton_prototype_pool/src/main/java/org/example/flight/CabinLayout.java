package org.example.flight;
import java.util.ArrayList;
import java.util.List;

class CabinLayout implements Cloneable {
    private String layoutType;
    private List<String> blockedSeats;

    public CabinLayout(String layoutType) {
        this.layoutType = layoutType;
        this.blockedSeats = new ArrayList<>();
    }

    public void blockSeat(String seat) {
        blockedSeats.add(seat);
    }

    @Override
    public CabinLayout clone() {
        try {
            CabinLayout cloned = (CabinLayout) super.clone();
            cloned.blockedSeats = new ArrayList<>(this.blockedSeats); // глибоке копіювання списку
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Схема: " + layoutType + ", заблоковані місця: " + blockedSeats;
    }
}