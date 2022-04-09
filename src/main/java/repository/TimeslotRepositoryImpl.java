/*
 *  Name: Siphiwe Edson Chauque
 *  Student Number: 219084777
 *  Group: 26
 *
 */

package repository;
import entity.Timeslot;
import entity.Booking;

import java.util.HashSet;
import java.util.Set;

public class TimeslotRepositoryImpl implements ITimeslotRepository {
    private static TimeslotRepositoryImpl repository = null;
    private Set<Timeslot> TimeslotDB;
    private Timeslot timeslot;
    private Object Time;

    private TimeslotRepositoryImpl(){
        this.TimeslotDB = new HashSet<>();
    }

    public static TimeslotRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new TimeslotRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Timeslot create(Timeslot timeslot) {
        this.timeslot = timeslot;
        this.TimeslotDB.add(timeslot);
        return timeslot;
    }

    @Override
    public Booking read(String id) {
        return null;
    }


    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Timeslot update(Timeslot timeslot) {
        Booking Tim1 = read(Timeslot.getIsAvailable());
        if (Tim1 != null){
            TimeslotDB.remove(Tim1);
            Timeslot Timeslot = null;
            TimeslotDB.add(null);
            return timeslot;
        }
        return null;
    }


    public boolean delete(double Time) {
        Booking deleteTimeslot = read(String.valueOf((Time)));
        if (deleteTimeslot== null) {
            System.out.println("Timeslot is null");
            return false;
        }

        TimeslotDB.remove(deleteTimeslot);
        System.out.println("Timeslot is removed");
        return true;
    }

    @Override
    public Set<Timeslot> getAll() {
        return TimeslotDB;
    }
}
