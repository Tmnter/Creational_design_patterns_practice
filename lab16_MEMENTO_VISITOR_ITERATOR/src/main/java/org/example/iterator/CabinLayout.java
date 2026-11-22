package org.example.iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
class CabinLayout {
    private final String flightNumber;
    // Впорядковані ряди: номер ряду -> (місце -> пасажир)
    private final Map<Integer, Map<String, Passenger>> rows = new LinkedHashMap<>();
    private final List<Passenger> infantsWithoutSeat = new ArrayList<>();

    public CabinLayout(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void addSeatPassenger(int rowNumber, String seatCode, Passenger passenger) {
        rows.computeIfAbsent(rowNumber, k -> new LinkedHashMap<>()).put(seatCode, passenger);
    }

    public void addInfantWithoutSeat(Passenger infant) {
        infantsWithoutSeat.add(infant);
    }

    // Пакето-приватні методи доступу для ітераторів, щоб служби не залежали від структури
    List<Integer> getOrderedRowNumbers() {
        return new ArrayList<>(rows.keySet());
    }

    List<Passenger> getRowPassengers(int rowNumber) {
        Map<String, Passenger> seats = rows.get(rowNumber);
        if (seats == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(seats.values());
    }

    List<Passenger> getInfantsWithoutSeat() {
        return new ArrayList<>(infantsWithoutSeat);
    }

    // Окремі способи обходу
    public Iterator<Passenger> createBoardingIterator() {
        return new BoardingRearToFrontIterator(this);
    }

    public Iterator<Passenger> createCateringIterator() {
        return new CateringFrontToBackWithInfantsIterator(this);
    }

    public Iterator<Passenger> createSecuritySpecialMarkIterator() {
        return new SecuritySpecialMarkIterator(this);
    }
}
