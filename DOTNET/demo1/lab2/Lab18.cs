using System;
using System.Collections;
  // Inventory item class
    class InventoryItem
    {
        public string ItemName { get; set; }
        public int Quantity { get; set; }

        public void Display()
        {
            Console.WriteLine($"Item: {ItemName}, Quantity: {Quantity}");
        }
    }

    class BoxingUnboxing
    {
        public static void Lab18()
        {
            Console.WriteLine("Pitam Poudel\n");

            //Get user input for item details
            Console.Write("Enter item name: ");
            string itemName = Console.ReadLine();

            Console.Write("Enter item quantity: ");
            int quantity;
            while (!int.TryParse(Console.ReadLine(), out quantity))
            {
                Console.Write("Invalid input. Please enter a valid number: ");
            }

            // Create InventoryItem object
            InventoryItem item = new InventoryItem
            {
                ItemName = itemName,
                Quantity = quantity
            };

            // Display entered item
            Console.WriteLine("\nInitial Item Details:");
            item.Display();

            // Boxing - store quantity in ArrayList
            ArrayList inventoryQuantities = new ArrayList();
            object boxedQuantity = item.Quantity; // boxing
            inventoryQuantities.Add(boxedQuantity);

            Console.WriteLine("Boxed Value (from ArrayList): " + inventoryQuantities[0]);

            //Unboxing - retrieve and cast back to int
            object retrievedObject = inventoryQuantities[0];
            int unboxedQuantity = (int)retrievedObject; // unboxing

            Console.WriteLine("Unboxed quantity back to int: " + unboxedQuantity);

            //Use unboxed value (e.g., add 5 to stock)
            Console.WriteLine("\nAdding 5 to the unboxed quantity to simulate restocking.");
            item.Quantity = unboxedQuantity + 5;

            // Final display
            Console.WriteLine("\nUpdated Item Details:");
            item.Display();
        }
    }

