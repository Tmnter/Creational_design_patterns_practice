package org.example.memento;
import java.util.HashMap;
import java.util.Map;
class ScheduleHistory {
    private final Map<String, ScheduleMemento> versions = new HashMap<>();

    public void save(String versionName, ScheduleMemento memento) {
        versions.put(versionName, memento);
        System.out.println("[08:04] [ScheduleHistory:Memento] Збережено варіант '" + versionName
                + "' в історії (змінювати вміст знімка заборонено). Всього варіантів: " + versions.size());
    }

    public ScheduleMemento get(String versionName) {
        return versions.get(versionName);
    }
}
