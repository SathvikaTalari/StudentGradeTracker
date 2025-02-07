import java.util.*;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean isAvailable;

    Room(int number, String type, double cost) {
        roomNumber = number;
        category = type;
        price = cost;
        isAvailable = true;
    }
}

class Reservation {
    int id;
    Room room;
    String guest;
    int days;
    double amount;
    boolean paid;

    Reservation(int rid, Room r, String g, int n) {
        id = rid;
        room = r;
        guest = g;
        days = n;
        amount = r.price * n;
        paid = false;
        r.isAvailable = false;
    }

    void pay() {
        paid = true;
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    int resCounter = 1;

    void addRoom(Room r) {
        rooms.add(r);
    }

    Room searchRoom(String type) {
        for (Room r : rooms) {
            if (r.isAvailable && r.category.equalsIgnoreCase(type)) {
                return r;
            }
        }
        return null;
    }

    Reservation bookRoom(String name, String type, int days) {
        Room r = searchRoom(type);
        if (r != null) {
            Reservation res = new Reservation(resCounter++, r, name, days);
            reservations.add(res);
            return res;
        }
        return null;
    }

    Reservation getReservation(int id) {
        for (Reservation r : reservations) {
            if (r.id == id) {
                return r;
            }
        }
        return null;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(101, "Single", 100));
        hotel.addRoom(new Room(102, "Double", 150));
        hotel.addRoom(new Room(103, "Luxury", 250));

        while (true) {
            System.out.println("\n1. Search Room\n2. Book Room\n3. Pay for Booking\n4. Exit");
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter room type: ");
                    String type = input.nextLine();
                    Room room = hotel.searchRoom(type);
                    if (room != null) {
                        System.out.println("Room available: " + room.roomNumber);
                    } else {
                        System.out.println("No rooms available.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();
                    System.out.print("Enter room type: ");
                    type = input.nextLine();
                    System.out.print("Enter number of days: ");
                    int days = input.nextInt();
                    Reservation res = hotel.bookRoom(name, type, days);
                    if (res != null) {
                        System.out.println("Booking successful! ID: " + res.id + " | Amount: $" + res.amount);
                    } else {
                        System.out.println("No rooms available.");
                    }
                    break;
                case 3:
                    System.out.print("Enter booking ID: ");
                    int resId = input.nextInt();
                    Reservation reservation = hotel.getReservation(resId);
                    if (reservation != null && !reservation.paid) {
                        reservation.pay();
                        System.out.println("Payment successful for Booking ID: " + resId);
                    } else {
                        System.out.println("Invalid booking ID or already paid.");
                    }
                    break;
                case 4:
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
