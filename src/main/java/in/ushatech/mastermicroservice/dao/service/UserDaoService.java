package in.ushatech.mastermicroservice.dao.service;

import in.ushatech.mastermicroservice.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService
{
    private static List<User> users = new ArrayList<>();
    private static int userCount=0;
    static
    {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User save(User user)
    {
        user.setUserId(++userCount);
        users.add(user);
        return user;
    }
    public User findOne(int id)
    {
        Predicate<? super User> predicate = user -> user.getUserId().equals(id);
        return  users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(int id)
    {
        boolean result = users.removeIf(user-> user.getUserId().equals(id));

    }
}
