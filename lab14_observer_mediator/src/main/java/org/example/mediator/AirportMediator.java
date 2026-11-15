package org.example.mediator;

interface AirportMediator {
    void notify(GroundService sender, String event);
}
