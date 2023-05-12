package cleaning.services.staticdatabase;

import java.util.ArrayList;
import java.util.List;

import model.Worker;

public class Workers {
	
	private static List <Worker> workers=new ArrayList<Worker>();
	
	private Workers() {
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
