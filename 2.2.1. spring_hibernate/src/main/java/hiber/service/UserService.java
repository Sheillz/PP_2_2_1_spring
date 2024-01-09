package hiber.service;



import hiber.model.*;


import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void add(Car car);

    List<Car> listCars();

    User find(String model, int series);
}