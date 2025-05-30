using MySql.Data.MySqlClient;

class DB
{
    private readonly MySqlConnection _connection;

    public DB()
    {
        var builder = new MySqlConnectionStringBuilder
        {
            Server = "localhost",
            UserID = "root",
            Password = "",
            Database = "dotnet_db"
        };
        _connection = new MySqlConnection(builder.ConnectionString);
        _connection.Open();
    }

    public void InsertUser(string username, string email, string password)
    {
        var command = new MySqlCommand($"INSERT INTO users VALUES (NULL,'{username}','{email}','{password}');", _connection);
        command.ExecuteNonQuery();
    }
}
