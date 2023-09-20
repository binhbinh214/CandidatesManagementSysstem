package controller;

import model.Candidate;
import view.Menu;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import model.Experience;
import model.Fresher;
import model.Intern;

public class CandidateManagement {

    private Menu view;
    private List<Candidate> candidates;

    public CandidateManagement() {
        view = new Menu();
        candidates = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    createExperienceCandidate(scanner);
                    break;
                case 2:
                    createFresherCandidate(scanner);
                    break;
                case 3:
                    createInternCandidate(scanner);
                    break;
                case 4:
                    searchCandidates(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option (1-5).");
            }
        }
    }
    private int candidateIdCounter = 1; // Initialize the candidate ID counter
    private int candidateId() {
        return candidateIdCounter++;
    }

    private void createExperienceCandidate(Scanner scanner) {
        System.out.println("Creating Experience Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = getValidPhone(scanner);
        String email = getValidEmail(scanner);
        int candidateType = 0; // Experience Candidate

        System.out.print("Enter Years of Experience: ");
        int expInYear = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Professional Skill: ");
        String proSkill = scanner.nextLine();

        Experience experienceCandidate = new Experience(
                candidateId(), firstName, lastName, birthDate, address, phone, email, candidateType,
                expInYear, proSkill);
        candidates.add(experienceCandidate);

        System.out.println("Experience Candidate created successfully.");
        view.displayCandidateDetails(experienceCandidate);
    }

    private void createFresherCandidate(Scanner scanner) {
        System.out.println("Creating Fresher Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = getValidPhone(scanner);
        String email = getValidEmail(scanner);
        int candidateType = 1; // Fresher Candidate

        System.out.print("Enter Graduation Date: ");
        String graduationDate = scanner.nextLine();
        String graduationRank = getValidGraduationRank(scanner);
        System.out.print("Enter University: ");
        String education = scanner.nextLine();

        Fresher fresherCandidate = new Fresher(
                candidateId(), firstName, lastName, birthDate, address, phone, email, candidateType,
                graduationDate, graduationRank, education);
        candidates.add(fresherCandidate);

        System.out.println("Fresher Candidate created successfully.");
        view.displayCandidateDetails(fresherCandidate);
    }

    private void createInternCandidate(Scanner scanner) {
        System.out.println("Creating Intern Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = getValidPhone(scanner);
        String email = getValidEmail(scanner);
        int candidateType = 2; // Intern Candidate

        System.out.print("Enter Majors: ");
        String majors = scanner.nextLine();
        System.out.print("Enter Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter University Name: ");
        String universityName = scanner.nextLine();

        Intern internCandidate = new Intern(
                candidateId(), firstName, lastName, birthDate, address, phone, email, candidateType,
                majors, semester, universityName);
        candidates.add(internCandidate);

        System.out.println("Intern Candidate created successfully.");
        view.displayCandidateDetails(internCandidate);
    }

    private void searchCandidates(Scanner scanner) {
        System.out.println("Searching for Candidates");
        System.out.print("Enter Candidate name (First name or Last name): ");
        String searchName = scanner.nextLine();
        System.out.print("Enter type of candidate (0 for Experience, 1 for Fresher, 2 for Intern): ");
        int searchType = scanner.nextInt();

        List<Candidate> searchResults = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().toLowerCase().contains(searchName.toLowerCase())
                    || candidate.getLastName().toLowerCase().contains(searchName.toLowerCase()))
                    && candidate.getCandidateType() == searchType) {
                searchResults.add(candidate);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No candidates found.");
        } else {
            System.out.println("The candidates found:");
            view.displaySearchResults(searchResults);
        }
    }
// Function to get a valid birth date in the format (1900..Current Year)

    private String getValidBirthDate(Scanner scanner) {
        String birthDatePattern = "^(19[0-9][0-9]|20[0-9][0-9])$";
        String birthDate;

        while (true) {
            System.out.print("Enter Birth Date (YYYY): ");
            birthDate = scanner.nextLine();

            if (birthDate.matches(birthDatePattern)) {
                int year = Integer.parseInt(birthDate);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);

                if (year >= 1900 && year <= currentYear) {
                    break;
                }
            }
            System.out.println("Invalid birth date format. Please enter a valid year (1900.." + Calendar.getInstance().get(Calendar.YEAR) + ").");
        }

        return birthDate;
    }

// Function to get a valid phone number with a minimum of 10 digits
    private String getValidPhone(Scanner scanner) {
        String phonePattern = "^[0-9]{10,}$";
        String phone;

        while (true) {
            System.out.print("Enter Phone Number (at least 10 digits): ");
            phone = scanner.nextLine();

            if (phone.matches(phonePattern)) {
                break;
            }
            System.out.println("Invalid phone number format. Please enter at least 10 digits.");
        }

        return phone;
    }

// Function to get a valid email address
    private String getValidEmail(Scanner scanner) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        String email;

        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();

            if (email.matches(emailPattern)) {
                break;
            }
            System.out.println("Invalid email format. Please enter a valid email address.");
        }

        return email;
    }

// Function to get a valid graduation rank (Excellence/Good/Fair/Poor)
    private String getValidGraduationRank(Scanner scanner) {
        String[] validRanks = {"Excellence", "Good", "Fair", "Poor"};
        String graduationRank;

        while (true) {
            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            graduationRank = scanner.nextLine();

            for (String rank : validRanks) {
                if (graduationRank.equalsIgnoreCase(rank)) {
                    return graduationRank;
                }
            }
            System.out.println("Invalid graduation rank. Please enter one of the following: Excellence/Good/Fair/Poor.");
        }
    }

    public static void main(String[] args) {
        CandidateManagement controller = new CandidateManagement();
        controller.start();
    }
}
