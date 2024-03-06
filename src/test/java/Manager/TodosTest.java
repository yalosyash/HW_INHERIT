package Manager;

import Manager.Tasks.Epic;
import Manager.Tasks.Meeting;
import Manager.Tasks.SimpleTask;
import Manager.Tasks.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    //Search
    @Test
    public void ifSearchNothing() {
        Todos todos = new Todos();
        Task task = new Task(555);
        todos.add(task);

        Task[] expected = {};
        Task[] actual = todos.search("not found");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("not found");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAllTypeOfTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting1 = new Meeting(556, "Покупка Хлеба", "Поход в Пятерочку", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meeting1);

        Task[] expected = {simpleTask, epic, meeting1};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySimpleTaskMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByEpicMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMeetingMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }
}