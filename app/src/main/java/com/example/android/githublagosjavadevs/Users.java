package com.example.android.githublagosjavadevs;

/**
 * Created by Gabriel Aggrey on 9/16/2017.
 */

public class Users {
    public String avatar_url;       /*"avatar_url"*/
    public String login;            /*"login"*/
    public String html_url;

    public Users(String serverProfilePicUrl, String userName, String dUrl) {
        this.avatar_url = serverProfilePicUrl;
        this.login = userName;
        this.html_url = dUrl;
    }
}