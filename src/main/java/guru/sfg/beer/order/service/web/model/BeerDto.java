package guru.sfg.beer.order.service.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {

    private static final long serialVersionUUID = 1114717885687647657L;

    @Null
    private UUID id;

    @Null
    private Integer version;

    // in beer entity class we use different data type -> Timestamp from sql.Timestamp package and with mapstruct this will
    // give an error or problem therefore we can fix this with -> see DateMapper class in mappers package!!

    // Tip: OffsetDateTime is a good choise to use for public facing interfaces

    @Null
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;

    @NotNull
    private String beerStyle;

    @Positive
    @NotNull
    private String upc;

    @Positive
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    private Integer quantityOnHand;
}
