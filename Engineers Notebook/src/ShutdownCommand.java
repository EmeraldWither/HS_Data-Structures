public class ShutdownCommand implements CommandListener {

    @Override
    public void onCommand(String arg) {
        System.out.println("Shutting down " + arg + "'s' system!");
    }
    
    @Override
    public String getCommandName() {
        return "Shutdown Command";
    }
    
}
