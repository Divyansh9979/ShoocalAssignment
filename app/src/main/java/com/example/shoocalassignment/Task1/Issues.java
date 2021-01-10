package com.example.shoocalassignment.Task1;

public class Issues {
    private String login;
    private String id;
    private String repository_url;
    private String status;

    public Issues(String login, String id, String repository_url, String status) {
        this.login = login;
        this.id = id;
        this.repository_url = repository_url;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public String getStatus() {
        return status;
    }
}
