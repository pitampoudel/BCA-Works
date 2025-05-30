using System;
using System.Drawing;
using System.Windows.Forms;


class DotNetUI : Form
{
    public delegate void DelEventHandler();

    public event DelEventHandler? Add;

    public DotNetUI()
    {
        Button btn = new()
        {
            Parent = this,
            Text = "Hit Me",
            Location = new Point(100, 100)
        };

        btn.Click += new EventHandler((sender, e) =>
    {
        MessageBox.Show("You clicked me");
    });
        Add += new DelEventHandler(Initiate);

        // Fire the custom event
        Add?.Invoke();
    }

    public void Initiate()
    {
        Console.WriteLine("Event Initiated");
    }



    [STAThread]
    public static void Execute()
    {
        Application.EnableVisualStyles();
        Application.Run(new DotNetUI());
    }
}
