package model;

public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Intern(int candidateId, String firstName, String lastName, String birthDate,
            String address, String phone, String email, int candidateType,
            String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public void displayCandidate() {
        super.displayCandidate();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
