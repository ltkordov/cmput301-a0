# CMPUT 301 Assignment 0
### Goal: Build a Simple Decision-making App

## Prelude
Suppose you are going to Japan, and you know you will have a hard time choosing which restaurants to go to. So, you create an app to help you decide. <br></br>
There will be some restaurants you would really want to go to, some that you kind of want to go to, and others that you don't really want to go to. 
You decide that your app will have 3 buttons, each with a different probability of outputting "yes, you should go to that restaurant" or "no, you shouldn't go to that restaurant". 
> For example, you can set the probabilities as:
> - For restaurants you would really want to go to, you set the probability of outputting "yes" to 50%
> - For restaurants you kind of want to go to, you set the probability of outputting "yes" to 25%
> - For restaurants you don't really want to go to, you set the probability of outputting "yes" to 10%

## Requirements
- At least **3 clickable buttons, each with different probabilities** to determine an output. No button may have a guaranteed (100%) outcome.
- At least **1 text/image output, indicating the decision made**
- At least **1 visual indicator that a button has been clicked** (e.g., a click counter, background color change, etc.)
- Your **Student ID Number AND CCID indicated clearly** somewhere on your app

## Submission Specification
- LICENSE your assignment with an opensource license. Add a LICENSE.md file to the root of the directory the assignment, that contains an opensource license that will be used for the project.
  - Apache 2.0 or GPL 3.0 or AGPL 3.0 are recommended
- Once you finish making the decision-making app, **screen-record a video, no longer than 1 minute**, showcasing the actions in the following order:
1. Click the 1st button 6 times
2. Click the 2nd button 8 times
3. Click the 3rd button 10 times
4. *OPTIONAL: If you have more buttons/features, you can show them after the above actions*
> [!NOTE]
> - Please pause for a brief moment in between clicks so that outputs can be clearly seen
> - You may be unlucky enough that the output stays the same for all 30 (or more) clicks. Try recording the video again so we can see that the output isn't hardcoded.

> [!IMPORTANT]
> - You will need to **submit a zip file containing the video on Canvas**
> - **Name the zip file and your video file `[your CCID]_decision_making_app`**. For example, the zip file as `student1_decision_making_app.zip` and the video file as `student1_decision_making_app.mp4`
> - We have included a bash script called `check_filename_a0.sh` that you can use to check the name of your zip file. Put the bash script in the same directory as the zip file, and then run it.

## Grading
- Assignment 0 is worth 1% of your final grade.
- It will be graded on a "complete/incomplete" basis. You will receive the full 1% if you follow ALL requirements and submission specifications properly. Missing at least 1 requirement or submission specification will earn you 0%. **There will be no exceptions, partial marks, or late submissions allowed.**
- Furthermore, while app aesthetics are not emphasized, the app should be intuitive and clear. We welcome you to be creative!

## Getting Started 
If you are unsure of how to get started on assignment 0, please refer to the Android Basics with Compose course: https://developer.android.com/courses/android-basics-compose/course?hl=en <br></br>
In particular, check out `Introduction to Kotlin` (Unit 1) and `Kotlin fundamentals` (Unit 2) to learn basic Kotlin skills, `Setup Android Studio` (Unit 1) to install and familiarize yourself with Android Studio if you haven't already, and `Build a basic layout` (Unit 1) to learn how to use Jetpack Compose to create basic UI.

> [!TIP]
> Check out the `Add a button to an app` (Unit 2) pathway to create a simple Dice Roller App. You can use this as a solid starting point for assignment 0.
> While you could copy the solution code they provide, if you understand what is going on, you can very easily add to the existing Dice Roller App code to create your decision-making app.

## Example
| Initial Screen | No Output | Yes Output | Alternative Initial Screen |
| --- | --- | --- | --- | 
| <img src="example_images/DecisionMakerApp_InitialScreen.jpg" width="300"> | <img src="example_images/DecisionMakerApp_NoOutput.jpg" width="300"> | <img src="example_images/DecisionMakerApp_YesOutput.jpg" width="300"> | <img src="example_images/DecisionMakerApp_AlternativeInitialScreen.png" width="300"> |

<ins>Example details:</ins>
Clicking `Ok!` has a 50% chance of outputting "Yes", clicking `Meh` has a 25% chance of outputting "Yes", and clicking `Nah` has a 10% chance of outputting "Yes". <br></br>
The Alternative Initial Screen shows alternative text you could use for your buttons. <br></br>

> [!NOTE]
> Your app DOES NOT need to look like the example above. (Plus, the example are missing a requirement - which one is it?) It DOES need to follow the specified requirements and submission procedures.
