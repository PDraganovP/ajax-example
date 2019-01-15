package app.models;

public class ErrorMessage {
    private String message;

    public ErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
