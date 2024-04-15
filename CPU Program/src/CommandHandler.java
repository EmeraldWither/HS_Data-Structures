import java.util.Scanner;

public class CommandHandler {
    private final CPU cpu;
    private Scanner in = new Scanner(System.in);
    public CommandHandler(CPU cpu) {
        this.cpu = cpu;
    }
    public void start() {
        System.out.println("\n\n\nWelcome to CPU Shell 1.0.0 LTS (SUN/Linux 4.4.0 Generic x86_Java)\n0 Jobs are added.\n0 Jobs can be executed.");
        prompt();
    }
    private void prompt(){
        System.out.print("Ishaan Sayal @ 127.0.0.1: ~$ ");
        String cmdStr = in.nextLine();
        String[] cmd = cmdStr.split(" ");
        if(cmd[0].equalsIgnoreCase("add")) {
            addCmd(cmd);
        }
        else if(cmd[0].equalsIgnoreCase("continue")){
            cpu.run();
        }
        else if(cmd[0].equalsIgnoreCase("ls")) {
            lsCmd();
        }
        else if(cmd[0].equalsIgnoreCase("exit")){
            System.exit(0);
            return;
        }
        else {
            System.out.println("ERROR: Invalid Command.");
        }
        prompt();
    }
    private void lsCmd() {
        if(cpu.getJobs().size() - 1 == 0) {
            System.out.println("No Jobs Scheduled.");
            return;
        }

        System.out.println("Job Name\tPriority\tLength");
        for(Comparable i : cpu.getJobs()) {
            Job job = (Job) i;
            if(job.isSystem()) continue;
            System.out.println(job.getName() + "\t\t" + job.getPriority() + "\t\t" + job.getLength());
        }
    }
    private void addCmd(String[] cmd) {
        if(cpu.isActive()) {
            System.out.println("ERROR: CPU is busy with another job.");
            prompt();
            return;
        }
        if(cmd.length != 4 || !isInteger(cmd[2]) || !isInteger(cmd[3])) {
            System.out.println("ERROR: Invalid Command. Format: add job_name priority length");
            prompt();
            return;
        }
        cpu.addJob(new Job(cmd[1], Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])));
        System.out.println("SUCCESS: Job added to CPU memory.");
    }
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
           return false;
        }
    }
}
