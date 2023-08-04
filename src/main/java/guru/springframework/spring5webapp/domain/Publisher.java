package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String addresLine1;
    private String city;
    private String state;
    private int zipNumber;

    public Publisher() {
    }

    public Publisher(String addresLine1, String city, String state, int zipNumber) {
        this.addresLine1 = addresLine1;
        this.city = city;
        this.state = state;
        this.zipNumber = zipNumber;
    }

    public String getAddresLine1() {
        return addresLine1;
    }

    public void setAddresLine1(String addresLine1) {
        this.addresLine1 = addresLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipNumber() {
        return zipNumber;
    }

    public void setZipNumber(int zipNumber) {
        this.zipNumber = zipNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return zipNumber == publisher.zipNumber && Objects.equals(id, publisher.id) && Objects.equals(addresLine1, publisher.addresLine1) && Objects.equals(city, publisher.city) && Objects.equals(state, publisher.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addresLine1, city, state, zipNumber);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", addresLine1='" + addresLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipNumber=" + zipNumber +
                '}';
    }
}
