package bo;

import entity.Candidate;

import java.util.ArrayList;

public class CandidateManager {
    private ArrayList<Candidate> candidates;
    private int lastId;

    public CandidateManager() {
        candidates = new ArrayList<>();
        lastId = 0;
    }

    public void addCandidate(Candidate candidate) {
        candidate.setId(++lastId);
        candidates.add(candidate);
    }

}
