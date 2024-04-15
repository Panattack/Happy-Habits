﻿using Microsoft.AspNetCore.Mvc;
using Happy_Habits_App.Services;
using Happy_Habits_App.Forms;


// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Happy_Habits_App.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserService _userService;

        public UserController(IUserService userService) => _userService = userService;

        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody] LoginModelForm model)
        {
            
            // Perform validation of model
            if (!model.IsValid)
            {
                return BadRequest("Not enough credentials");
            }

            // Authenticate user
            var user = await _userService.GetUserInLoginAsync(model.Password, model.Email);

            // Check if authentication successful
            if (user == null)
            {
                return Unauthorized("Not valid credentials"); // Invalid email/password
            }

            var token = "Success";

            // Return token as JSON response
            return Ok(token);
        }

        [HttpPost("SignUp")]
        public async Task<IActionResult> SignUp([FromBody] SignUpModelForm model)
        {
            // Perform validation of model
            if (!model.IsValid)
            {
                return BadRequest("Not enough credentials");
            }

            await _userService.CreateUserAsync(model);

            var token = "Success";

            // Return token as JSON response
            return Ok(token);
        }
    }
}
