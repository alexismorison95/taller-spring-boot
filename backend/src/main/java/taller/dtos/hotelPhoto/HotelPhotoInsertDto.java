package taller.dtos.hotelPhoto;

import org.springframework.stereotype.Component;

@Component
public class HotelPhotoInsertDto {

    String url;

    String description;

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
