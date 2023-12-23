package dimacm14.api.modeles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategorySearchResponseModel {
    @JsonProperty("Items")
    ProductResponseModel[] items;
}
