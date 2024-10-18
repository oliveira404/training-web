package br.com.treinaweb.ediaristas.api.dtos.responses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;
import lombok.Data;

@Data
public class HateaosResponse {

    private List<LinkResponse> links;

    public HateaosResponse() {
        links = new ArrayList<>();
    }

    public void adicionarLinks(Link... links) {
        for (Link link : links) {
            var linkResponse = new LinkResponse();
            linkResponse.setUri(link.getHref());
            linkResponse.setType(link.getType());
            linkResponse.setRel(link.getRel().value());
            
            this.links.add(linkResponse);
        }
    }
    
}
