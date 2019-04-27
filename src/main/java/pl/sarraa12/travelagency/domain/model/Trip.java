package pl.sarraa12.travelagency.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip extends AbstractEntity {

    @Column(nullable = false)
    private String destinationCity;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime departureDate;
    @Column(nullable = false)
//    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime returnDate;
    @Column(nullable = false)
    private Integer placeLimit;
    @Column(nullable = false)
//    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime bookingDeadline;
    @Column(nullable = false)
    private BigDecimal price;
    // user
//    @ManyToMany(mappedBy = "users")
//    private List<User> users = new ArrayList<>();
//    // opinie
//    @ManyToMany(mappedBy = "opinions")
//    private List<Opinion> opinions = new ArrayList<>();
//    //    hotel
//    @ManyToMany(mappedBy = "opinions")
//    private List<Hotel> hotels = new ArrayList<>();


    public Trip() {
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getPlaceLimit() {
        return placeLimit;
    }

    public void setPlaceLimit(Integer placeLimit) {
        this.placeLimit = placeLimit;
    }

    public LocalDateTime getBookingDeadline() {
        return bookingDeadline;
    }

    public void setBookingDeadline(LocalDateTime bookingDeadline) {
        this.bookingDeadline = bookingDeadline;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

//- skąd
//        - dokąd
//        - zakres ceny
//        - data wyjazdu
//        - liczba osób
//        - wyżywienie
//        - hotel (powinien miec liczbe miejsc i ja zmniejszac)
//        - limit miejsc
//        - data do kiedy można rezerwować wycieczkę
//        - opinie