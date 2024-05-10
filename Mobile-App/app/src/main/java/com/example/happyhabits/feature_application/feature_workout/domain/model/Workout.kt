package com.example.happyhabits.feature_application.feature_workout.domain.model

import com.example.happyhabits.core.domain.model.Habit
import kotlinx.serialization.Serializable
import java.time.LocalDate

open class Workout (
    id: String,
    userId: String,
    date: LocalDate,
    var type: String,
    var time: String,
    var duration: String,
    var notes:String?,
    val unitMeasurement: String
): Habit(id, userId, date){
    open fun workoutToString(): String {
        return "Workout(type='$type', time='$time', duration='$duration', notes=$notes, unitMeasurement='$unitMeasurement')"
    }
}

class FastActivity(
    id: String,
    userId: String,
    date: LocalDate,
    type: String,
    time: String,
    duration: String,
    notes: String?,
    var quantity: Float?,
    var elevation: Float
) : Workout(
    type = type,
    time = time,
    duration = duration,
    notes = notes,
    unitMeasurement = "km",
    userId = userId,
    id = id,
    date = date
) {
    override fun workoutToString(): String {
        return "FastActivity(type='$type', time='$time', duration='$duration', notes=$notes, unitMeasurement='$unitMeasurement', quantity=$quantity, elevation=$elevation)"
    }
}

class Weights(
    id: String,
    userId: String,
    date: LocalDate,
    time: String,
    duration: String,
    notes: String?,
    exercises: List<Exercise> = emptyList()
) : Workout(
    type = "Weights",
    time = time,
    duration= duration,
    notes = notes,
    unitMeasurement = "kg",
    userId = userId,
    id = id,
    date = date
) {
    var exercisesList: MutableList<Exercise> = exercises.toMutableList()

    override fun workoutToString(): String {
        val exercisesString = exercisesList.joinToString(", ") { it.exerciseToString() }
        return "Weights(time='$time', duration='$duration', notes=$notes, exercises=$exercisesString)"
    }

    fun addWeightExercise(exercise: Exercise): List<Exercise> {
        exercisesList.add(exercise)
        return exercisesList
    }

    val weightExercises = listOf(
        "Bar Dip",
        "Bench Press",
        "Cable Chest Press",
        "Close-Grip Bench Press",
        "Close-Grip Feet-Up Bench Press",
        "Decline Bench Press",
        "Dumbbell Chest Fly",
        "Dumbbell Chest Press",
        "Dumbbell Decline Chest Press",
        "Dumbbell Floor Press",
        "Dumbbell Pullover",
        "Feet-Up Bench Press",
        "Floor Press",
        "Incline Bench Press",
        "Incline Dumbbell Press",
        "Incline Push-Up",
        "Kettlebell Floor Press",
        "Kneeling Incline Push-Up",
        "Kneeling Push-Up",
        "Machine Chest Fly",
        "Machine Chest Press",
        "Pec Deck",
        "Pin Bench Press",
        "Push-Up",
        "Push-Up Against Wall",
        "Push-Ups With Feet in Rings",
        "Resistance Band Chest Fly",
        "Smith Machine Bench Press",
        "Smith Machine Incline Bench Press",
        "Standing Cable Chest Fly",
        "Standing Resistance Band Chest Fly",
        "Band External Shoulder Rotation",
        "Band Internal Shoulder Rotation",
        "Band Pull-Apart",
        "Barbell Front Raise",
        "Barbell Rear Delt Row",
        "Barbell Upright Row",
        "Behind the Neck Press",
        "Cable Lateral Raise",
        "Cable Rear Delt Row",
        "Dumbbell Front Raise",
        "Dumbbell Horizontal Internal Shoulder Rotation",
        "Dumbbell Horizontal External Shoulder Rotation",
        "Dumbbell Lateral Raise",
        "Dumbbell Rear Delt Row",
        "Dumbbell Shoulder Press",
        "Face Pull",
        "Front Hold",
        "Lying Dumbbell External Shoulder Rotation",
        "Lying Dumbbell Internal Shoulder Rotation",
        "Machine Lateral Raise",
        "Machine Shoulder Press",
        "Monkey Row",
        "Overhead Press",
        "Plate Front Raise",
        "Power Jerk",
        "Push Press",
        "Reverse Cable Flyes",
        "Reverse Dumbbell Flyes",
        "Reverse Machine Fly",
        "Seated Dumbbell Shoulder Press",
        "Seated Barbell Overhead Press",
        "Seated Smith Machine Shoulder Press",
        "Snatch Grip Behind the Neck Press",
        "Squat Jerk",
        "Split Jerk",
        "Barbell Curl",
        "Barbell Preacher Curl",
        "Bodyweight Curl",
        "Cable Curl With Bar",
        "Cable Curl With Rope",
        "Concentration Curl",
        "Dumbbell Curl",
        "Dumbbell Preacher Curl",
        "Hammer Curl",
        "Incline Dumbbell Curl",
        "Machine Bicep Curl",
        "Spider Curl",
        "Barbell Standing Triceps Extension",
        "Barbell Lying Triceps Extension",
        "Bench Dip",
        "Close-Grip Push-Up",
        "Dumbbell Lying Triceps Extension",
        "Dumbbell Standing Triceps Extension",
        "Overhead Cable Triceps Extension",
        "Tricep Bodyweight Extension",
        "Tricep Pushdown With Bar",
        "Tricep Pushdown With Rope",
        "Barbell Wrist Curl",
        "Barbell Wrist Curl Behind the Back",
        "Bar Hang",
        "Dumbbell Wrist Curl",
        "Farmers Walk",
        "Fat Bar Deadlift",
        "Gripper",
        "One-Handed Bar Hang",
        "Plate Pinch",
        "Plate Wrist Curl",
        "Towel Pull-Up",
        "Barbell Wrist Extension",
        "Dumbbell Wrist Extension",
        "Air Squat",
        "Barbell Hack Squat",
        "Barbell Lunge",
        "Barbell Walking Lunge",
        "Belt Squat",
        "Body Weight Lunge",
        "Bodyweight Leg Curl",
        "Box Squat",
        "Bulgarian Split Squat",
        "Chair Squat",
        "Dumbbell Lunge",
        "Dumbbell Squat",
        "Front Squat",
        "Goblet Squat",
        "Hack Squat Machine",
        "Half Air Squat",
        "Hip Adduction Machine",
        "Jumping Lunge",
        "Landmine Hack Squat",
        "Landmine Squat",
        "Leg Curl On Ball",
        "Leg Extension",
        "Leg Press",
        "Lying Leg Curl",
        "Pause Squat",
        "Romanian Deadlift",
        "Safety Bar Squat",
        "Seated Leg Curl",
        "Shallow Body Weight Lunge",
        "Side Lunges (Bodyweight)",
        "Smith Machine Squat",
        "Squat",
        "Step Up",
        "Zercher Squat",
        "Assisted Chin-Up",
        "Assisted Pull-Up",
        "Back Extension",
        "Banded Muscle-Up",
        "Barbell Row",
        "Barbell Shrug",
        "Block Clean",
        "Block Snatch",
        "Cable Close Grip Seated Row",
        "Cable Wide Grip Seated Row",
        "Chin-Up",
        "Clean",
        "Clean and Jerk",
        "Deadlift",
        "Deficit Deadlift",
        "Dumbbell Deadlift",
        "Dumbbell Row",
        "Dumbbell Shrug",
        "Floor Back Extension",
        "Good Morning",
        "Hang Clean",
        "Hang Power Clean",
        "Hang Power Snatch",
        "Hang Snatch",
        "Inverted Row",
        "Inverted Row with Underhand Grip",
        "Jefferson Curl",
        "Jumping Muscle-Up",
        "Kettlebell Swing",
        "Lat Pulldown With Pronated Grip",
        "Lat Pulldown With Supinated Grip",
        "Muscle-Up (Bar)",
        "Muscle-Up (Rings)",
        "One-Handed Cable Row",
        "One-Handed Lat Pulldown",
        "Pause Deadlift",
        "Pendlay Row",
        "Power Clean",
        "Power Snatch",
        "Pull-Up",
        "Pull-Up With a Neutral Grip",
        "Rack Pull",
        "Seal Row",
        "Seated Machine Row",
        "Snatch",
        "Snatch Grip Deadlift",
        "Stiff-Legged Deadlift",
        "Straight Arm Lat Pulldown",
        "Sumo Deadlift",
        "T-Bar Row",
        "Trap Bar Deadlift With High Handles",
        "Trap Bar Deadlift With Low Handles",
        "Banded Side Kicks",
        "Cable Pull Through",
        "Clamshells",
        "Dumbbell Romanian Deadlift",
        "Dumbbell Frog Pumps",
        "Fire Hydrants",
        "Frog Pumps",
        "Glute Bridge",
        "Hip Abduction Against Band",
        "Hip Abduction Machine",
        "Hip Thrust",
        "Hip Thrust Machine",
        "Hip Thrust With Band Around Knees",
        "Lateral Walk With Band",
        "Machine Glute Kickbacks",
        "One-Legged Glute Bridge",
        "One-Legged Hip Thrust",
        "Romanian Deadlift",
        "Single Leg Romanian Deadlift",
        "Standing Glute Kickback in Machine",
        "Step Up",
        "Ball Slams",
        "Cable Crunch",
        "Crunch",
        "Dead Bug",
        "Hanging Knee Raise",
        "Hanging Leg Raise",
        "Hanging Sit-Up",
        "High to Low Wood Chop with Band",
        "Horizontal Wood Chop with Band",
        "Kneeling Ab Wheel Roll-Out",
        "Kneeling Plank",
        "Kneeling Side Plank",
        "Lying Leg Raise",
        "Lying Windshield Wiper",
        "Lying Windshield Wiper with Bent Knees",
        "Machine Crunch",
        "Mountain Climbers",
        "Oblique Crunch",
        "Oblique Sit-Up",
        "Plank",
        "Plank with Leg Lifts",
        "Side Plank",
        "Sit-Up",
        "Eccentric Heel Drop",
        "Heel Raise",
        "Seated Calf Raise",
        "Standing Calf Raise",
        "other"
    )
}

class ExercisesWorkout(
    userId: String,
    id: String,
    date: LocalDate,
    type: String,
    time: String,
    duration: String,
    notes: String?,
    simpleExercises: List<String> = emptyList()
) : Workout(
    type = type,
    time = time,
    duration= duration,
    notes = notes,
    unitMeasurement = "",
    userId = userId,
    id = id,
    date = date
) {
    var simpleExercisesList: MutableList<String> = simpleExercises.toMutableList()

    override fun workoutToString(): String {
        val listInString = if (simpleExercisesList.isNotEmpty()) {
            simpleExercisesList.joinToString()
        } else {
            ""
        }
        return "ExercisesWorkout(time='$time', duration='$duration', notes=$notes, simpleExercisesList=$listInString)"
    }

    val swimmingExercises = listOf(
        "Freestyle (Front Crawl)",
        "Backstroke",
        "Breaststroke",
        "Butterfly",
        "Individual Medley (IM)",
        "Medley Relay",
        "Distance Swimming",
        "Open Water Swimming",
        "other"
    )

    val yogaPoses = listOf(
        "Bharadvaja's Twist",
        "Big Toe Pose",
        "Boat Pose",
        "Bound Angle Pose",
        "Bow Pose",
        "Bridge Pose",
        "Camel Pose",
        "Cat Pose",
        "Chair Pose",
        "Child's Pose",
        "Cobra Pose",
        "Corpse Pose",
        "Cow Face Pose",
        "Cow Pose",
        "Crane (Crow) Pose",
        "Dolphin Plank Pose",
        "Dolphin Pose",
        "Downward-Facing Dog",
        "Eagle Pose",
        "Easy Pose",
        "Eight-Angle Pose",
        "Extended Hand-To-Big-Toe Pose",
        "Extended Puppy Pose",
        "Extended Side Angle Pose",
        "Extended Triangle Pose",
        "Feathered Peacock Pose",
        "Fire Log Pose",
        "Firefly Pose",
        "Fish Pose",
        "Four-Limbed Staff Pose",
        "Garland Pose",
        "Gate Pose",
        "Half Frog Pose",
        "Half Lord of the Fishes Pose",
        "Half Moon Pose",
        "Handstand",
        "Happy Baby Pose",
        "Head-to-Knee Pose",
        "Hero Pose",
        "Heron Pose",
        "High Lunge",
        "High Lunge, Crescent Variation",
        "Intense Side Stretch Pose",
        "Legs-Up-the-Wall Pose",
        "Locust Pose",
        "Lord of the Dance Pose",
        "Lotus Pose",
        "Low Lunge",
        "Marichi's Pose",
        "Monkey Pose",
        "Mountain Pose",
        "Rope Pose",
        "One-Legged King Pigeon Pose",
        "One-Legged King Pigeon Pose II",
        "Peacock Pose",
        "Pigeon Pose",
        "Plank Pose",
        "Plow Pose",
        "Pose Dedicated to Koundinya I",
        "Pose Dedicated to Koundinya II",
        "Pose Dedicated to the Sage Marichi I",
        "Reclining Bound Angle Pose",
        "Reclining Hand-to-Big-Toe Pose",
        "Reclining Hero Pose",
        "Revolved Head-to-Knee Pose",
        "Revolved Side Angle Pose",
        "Revolved Triangle Pose",
        "Scale Pose",
        "Seated Forward Bend",
        "Shoulder-Pressing Pose",
        "Side Crane (Crow) Pose",
        "Side Plank Pose",
        "Side-Reclining Leg Lift",
        "Sphinx Pose",
        "Staff Pose",
        "Standing Forward Bend",
        "Standing Half Forward Bend",
        "Standing Split",
        "Supported Headstand",
        "Supported Shoulderstand",
        "Tree Pose",
        "Upward Bow (Wheel) Pose",
        "Upward Facing Two-Foot Staff Pose",
        "Upward Plank Pose",
        "Upward Salute",
        "Upward-Facing Dog Pose",
        "Warrior I Pose",
        "Warrior II Pose",
        "Warrior III Pose",
        "Wide-Angle Seated Forward Bend",
        "Wide-Legged Forward Bend",
        "Wild Thing",
        "other"
    )

    fun addSimpleExercise(exercise: String) {
        simpleExercisesList.add(exercise)
    }
}
@Serializable
class Exercise(
    val name: String?,
    val reps: Int?,
    val sets: Int?,
    val kgs: Float? // New variable kgs of type Float
) {
    constructor(exercise: Exercise) : this(exercise.name, exercise.reps, exercise.sets, exercise.kgs)

    fun exerciseToString(): String {
        return "Exercise(name='$name', reps=$reps, sets=$sets, kgs=$kgs)"
    }
}
