package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() >= boat.getMaxPassengers()) {
            throw new IllegalArgumentException("No more place!");
        }
        passengers.add(passenger);
    }


    public double getPriceForPassenger(Passenger passenger) {
        double priceForPassenger = passenger.getCruiseClass().getMultiplier() * basicPrice;
        return priceForPassenger;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("Not found: " + name);
    }


    public List<String> getPassengerNamesOrdered() {
        List<String> nameList = new ArrayList<>();
        for (Passenger passenger : passengers) {
            nameList.add(passenger.getName());
            Collections.sort(nameList, Collator.getInstance(new Locale("hu", "HU")));
        }
        return nameList;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger : passengers) {
            // sum += passenger.getCruiseClass().getMultiplier()* getBasicPrice();
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> passengersByClass = new HashMap<>();
        for (Passenger passenger : passengers) {
            if (passengersByClass.containsKey(passenger.getCruiseClass())) {
                passengersByClass.put(passenger.getCruiseClass(), passengersByClass.get(passenger.getCruiseClass()) + 1);
            } else {
                passengersByClass.put(passenger.getCruiseClass(), 1);

            }
        }
        return passengersByClass;
    }
}
