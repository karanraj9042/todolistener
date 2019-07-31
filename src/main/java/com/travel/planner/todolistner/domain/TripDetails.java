package com.travel.planner.todolistner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "trip")
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class TripDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "trip_id")
    private Long tripId;

    @NotBlank(message = "Task Title can not blank.")
    @Size(max = 100)
    private String tripTitle;

    @NotBlank(message = "StartingPlace can not blank.")
    @Size(max = 100)
    private String startingPlace;

    @NotBlank(message = "DestinationPlace can not blank.")
    @Size(max = 100)
    private String destinationPlace;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    private Boolean completed = false;


    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

//    @OneToMany(
//            mappedBy = "todo",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name="trip_id")
//    private List<TaskTodo> todos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDetails tripDetailsObject = (TripDetails) o;
        return tripId.equals(tripDetailsObject.tripId) &&
                tripTitle.equals(tripDetailsObject.tripTitle) &&
                startingPlace.equals(tripDetailsObject.startingPlace) &&
                destinationPlace.equals(tripDetailsObject.destinationPlace) &&
                startDate.equals(tripDetailsObject.startDate) &&
                endDate.equals(tripDetailsObject.endDate) &&
                completed.equals(tripDetailsObject.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, tripTitle, startingPlace, destinationPlace, startDate, endDate, completed);
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
