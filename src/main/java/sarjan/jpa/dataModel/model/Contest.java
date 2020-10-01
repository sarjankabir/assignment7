package sarjan.jpa.dataModel.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Contest entity class
 */

@Entity
public class Contest {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Boolean registrationAllowed;

    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationFrom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationTo;




    /**
     * A contest can have 1 or more teams. The number of teams is declared in the capacity.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Team> teams = new HashSet();

    /**
     * A contest can have multiple managers
     */
    @ManyToMany
    @JoinTable(name = "person_contest",
            joinColumns = { @JoinColumn(name = "Contest_ID", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "Person_ID", referencedColumnName = "ID") })
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Person> managers = new HashSet<>();

    /**
     * A contest can have multiple sub contests
     */
    @OneToMany(mappedBy = "superContest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Contest> subContests = new HashSet<>();

    /**
     * A subcontest can have a super contest.
     */
    @ManyToOne
    @JoinColumn(name  ="superContest_id")
    private Contest superContest;

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getRegistrationAllowed() {
        return registrationAllowed;
    }

    public void setRegistrationAllowed(Boolean registrationAllowed) {
        this.registrationAllowed = registrationAllowed;
    }

    public Date getRegistrationFrom() {
        return registrationFrom;
    }

    public void setRegistrationFrom(Date registrationFrom) {
        this.registrationFrom = registrationFrom;
    }

    public Date getRegistrationTo() {
        return registrationTo;
    }

    public void setRegistrationTo(Date registrationTo) {
        this.registrationTo = registrationTo;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Person> getManagers() {
        return managers;
    }

    public void setManagers(Set<Person> managers) {
        this.managers = managers;
    }

    public Set<Contest> getSubContests() {
        return subContests;
    }

    public void setSubContests(Set<Contest> subContests) {
        this.subContests = subContests;
    }

    public Contest getSuperContest() {
        return superContest;
    }

    public void setSuperContest(Contest superContest) {
        this.superContest = superContest;
    }
}
