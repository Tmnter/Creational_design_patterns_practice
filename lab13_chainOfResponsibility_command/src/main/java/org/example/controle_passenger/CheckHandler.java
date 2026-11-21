package java.org.example.controle_passenger;

abstract class CheckHandler {
    protected CheckHandler nextHandler;

    public CheckHandler setNext(CheckHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(org.example.controle_passenger.Passenger passenger);
}
