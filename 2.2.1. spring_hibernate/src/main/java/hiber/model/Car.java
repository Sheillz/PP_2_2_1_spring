package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_series")
    private int carSeries;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.carModel = model;
        this.carSeries = series;
    }

    public Long getId() {
        return carId;
    }

    public void setId(Long id) {
        this.carId = id;
    }

    public String getModel() {
        return carModel;
    }

    public void setModel(String model) {
        this.carModel = model;
    }

    public int getSeries() {
        return carSeries;
    }

    public void setSeries(int series) {
        this.carSeries = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getmodel() {
        return carModel;
    }

    public int getseries() {
        return carSeries;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return carSeries == car.carSeries && Objects.equals(carId, car.carId) && Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carModel, carSeries);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carSeries=" + carSeries +
                '}';
    }
}