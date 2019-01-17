package androiddevs.com.retrofitsample.simplegetrequest.responsebeans;

import com.google.gson.annotations.SerializedName;

public class ApiReponseObject {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;

    public ApiReponseObject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ApiReponseObject{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
