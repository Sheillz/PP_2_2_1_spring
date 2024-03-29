package hiber.service;

import hiber.dao.UserDao;
import hiber.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }

   @Override
   @Transactional(readOnly = true)
   public User find(String carModel, int carSeries) {
      return userDao.find(carModel, carSeries);
   }

}