package Manager.Tasks;

public class Task {

    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public boolean matches(String query) {
        return false;
    }
}