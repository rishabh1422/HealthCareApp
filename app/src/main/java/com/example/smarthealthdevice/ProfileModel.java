package com.example.smarthealthdevice;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class ProfileModel
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    public ProfileModel(int id, String contact, String email, String dob, String bloodGroup, String marital_status) {
        this.id = id;
        this.Contact = contact;
        this.Email = email;
        this.Dob = dob;
        this.BloodGroup = bloodGroup;
        this.Marital_status = marital_status;
    }
    @Ignore
    public ProfileModel(String contact, String email, String dob, String bloodGroup, String marital_status) {
        this.Contact = contact;
        this.Email = email;
        this.Dob = dob;
        this.BloodGroup = bloodGroup;
        this.Marital_status = marital_status;
    }
    @ColumnInfo(name = "Contact")
    private String Contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getMarital_status() {
        return Marital_status;
    }

    public void setMarital_status(String marital_status) {
        Marital_status = marital_status;
    }

    @ColumnInfo(name = "Email")
    private String Email;
    @ColumnInfo(name = "Dob")
    private String Dob;
    @ColumnInfo(name = "BloodGroup")
    private String BloodGroup;
    @ColumnInfo(name = "Marital_status")
    private String Marital_status;


}

