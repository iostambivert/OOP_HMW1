package homeworks.hw1.scooter;

import java.util.concurrent.TimeUnit;


public class ScooterRentalTester {
    public static void main(String[] args) {
        // Create a new rental company.
        RentalCompany company = new RentalCompany();

        // Create the scooters.
        Scooter scooter1 = new Scooter();
        scooter1.setModel("Segway Ninebot MAX Scooter 1");
        scooter1.setBatteryLevel(100);
        scooter1.setX(0);
        scooter1.setY(0);

        Scooter scooter2 = new Scooter();
        scooter2.setModel("Segway Ninebot MAX Scooter 2");
        scooter2.setBatteryLevel(100);
        scooter2.setX(0);
        scooter2.setY(0);

        // Add the scooters to the company.
        company.addScooter(scooter1);
        company.addScooter(scooter2);

        // Rent the fist scooter.
        company.rentScooter(scooter1.getId());

        // Go to the university at https://www.google.com/maps/@41.725363,44.775328.
        scooter1.travelTo(41.725363, 44.775328);

        // Check the scooter info after going to the university.
        System.out.println(scooter1);

        // Return the scooter after going to uni.
        company.returnScooter(scooter1.getId(), 41.725363, 44.775328);

        // Check the scooter info after returning.
        System.out.println(scooter1);

        // Wait for 1 hour.
        try {
            TimeUnit.SECONDS.sleep(1); // Sleep for 1 second. Let's pretend this is 1 hour.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rent scooter again after 1 hour.
        company.rentScooter(scooter1.getId());

        // Go home at https://www.google.com/maps/@41.7145587,44.8032225.
        scooter1.travelTo(41.7145587, 44.8032225);

        // Check the scooter info after going home.
        System.out.println(scooter1);

        // Return the scooter after going home.
        company.returnScooter(scooter1.getId(), 41.7145587, 44.8032225);
    }
}
