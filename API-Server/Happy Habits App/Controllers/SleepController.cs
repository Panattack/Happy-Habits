﻿using Happy_Habits_App.Forms;
using Happy_Habits_App.Services;
using Microsoft.AspNetCore.Mvc;

namespace Happy_Habits_App.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SleepController : ControllerBase
    {
        private readonly ISleepActivitiesService _sleepActivitiesService;

        public SleepController(ISleepActivitiesService sleepActivitiesService)
        {
            _sleepActivitiesService = sleepActivitiesService;
        }

        [HttpPost("AddHabit")]
        public async Task<IActionResult> CreateHabit([FromBody] SleepForm form)
        {
            Console.WriteLine("Trying to add sleep habit");

            if (!form.IsValid)
            {
                Console.WriteLine("400");
                return BadRequest("Not valid time"); // This sends plain text
            }
            Console.WriteLine("200");
            await _sleepActivitiesService.AddSleepActivity(form);
            return Ok("Sleep habit added succesfully");
        }
    }
}
