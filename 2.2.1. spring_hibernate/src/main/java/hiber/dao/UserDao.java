package hiber.dao;

import hiber.model.*;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void add(Car car);

   List<Car> listCars();

   User find(String carModel, int carSeries);
}