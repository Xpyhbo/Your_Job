package ua.job.model;

/**
 * Created by vasyl on 12/25/16.
 */
public class ApplicationForm {
    private String fio;
    private String speciality;
    private String experience;
    private String contacts;

    public ApplicationForm(String fio, String speciality, String experience, String contacts) {
        this.fio = fio;
        this.speciality = speciality;
        this.experience = experience;
        this.contacts = contacts;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getFio() {
        return fio;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getExperience() {
        return experience;
    }

    public String getContacts() {
        return contacts;
    }
}
