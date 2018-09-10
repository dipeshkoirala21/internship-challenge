package com.example.dipes.internshipchallenge;

import java.util.ArrayList;
import java.util.List;

public class PostData {
    public String userId;
    public String title;
    public String body;
    public String id;

    public List<id> ID=new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<id> getID() {
        return ID;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setID(List<id> ID) {
        this.ID = ID;
    }
    public class id{
        public String postId;
        public String id;
        public String name;
        public String email;
        public String body;

        public String getPostId() {
            return postId;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getBody() {
            return body;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
