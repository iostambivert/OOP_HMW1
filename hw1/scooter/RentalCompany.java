package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;



public class RentalCompany {


    private int uid = 0; // we will use this to id scooters

    List<Scooter> scooters = new ArrayList<>(); // creates new arraylist scooters of type Scooter
    private Scooter scooter;

    // the list of all available scooters
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) { //stands for operating over each scooter instance in scooters list
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    //adds scooter to the scooters list
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    //removes a scooter by id
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    // function to rent a scooter
    public boolean rentScooter(int id) {
        boolean rented = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                rented = true;
                scooter.setAvailable(false);
                break;
            }
        }
        return rented;
    }

    // function to call when user returns a rented scooter
    public boolean returnScooter(int id, double x, double y) {
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id && scooter.isAvailable() == false) {
                scooter.setAvailable(true);
                scooter.setY(y);
                scooter.setX(x);
                break;
            }
        }
        return scooter.isAvailable();
    }
    public void displayAllScooters() {
        if (scooters.isEmpty()) {
            System.out.println("No scooters available.");
        } else {
            System.out.println("List of all scooters:");
            for (Scooter scooter : scooters) {
                System.out.println(scooter.toString());
            }
        }
    }
}


