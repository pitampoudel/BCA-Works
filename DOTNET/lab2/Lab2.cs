using System;

class HotelRoom
{
    public int roomNumber;
    public string guestName;
    public int numberOfNights;

    // Constructor to initialize booking details
    public HotelRoom(int roomNumber, string guestName, int numberOfNights)
    {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
        Console.WriteLine("\n Constructor has been called and fields has been initialized!");
    }

    public void DisplayBookingDetails()
    {
        Console.WriteLine("Booking Details:");
        Console.WriteLine($"Guest Name     : {guestName}");
        Console.WriteLine($"Room Number    : {roomNumber}");
        Console.WriteLine($"Nights Booked  : {numberOfNights}");
    }

    // Destructor to show message when object is destroyed
    ~HotelRoom()
    {
        Console.WriteLine("Booking has ended (Destructor called).");
    }

    public static void Invoke()
    {
        Console.WriteLine("=== Hotel Room Booking System ===\n");

        Console.Write("Enter guest name: ");
        string name = Console.ReadLine();

        Console.Write("Enter room number: ");
        int room = int.Parse(Console.ReadLine());

        Console.Write("Enter number of nights: ");
        int nights = int.Parse(Console.ReadLine());

        // Creating a HotelRoom object with user input
        HotelRoom hotelRoom = new HotelRoom(room, name, nights);
        hotelRoom.DisplayBookingDetails();
    }
}