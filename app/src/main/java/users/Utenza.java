package users;

/**
 * Created by gcioffi on 14/09/2016.
 */
public class Utenza {

    private String email;
    private String password;

    public Utenza(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utenza utenze = (Utenza) o;

        if (email != null ? !email.equals(utenze.email) : utenze.email != null) return false;
        return password != null ? password.equals(utenze.password) : utenze.password == null;

    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
