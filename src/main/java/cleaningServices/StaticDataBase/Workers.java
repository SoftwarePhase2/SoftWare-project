package cleaningServices.StaticDataBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Product;
import model.Worker;

public class Workers {
	private static List <Worker> workers=new ArrayList<Worker>(){{
        add(new Worker(0,12345,"worker 1","jenin"));
        add(new Worker(1,12345,"worker 2","jenin"));
        }};

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
	};


        

}
