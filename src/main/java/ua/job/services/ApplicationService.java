package ua.job.services;



import ua.job.model.ApplicationForm;

import java.util.ArrayList;

/**
 * Created by vasyl on 12/25/16.
 */
public class ApplicationService {
    private static final ApplicationService instance = new ApplicationService();
    private ArrayList<ApplicationForm> applicationForms = new ArrayList<ApplicationForm>();

    private ApplicationService(){ }

    public static ApplicationService getInstance() {
        return instance;
    }

    public ArrayList<ApplicationForm> getAll(){
        return applicationForms;
    }

    public void add(ApplicationForm applicationForm) {
        this.applicationForms.add(applicationForm);
    }
}
