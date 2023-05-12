package cleaning.services.staticdatabas;

import java.util.ArrayList;
import java.util.List;

import model.Worker;

public class AppWorkers {
	
	private static List <Worker> workers=new ArrayList<Worker>();
	
	private AppWorkers() {
	    throw new IllegalStateException("Utility class");
	}
    static 
    {
    	workers.add(new Worker(0,12345,"worker 1","jenin"));
        workers.add(new Worker(1,12345,"worker 2","nablus"));
    }
	public static int getAvailableWorkerId() {
		for (Worker worker:workers) 
		{
			if(worker.isAvailable())
			{
				return worker.getId();
			}
		}
		return -1;
	}

	public static List<Worker> getWorkers() {
		return workers;
	}


        

}
