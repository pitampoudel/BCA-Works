using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace aspdotnet.Pages;

public class SignupModel(ILogger<SignupModel> logger) : PageModel
{
    private readonly ILogger<SignupModel> _logger = logger;

    [BindProperty]
    public string? Username { get; set; }
    [BindProperty]
    public string? Email { get; set; }
    [BindProperty]
    public string? Password { get; set; }

    public void OnGet()
    {
        _logger.LogInformation("Signup page accessed.");

    }
    public void OnPost()
    {
        _logger.LogInformation("Form submitted");
        if (ModelState.IsValid)
        {
            _logger.LogInformation($"User signing up up with Username: {Username}, Email: {Email}");

            var db = new DB();
            db.InsertUser(Username, Email, Password);

            // Redirect to a success page or show a success message
            RedirectToPage("Success");
        }
        else
        {
            _logger.LogWarning("Signup form is invalid.");
        }
    }
}

