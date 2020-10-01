package sarjan.jpa.dataModel.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Team entity class
 */

@Entity
public class Team {

    private enum State {
        ACCEPTED, PENDING, CANCELLED;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int rank;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    /**
     * MAny teams can be under a contest.
     */
    @ManyToOne
    @JoinColumn(name = "fk_Contest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Contest contest;

    /**
     * A team can have 3 members.
     */

    @ManyToMany
    @JoinTable(name = "person_team",
            joinColumns = { @JoinColumn(name = "Team_ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "Person_ID", referencedColumnName = "ID") })
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Person> membership = new HashSet<>();

    /**
     * A Team has 1 coach.
     */

    @ManyToOne
    @JoinColumn(name = "fk__Person")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Person coach;


    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }


    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    public State stateAccepted(){
        return State.ACCEPTED;
    }

    public State statePending(){
        return State.PENDING;
    }

    public State stateCanceled(){
        return State.CANCELLED;
    }

    public Set<Person> getMembership() {
        return membership;
    }

    public void setMembership(Set<Person> membership) {
        this.membership = membership;
    }
}
