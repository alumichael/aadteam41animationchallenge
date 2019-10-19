package com.team41.aad_team_41_animation_challenge.model;

/**
 * Created by Michael on 10/18/2019.
 */
public class teamModel {

    //Here is our Model Class for for our records


    public String name;
    private String email;
    private String gender;
    private String phone_num;
    private String status;
    private String img;

    public teamModel(String name, String email, String gender, String phone_num,String status,String img) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone_num = phone_num;
        this.status = status;
        this.img = img;
    }

    /*
    * Please Note we don't really need set function here,
     * i only include it in case any body need it
     *
     */

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
