package model.info;

public class Reviews {
    private String user;
    private String rating;
    private String comment;

    public Reviews(String user, String rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "[user: " + user + ", rating: " + rating + ", comment: " + comment + "]";
    }

    public String getUser() {
        return user;
    }

    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}