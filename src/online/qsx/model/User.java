package online.qsx.model;

/**
 * 
 */
public class User {

    private String username;

    private String age;

    private String hobby;

    private String position;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User(String username, String age, String hobby, String position) {
        this.username = username;
        this.age = age;
        this.hobby = hobby;
        this.position = position;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
