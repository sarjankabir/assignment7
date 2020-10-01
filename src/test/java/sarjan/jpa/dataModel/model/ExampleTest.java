package sarjan.jpa.dataModel.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sarjan Kabir
 */

/**
 * Test Class for Contest System
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExampleTest {

    private static final Logger logger = Logger.getLogger(ExampleTest.class.getName());

    @Autowired
    private TestEntityManager entityManager;

    /**
     * Populates the database
     */
    public void populate(){

        Contest contest = new Contest();
        contest.setName("Contest SuperContest");
        contest.setCapacity(10);
        contest.setDate(getDate("2020-10-15"));
        contest.setRegistrationAllowed(true);
        contest.setRegistrationFrom(getDate("2020-09-15"));
        contest.setRegistrationTo(getDate("2020-10-14"));
        System.out.println(contest.getName());

        Contest subContest = new Contest();
        subContest.setName("Contest Subcontest");
        subContest.setCapacity(5);
        subContest.setDate(getDate("2020-09-15"));
        subContest.setRegistrationAllowed(true);
        subContest.setRegistrationFrom(getDate("2020-08-15"));
        subContest.setRegistrationTo(getDate("2020-09-14"));


        // Populate teams
        Set<Team> teams = new HashSet<>();
        Team team = new Team();
        team.setName("Baylor University Team 1");
        team.setRank(4);
        team.setState(team.statePending());

        // Populate 3 Person in team Baylor University Team 1
        Person coach = new Person();
        coach.setName("Michael");
        coach.setEmail("michael@gmail.com");
        coach.setBirthDate(getDate("1991-11-05"));
        coach.setUniversity("Baylor University");
        team.setCoach(coach);
        entityManager.persist(coach);

        Person teamMember1 = new Person();
        teamMember1.setName("John");
        teamMember1.setEmail("balor@email.com");
        teamMember1.setBirthDate(getDate("1993-11-01"));
        teamMember1.setUniversity("Baylor University");
        entityManager.persist(teamMember1);

        Person teamMember2 = new Person();
        teamMember2.setName("Samuel");
        teamMember2.setEmail("baylor@email.com");
        teamMember2.setBirthDate(getDate("1996-11-25"));
        teamMember2.setUniversity("Baylor University");
        entityManager.persist(teamMember2);

        Person teamMember3 = new Person();
        teamMember3.setName("Michelle");
        teamMember3.setEmail("bylor@email.com");
        teamMember3.setBirthDate(getDate("1996-11-05"));
        teamMember3.setUniversity("Baylor University");
        entityManager.persist(teamMember3);

        Set<Person> contestants = new HashSet<>();
        contestants.add(teamMember1);
        contestants.add(teamMember2);
        contestants.add(teamMember3);

        //Adding contestants to team
        team.setMembership(contestants);
        entityManager.persist(team);
        teams.add(team);

        Team team1 = new Team();
        team1.setName("CodeIgniters");
        team1.setRank(1);
        team1.setState(team1.statePending());

        // Populate 3 Person in team CodeIgniters
        Person coach1 = new Person();
        coach1.setName("Rachel");
        coach1.setEmail("rachel@email.com");
        coach1.setBirthDate(getDate("1994-11-11"));
        coach1.setUniversity("CodeIgniters University");
        team1.setCoach(coach1);
        entityManager.persist(coach1);

        Person teamMember4 = new Person();
        teamMember4.setName("Michael");
        teamMember4.setEmail("ucla@email.com");
        teamMember4.setBirthDate(getDate("1994-11-15"));
        teamMember4.setUniversity("CodeIgniters University");
        entityManager.persist(teamMember4);

        Person teamMember5 = new Person();
        teamMember5.setName("Ron");
        teamMember5.setEmail("ula@email.com");
        teamMember5.setBirthDate(getDate("1991-11-15"));
        teamMember5.setUniversity("CodeIgniters University");
        entityManager.persist(teamMember5);

        Person teamMember6 = new Person();
        teamMember6.setName("John");
        teamMember6.setEmail("cla@email.com");
        teamMember6.setBirthDate(getDate("1990-11-10"));
        teamMember6.setUniversity("CodeIgniters University");
        entityManager.persist(teamMember6);

        Set<Person> contestants2 = new HashSet<>();
        contestants2.add(teamMember4);
        contestants2.add(teamMember5);
        contestants2.add(teamMember6);

        team1.setMembership(contestants2);
        entityManager.persist(team1);
        teams.add(team1);


        Team team2 = new Team();
        team2.setName(" #Include");
        team2.setRank(2);
        team2.setState(team2.statePending());

        Person coach2 = new Person();
        coach2.setName("Cooper");
        coach2.setEmail("cooper@email.com");
        coach2.setBirthDate(getDate("1995-11-17"));
        coach2.setUniversity("UT Arlinton");
        team2.setCoach(coach2);
        entityManager.persist(coach2);

        Person teamMember7 = new Person();
        teamMember7.setName("Penny");
        teamMember7.setEmail("lington@email.com");
        teamMember7.setBirthDate(getDate("1994-11-15"));
        teamMember7.setUniversity("UT Arlington");
        entityManager.persist(teamMember7);

        Person teamMember8 = new Person();
        teamMember8.setName("Ron");
        teamMember8.setEmail("arlton@email.com");
        teamMember8.setBirthDate(getDate("1995-11-15"));
        teamMember8.setUniversity("UT Arlington");
        entityManager.persist(teamMember8);

        Person teamMember9 = new Person();
        teamMember9.setName("John");
        teamMember9.setEmail("arl@email.com");
        teamMember9.setBirthDate(getDate("1995-11-19"));
        teamMember9.setUniversity("UT Arlington");
        entityManager.persist(teamMember9);

        Set<Person> contestants3 = new HashSet<>();
        contestants3.add(teamMember7);
        contestants3.add(teamMember8);
        contestants3.add(teamMember9);

        team2.setMembership(contestants3);
        entityManager.persist(team2);
        teams.add(team2);

        subContest.setTeams(teams);
        entityManager.persist(subContest);
        Set<Contest> subcontests = new HashSet<>();
        subcontests.add(subContest);
        contest.setSubContests(subcontests);

        Person manager = new Person();
        manager.setName("Mr Monarch");
        manager.setEmail("aps@email.com");
        manager.setBirthDate(getDate("1990-11-15"));
        manager.setUniversity("Baylor University");
        entityManager.persist(manager);

        Set<Person> managers = new HashSet<>();
        managers.add(manager);
        contest.setManagers(managers);

        entityManager.persist(contest);

    }
    /**
     * Gets the teams for a contest and prints them
     */
    @Test
    public void selectTeamsOfContest(){
        populate();
        Contest contest = (Contest) entityManager.getEntityManager().createQuery("SELECT c FROM Contest c WHERE c.name LIKE 'Contest Subcontest' ").getResultList().get(0);
        System.out.println(contest.getTeams());
        for(Team t : contest.getTeams()){
            System.out.println("Team :"+ t.getName()+" "+t.getState()+" "+t.getRank());
        }
    }

    /**
     * Generates a report of students grouped by their ages.
     */

    @Test
    public void generateStudentsReport(){
        populate();

        List<Team> teams = entityManager.getEntityManager()
                .createQuery("SELECT c FROM Team c ").getResultList();
        Set<Person> students = new HashSet<>();
        for(Team t : teams){
            students.addAll(t.getMembership());
        }
        Map<String,Set<Person>> groupByAge = new HashMap<>();

        for (Person p: students){
            String age = getAge(p.getBirthDate());
            if(groupByAge.containsKey(age)){
                groupByAge.get(age).add(p);
            }else{
                Set<Person> personSet = new HashSet<>();
                personSet.add(p);
                groupByAge.put(age,personSet);
            }
        }

        for(String s : groupByAge.keySet()){
            System.out.print(s+"  ");
            for(Person p : groupByAge.get(s)){
                System.out.print(p.getName()+"  ");
            }
            System.out.println("  ");
        }
    }

    /**
     * Takes date of birth and calculates the age
     * @param dob
     * @return string age
     */

    private String getAge(Date dob) {
        Date today = new Date();
        int age = today.getYear() - dob.getYear();
        int month = today.getMonth() - dob.getMonth();
        if (month < 0 || (month == 0 && today.getDate() < dob.getDate())) {
            age--;
        }
        return String.valueOf(age);
    }

    /**
     * Calculates the current contest occupancy and compare with the capacity of the contest
     */

    @Test
    public void testContestOccupancy(){
        populate();
        Contest contest = (Contest) entityManager.getEntityManager().createQuery(
                "SELECT c FROM Contest c WHERE c.name LIKE 'Contest Subcontest' ").getResultList().get(0);
        int occupancy = contest.getTeams().size();
        int capacity = contest.getCapacity();
        System.out.println(occupancy + " " + capacity);
        assert(occupancy<=capacity);
    }


    /**
     * Takes string date and converts it to yyyy-MM-dd date format.
     * @param s
     * @return date
     */
    private Date getDate(String s) {
        Date date = null;
        try {
            date =  new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            logger.log(Level.WARNING,"Date cannot be created from string",e);
        };
        return date;
    }

}
