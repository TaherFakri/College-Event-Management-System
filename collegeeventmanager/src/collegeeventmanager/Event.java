package collegeeventmanager;
public class Event {
    public int id;
    public String name;
    public String date;

    public Event(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return id + ". " + name + " on " + date;
    }
}