package taller.destination.application.dtos;

import org.springframework.stereotype.Component;

@Component
public class DestinationInsertDto {

    String name;

    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
