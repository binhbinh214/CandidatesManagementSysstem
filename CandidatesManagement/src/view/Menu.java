package view;

import java.util.List;
import model.Candidate;

public class Menu {

    public void displayCandidateDetails(Candidate candidate) {
        System.out.println("=============================");
        switch (candidate.getCandidateType()) {
            case 0:
                System.out.println("Experience Candidate:");
                break;
            case 1:
                System.out.println("Fresher Candidate:");
                break;
            case 2:
                System.out.println("Intern Candidate:");
                break;
        }
        candidate.displayCandidate();
        System.out.println("=============================");
    }

    public void displaySearchResults(List<Candidate> candidates) {
        System.out.println("Search Results:");
        if (candidates.isEmpty()) {
            System.out.println("No candidates found.");
        } else {
            for (Candidate candidate : candidates) {
                displayCandidateDetails(candidate);
            }
        }
    }
}
