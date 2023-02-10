package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void startMenu(Store tracker, Output output, Input input) {
        try (Store track = tracker) {
            List<UserAction> actions = List.of(
                    new EditAction(output),
                    new CreateManyItems(output),
                    new ShowAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new DeleteAction(output),
                    new DeleteAllItems(output),
                    new ExitAction());
            new StartUI(output).init(input, track, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        startMenu(new MemTracker(), output, input);
    }
}
