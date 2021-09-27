package bg.softuni.mobilelele.services;

import bg.softuni.mobilelele.model.entities.BrandEntity;



public interface BrandService {

    void initializeBrand();

    BrandEntity findByName(String name);
}
