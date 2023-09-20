package model;

public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int candidateId, String firstName, String lastName, String birthDate,
            String address, String phone, String email, int candidateType,
            String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public void displayCandidate() {
        super.displayCandidate();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("University: " + education);
    }
}
