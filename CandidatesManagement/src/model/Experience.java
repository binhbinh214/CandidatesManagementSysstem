package model;

public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public Experience(int candidateId, String firstName, String lastName, String birthDate,
            String address, String phone, String email, int candidateType,
            int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    @Override
    public void displayCandidate() {
        super.displayCandidate();
        System.out.println("Years of Experience: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }
}
