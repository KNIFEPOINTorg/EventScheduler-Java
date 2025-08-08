# Event Scheduler

## What It Does

This is a simple Java application that helps you manage events. You can create events, view them, and organize your schedule.

**Features**:
- Create new events with title, date, and description
- View your events
- Works with both windows (GUI) and text commands (CLI)

## How to Run

1. Make sure you have Java installed
2. Run the GUI version: `java -cp "target/classes;src/main/resources" com.eventmanagement.launcher.GUILauncher`
3. Or run the text version: `java -cp "target/classes;src/main/resources" com.eventmanagement.ui.cli.CLILauncher`

## Team Contributions

- **Amen**: AppController, BaseEntity, CLILauncher
- **Fikadu**: DatabaseConnection, DatabaseException, Event, CLIMenu
- **Kinfe**: MainFrame, User, UserPanel, ValidationException
- **Mikias**: EventListPanel, EventService, FileLogger, GUILauncher
- **Nahom**: EventDAO, EventDAOImpl, EventFormDialog
