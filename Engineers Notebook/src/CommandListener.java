public interface CommandListener {
    void onCommand(String arg);
    String getCommandName();
}