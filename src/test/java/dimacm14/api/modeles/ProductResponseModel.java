package dimacm14.api.modeles;

import lombok.Data;

@Data
public class ProductResponseModel {
    String cat;
    String desc;
    String id;
    String img;
    Double price;
    String title;
}
