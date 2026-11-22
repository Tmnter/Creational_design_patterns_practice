package org.example.iterator;

// Модель пасажира
class Passenger {
    private final String name;
    private final String seatCode;
    private final boolean infantWithoutSeat;
    private final String specialMark;

    public Passenger(String name, String seatCode, boolean infantWithoutSeat, String specialMark) {
        this.name = name;
        this.seatCode = seatCode;
        this.infantWithoutSeat = infantWithoutSeat;
        this.specialMark = specialMark;
    }

    public String getName() {
        return name;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public boolean isInfantWithoutSeat() {
        return infantWithoutSeat;
    }

    public String getSpecialMark() {
        return specialMark;
    }

    public boolean hasSpecialMark() {
        return specialMark != null && !specialMark.isBlank();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (infantWithoutSeat) {
            sb.append(" [немовля без місця]");
        } else {
            sb.append(" [місце ").append(seatCode).append("]");
        }
        if (hasSpecialMark()) {
            sb.append(" (позначка: ").append(specialMark).append(")");
        }
        return sb.toString();
    }
}