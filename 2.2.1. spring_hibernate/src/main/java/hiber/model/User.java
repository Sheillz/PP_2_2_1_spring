package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
   @OneToOne
   private Car car;
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "user_id")
   private Long userId;

   @Column(name = "fast_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "user_email")
   private String userEmail;

   public User() {
   }

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.userEmail = email;
      this.car = car;
   }

   public Long getId() {
      return userId;
   }

   public void setId(Long id) {
      this.userId = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return userEmail;
   }

   public void setEmail(String email) {
      this.userEmail = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar() {
      this.car = car;
   }

   @Override
   public String toString() {
      return "User{" +
              " " + car +
              ", userId=" + userId +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", userEmail='" + userEmail + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object object) {
      if (this == object) return true;
      if (object == null || getClass() != object.getClass()) return false;
      User user = (User) object;
      return Objects.equals(car, user.car) && Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userEmail, user.userEmail);
   }

   @Override
   public int hashCode() {
      return Objects.hash(car, userId, firstName, lastName, userEmail);
   }
}