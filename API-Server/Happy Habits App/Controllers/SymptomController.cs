﻿using Happy_Habits_App.Forms;
using Happy_Habits_App.Services;
using Microsoft.AspNetCore.Mvc;

namespace Happy_Habits_App.Controllers
{
    public class SymptomController : ControllerBase
    {
        private readonly ISymptomActivitiesService _symptomActivitiesService;

        public SymptomController(ISymptomActivitiesService symptomActivitiesService)
        {
            _symptomActivitiesService = symptomActivitiesService;
        }

        [HttpPost("AddHabit")]
        public async Task<IActionResult> CreateHabit([FromBody] SymptomForm form)
        {
            Console.WriteLine("Trying to add symptom habit");

            if (!form.IsValid)
            {
                Console.WriteLine("400");
                return BadRequest("Not valid attributes");
            }

            Console.WriteLine("200");
            await _symptomActivitiesService.AddSymptomActivity(form);
            return Ok("New symptom habit added");
        }
    }
}
