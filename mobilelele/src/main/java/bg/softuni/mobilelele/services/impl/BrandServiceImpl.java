package bg.softuni.mobilelele.services.impl;

import bg.softuni.mobilelele.model.entities.BaseEntity;
import bg.softuni.mobilelele.model.entities.BrandEntity;
import bg.softuni.mobilelele.reposotories.BrandRepository;
import bg.softuni.mobilelele.services.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrand() {
        if(brandRepository.count() == 0){
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }

    @Override
    public BrandEntity findByName(String name) {
        return brandRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("No brand with name " + name + " found!"));
    }
}
