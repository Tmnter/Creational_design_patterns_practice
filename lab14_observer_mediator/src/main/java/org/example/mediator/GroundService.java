package org.example.mediator;

abstract class GroundService {
    protected AirportMediator mediator;
    protected String name;

    public GroundService(AirportMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
