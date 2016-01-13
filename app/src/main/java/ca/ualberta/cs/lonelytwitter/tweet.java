package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by koukoula on 1/12/16.
 */
public abstract class tweet {
    protected Date date;
    protected String message;
    private boolean isImportant;
    protected List listOfMoods = new ArrayList();

    public tweet(Date date, String message, List listOfMoods) {
        this.date = date;
        this.message = message;
        this.listOfMoods = listOfMoods;
    }


    public tweet(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List getListOfMoods() {
        return listOfMoods;
    }

    public tweet(List listOfMoods) {
        this.listOfMoods = listOfMoods;
    }

    public void setListOfMoods(List listOfMoods) {
        this.listOfMoods = listOfMoods;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }
}
