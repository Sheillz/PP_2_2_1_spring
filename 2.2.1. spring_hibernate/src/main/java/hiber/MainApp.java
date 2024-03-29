package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new Car("GAZ", 66622));
      userService.add(new Car("WAZ", 73432));
      userService.add(new Car("KAMAZ", 1333));
      userService.add(new Car("TAPAZ", 0223));


      List<Car> listCars = userService.listCars();

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", listCars.get(0)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", listCars.get(1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", listCars.get(2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", listCars.get(3)));

      List<User> listUsers = userService.listUsers();
      for (User user : listUsers) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println("...................................................................");
      }
      System.out.println(userService.find( "WAZ",73432));
   }
}