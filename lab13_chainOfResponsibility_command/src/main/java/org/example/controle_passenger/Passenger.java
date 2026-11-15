package org.example.controle_passenger;

class Passenger {
    private final String name;
    private final boolean isInternational;
    private final boolean hasValidTicket;
    private final boolean hasValidPassport;
    private final boolean passedSecurityCheck;
    private final double luggageWeight;

    public Passenger(String name, boolean isInternational, boolean hasValidTicket, boolean hasValidPassport, boolean passedSecurityCheck, double luggageWeight) {
        this.name = name;
        this.isInternational = isInternational;
        this.hasValidTicket = hasValidTicket;
        this.hasValidPassport = hasValidPassport;
        this.passedSecurityCheck = passedSecurityCheck;
        this.luggageWeight = luggageWeight;
    }

    public String getName() { return name; }
    public boolean isInternational() { return isInternational; }
    public boolean hasValidTicket() { return hasValidTicket; }
    public boolean hasValidPassport() { return hasValidPassport; }
    public boolean isPassedSecurityCheck() { return passedSecurityCheck; }
    public double getLuggageWeight() { return luggageWeight; }
}