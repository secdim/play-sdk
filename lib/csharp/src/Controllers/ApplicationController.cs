using Microsoft.AspNetCore.Mvc;

[ApiController]
public class ApplicationController : ControllerBase
{
    [HttpGet("/v1.0/health")]
    public IActionResult Health()
    {
        return Ok(new { message = "ok" });
    }

    [HttpGet("/v1.0/home/{name}")]
    public IActionResult Home(string name)
    {
        return Ok("Your name is "+name);
    }
}
