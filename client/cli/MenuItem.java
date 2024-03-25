package trabalho.client.cli;

import trabalho.client.commands.Command;

public class MenuItem {
    private final String description;
    private final Menu subMenu;
    private final Command command;

    public MenuItem(String description, Menu subMenu) {
        this.description = description;
        this.subMenu = subMenu;
        this.command = null;
    }

    public MenuItem(String description, Command command) {
        this.description = description;
        this.subMenu = null;
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public Command getCommand() {
        return command;
    }

    public boolean isSubMenu() {
        return subMenu != null;
    }
}