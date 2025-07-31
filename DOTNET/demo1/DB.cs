using MySql.Data.MySqlClient;

class DBProgram
{
    public static  async Task Execute()
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
            await using var connection = new MySqlConnection(builder.ConnectionString);
            Console.WriteLine("\nMYSQL CONNECTION:");
            Console.WriteLine("=========================================" + "\n");

            await connection.OpenAsync();

            // await using var command = new MySqlCommand("INSERT into test_db VALUES (1,2,3,4);", connection);
            await using var command = new MySqlCommand("SELECT * FROM test_db;", connection);

            await using var reader = await command.ExecuteReaderAsync();

            while (await reader.ReadAsync())
            {
                Console.WriteLine(reader.GetString(0));
            }
        }
        catch (MySqlException e)
        {
            Console.WriteLine($"MySQL Error: {e.Message}");
        }

        Console.WriteLine("\nDone. Press enter.");
        Console.ReadLine();
    }
}
