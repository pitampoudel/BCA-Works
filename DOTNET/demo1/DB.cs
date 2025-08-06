using System;
using MySql.Data.MySqlClient;

class DBProgram
{
    public static void Execute()
    {
        var builder = new MySqlConnectionStringBuilder
        {
            Server = "localhost",
            UserID = "root",
            Password = "",
            Database = "dotnet_db"
        };

        try
        {
            using var connection = new MySqlConnection(builder.ConnectionString);
            connection.Open();

            string query = "SELECT * FROM users;";
            using var command = new MySqlCommand(query, connection);
            using var reader = command.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine(reader.GetString(1));
            }
        }
        catch (MySqlException e)
        {
            Console.WriteLine($"MySQL Error: {e.Message}");
        }
    }
}
