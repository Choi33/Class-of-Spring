package kr.ac.jejunu.userdao;


import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "허지식";
    String password = "1116";

    private static UserDao userDao;

    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao",UserDao.class);
    }
    @Test
    public void testJejuGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    public void testJejuInsert() throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));
        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));

    }

/*    public void testHallaGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        ConnectionMaker connectionMaker=new HallaConnecntionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    public void testHallaInsert() throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        ConnectionMaker connectionMaker=new HallaConnecntionMaker();
        UserDao userDao=new UserDao(connectionMaker);
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));

    }*/
}
