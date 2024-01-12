package hiber.dao;


import hiber.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private final SessionFactory sessionFactory;
   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   public User find(String carModel, int carSeries) {
      TypedQuery<Car> findCarQuery = sessionFactory.getCurrentSession().createQuery
                      ("from Car where carModel = :car_model and carSeries = :car_series")
              .setParameter("car_model", carModel)
              .setParameter("car_series", carSeries);
      List<Car> carList = findCarQuery.getResultList();
      if (!carList.isEmpty()) {
         Car car = carList.get(0);
         return listUsers().stream()
                 .filter(user -> user.getCar().equals(car))
                 .findAny()
                 .orElse(null);
      }
      return null;
   }
}