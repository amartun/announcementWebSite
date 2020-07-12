package models;

public class Announcement {
    protected int id;
    protected String announcement_title;
    protected String announcemnt_description;

    public void setId(int id) {
        this.id = id;
    }

    public void setAnnouncement_title(String announcement_title) {
        this.announcement_title = announcement_title;
    }

    public void setAnnouncemnt_description(String announcemnt_description) {
        this.announcemnt_description = announcemnt_description;
    }

    public String getAnnouncement_title() {
        return announcement_title;
    }

    public String getAnnouncemnt_description() {
        return announcemnt_description;
    }

    public int getId() {
        return id;
    }

    public Announcement(int id){
        this.id = id;
    }
    public Announcement(String announcement_title, String announcemnt_description) {
        this.announcement_title = announcement_title;
        this.announcemnt_description = announcemnt_description;

    }

    public Announcement(int id, String announcement_title, String announcemnt_description) {
        this.id = id;
        this.announcement_title = announcement_title;
        this.announcemnt_description = announcemnt_description;
    }

}
