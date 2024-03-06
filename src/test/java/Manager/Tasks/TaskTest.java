package Manager.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // SimpleTask
    @Test
    public void ifMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNotMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("сделать");
        Assertions.assertEquals(expected, actual);
    }

    //Epic
    @Test
    public void ifMatchEpic() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtask);

        boolean expected = true;
        boolean actual = epic.matches("йца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNotMatchEpic() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtask);

        boolean expected = false;
        boolean actual = epic.matches("сделать");
        Assertions.assertEquals(expected, actual);
    }

    //Meeting
    @Test
    public void ifMatchByTopicMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("версии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifMatchByProjectMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNotMatchByTopicMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNotMatchByProjectMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("Нети");
        Assertions.assertEquals(expected, actual);
    }
}