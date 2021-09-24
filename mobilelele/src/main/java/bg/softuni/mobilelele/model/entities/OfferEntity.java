package bg.softuni.mobilelele.model.entities;

import bg.softuni.mobilelele.model.entities.enums.EngineEnum;
import bg.softuni.mobilelele.model.entities.enums.TransmissionEnum;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    /*.
 created – a date and time.
 modified – a date and time.
 model – the model of a car.
 seller – a user that sells the car.
     */
    @Column(columnDefinition = "Text")
    private String description;
    @Enumerated(STRING)
    @Column(nullable = false)
    private EngineEnum engine;
    @Column
    private String imageUrl;
    @Column(nullable = false)
    private Integer mileage;
    @Column()
    private BigDecimal price;
    @Enumerated(STRING)
    @Column(nullable = false)
    private TransmissionEnum transmission;
    @Column
    private int year;
    @OneToOne
    private ModelEntity module;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity  setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModule() {
        return module;
    }

    public OfferEntity setModule(ModelEntity module) {
        this.module = module;
        return this;
    }
}
