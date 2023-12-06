package bo;

import entity.Worker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerManager {
    private List<Worker> workers;

    public WorkerManager() {
        workers = new ArrayList<>();
    }

    private int searchById(int id) {
        if (workers.isEmpty())
            return -1;

        for (int index = 0; index < workers.size(); index++) {
            if(workers.get(index).getId() == id)
                return index;
        }

        return -1;
    }

    public boolean addWorker(Worker worker) throws Exception {
        int index = searchById(worker.getId());

        if (index == -1)
            return workers.add(worker);

        throw new Exception("Worker code already exits!");
    }

    public Set<Integer> getCodeSet() {
        Set<Integer> set = new HashSet<>();
        for (Worker worker : workers){
            set.add(worker.getId());
        }

        return set;
    }
}
