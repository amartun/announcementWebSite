package models;

import java.util.Date;

public class Announcement {
    protected int id;
    protected String announcement_title;
    protected String announcement_description;
    protected String announcement_date;


    public Announcement(int id, String announcement_title, String announcement_description, String announcement_date) {
        this.id = id;
        this.announcement_title = announcement_title;
        this.announcement_description = announcement_description;
        this.announcement_date = announcement_date;
    }

    public String getAnnouncement_date() {
        return announcement_date;
    }

    public String getAnnouncement_description() {
        return announcement_description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnnouncement_title(String announcement_title) {
        this.announcement_title = announcement_title;
    }

    public void setAnnouncement_description(String announcement_description) {
        this.announcement_description = announcement_description;
    }

    public String getAnnouncement_title() {
        return announcement_title;
    }


    public int getId() {
        return id;
    }

    public Announcement(int id){
        this.id = id;
    }
    public Announcement(String announcement_title, String announcement_description) {
        this.announcement_title = announcement_title;
        this.announcement_description = announcement_description;

    }

    public Announcement(int id, String announcement_title, String announcement_description) {
        this.id = id;
        this.announcement_title = announcement_title;
        this.announcement_description = announcement_description;
    }

}
