package model;

public class Candidate {
    private int candidateId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate(int candidateId, String firstName, String lastName, String birthDate,
                     String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void displayCandidate() {
        System.out.println("Candidate ID: " + candidateId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Candidate Type: " + candidateType);
    }
}
