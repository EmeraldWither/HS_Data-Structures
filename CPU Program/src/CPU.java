/*
 * Ishaan Sayal
 * Period 1
 * 4/18/2024
 */

import java.util.ArrayList;

public class CPU 
{
    private final MinHeap heap = new MinHeap();
    private final CommandHandler handler = new CommandHandler(this);
    public CPU() 
    {
        heap.add(new Job("Free CPU", Integer.MAX_VALUE, 1, true));
    }
    public void run() 
    {
        //grab latest job
        Job job = (Job) heap.peek();
        job.execute();
        if(job.isFinished()) 
        {
            heap.remove();
        }
    }
    public boolean isActive() 
    {
        Job job = ((Job)heap.peek());
        return job.isRunning() && !job.isSystem();
    }

    public void start() 
    {
        handler.start();
    }

    public ArrayList<Comparable> getJobs() 
    {
        return heap.getRawElements();
    }


    public void addJob(Job job) 
    {
        heap.add(job);
    }
}
