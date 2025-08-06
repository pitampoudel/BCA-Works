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

        var connection = new MySqlConnection(builder.ConnectionString);
        connection.Open();

        // CREATE
        var command1 = new MySqlCommand("INSERT INTO users(username,email,password) VALUES('Alice','','')", connection);
        command1.ExecuteNonQuery();

        // READ
        var command2 = new MySqlCommand("SELECT * FROM users", connection);
        var reader = command2.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine(reader.GetString(1));
        }


    }
}
