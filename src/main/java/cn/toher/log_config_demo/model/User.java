package cn.toher.log_config_demo.model;

/**
 * Created with Chenquan.
 * Description:
 * Date: 2018-06-14
 * Time: 13:24
 */
public class User {
    private int id;
    private int age;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}
