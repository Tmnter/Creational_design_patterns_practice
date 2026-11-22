package org.example.memento;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

// Незмінний знімок стану розкладу (Memento)
final class ScheduleMemento {
    private final String snapshotName;
    private final Map<String, FlightSlot> slotsSnapshot;

    ScheduleMemento(String snapshotName, Map<String, FlightSlot> currentSlots) {
        this.snapshotName = snapshotName;
        Map<String, FlightSlot> copy = new LinkedHashMap<>();
        for (Map.Entry<String, FlightSlot> entry : currentSlots.entrySet()) {
            copy.put(entry.getKey(), entry.getValue().copy());
        }
        this.slotsSnapshot = Collections.unmodifiableMap(copy);
    }

    String getSnapshotName() {
        return snapshotName;
    }

    Map<String, FlightSlot> getSlotsSnapshot() {
        Map<String, FlightSlot> copy = new LinkedHashMap<>();
        for (Map.Entry<String, FlightSlot> entry : slotsSnapshot.entrySet()) {
            copy.put(entry.getKey(), entry.getValue().copy());
        }
        return copy;
    }
}
