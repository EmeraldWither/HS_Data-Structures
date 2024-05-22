/*
 * Ishaan Sayal
 * Period 1
 * 4/18/2024
 */

public class Job implements Comparable 
{
    private String name;
    private int priority;
    private int length;
    private boolean system = false;

    private boolean started = false;
    public Job(String name, int priority, int length)
    {
        this.name = name;
        this.priority = priority;
        this.length = length;
    }
    
    public Job(String name, int priority, int length, boolean system)
    {
        this.name = name;
        this.priority = priority;
        this.length = length;
        this.system = system;
    }

    @Override
    public int compareTo(Object o) 
    {
        return this.priority - ((Job) o).priority;
    }

    public void execute() 
    {
        started = true;
        if(system) 
        {
            System.out.println("Ran Free CPU.");
            return;
        }
        String finishStr = length - 1 == 0 ? "Job " + name + " has fully finished." : "Job " + name + " has " + (length - 1) + " cycle(s) left.";
        Utils.loadingAnimation("Executing " + name, finishStr,  3);
        length--;
    }
    public boolean isRunning() 
    {
        return !isFinished() && started;
    }

    public boolean isFinished() 
    {
       return length <= 0 && !system && started;
    }

    public boolean isSystem() 
    {
        return this.system;
    }

    public String getName() 
    {
        return name;
    }

    public int getPriority() 
    {
        return this.priority;
    }
    
    public int getLength() 
    {
        return this.length;
    }
}
