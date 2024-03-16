package trabalho.client.cli;

import trabalho.client.commands.Command;

public class MenuItem {
    private final String key;
    private final String label;
    private final Command command;

    public MenuItem(String key, String label, Command command) {
        this.key = key;
        this.label = label;
        this.command = command;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }

    public Command getCommand() {
        return command;
    }
}