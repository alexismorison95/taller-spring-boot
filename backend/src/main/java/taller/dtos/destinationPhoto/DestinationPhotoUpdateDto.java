package taller.dtos.destinationPhoto;

import org.springframework.stereotype.Component;

@Component
public class DestinationPhotoUpdateDto {

    Integer id;

    String url;

    String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
