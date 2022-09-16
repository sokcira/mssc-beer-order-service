package guru.sfg.beer.order.service.services.beer;

import guru.sfg.beer.order.service.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.brewery",ignoreUnknownFields = false)
@Service
public class BeerServiceImplRestTemplate implements BeerService{
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String BEER_UPC_PATH_V1 = "/api/v1/beerUpc/";
    private final RestTemplate restTemplate;

    private String beerServiceHost;


    public BeerServiceImplRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID uuid) {
        return Optional.of(
                restTemplate.getForObject(beerServiceHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class));

    }

    @Override
    public Optional<BeerDto> getBeerUpc(String upc) {
        return Optional.of(
                restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH_V1 + upc, BeerDto.class));
    }
}
