package org.aadi.inventory_mgnt.products;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product data model")
record ProductsData(
    @Schema(description = "Unique identifier of the product", example = "1") 
    int id, 

    @Schema(description = "Name of the product", example = "Milk") 
    String name, 

    @Schema(description = "Type of the product", example = "DRINK") 
    ProductType type, 

    @Schema(description = "Price of the product in rupees", example = "100")
    float price
) {
}
