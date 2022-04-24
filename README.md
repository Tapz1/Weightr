# Weightr

# Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?
•	The requirements of this app were to make an Android app that tracks of a user’s weight through personalized account functions that allows the user to submit their weight and set a weight goal. All while supporting the user to easily achieve their fitness goals.

# What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your UI designs keep users in mind? Why were your designs successful?
•	 This was to be done with a database with at least three tables. One to store the user’s logins and passwords, one to store the weight daily weight, and one to store the user’s goal weight. Other requirements include the need to have a screen to login and create an account, along with a grid to view all the daily weights entered. Users were kept in mind by implementing a simple and straightforward process of just opening the app, submitting weight, and exiting. Should the user want to view their data or update their weight goal, they can do so through other screens accessible in the menu.

# How did you approach the process of coding your app? What techniques or strategies did you use? How could those be applied in the future?
•	I approached the design of this app with MVC (Model-View-Controller) methods and classes. I also made to sure to include input validation to ensure the app would be safe from malicious attacks or just plain user error. 

# How did you test to ensure your code was functional? Why is this process important and what did it reveal?
•	I tested the app every few lines of code through both JUnit testing and launching the app in the virtual environment to see if functionality has been added correctly or if it still remains. 

# Considering the full app design and development process, from initial planning to finalization, where did you have to innovate to overcome a challenge?
•	I had some trouble getting the data to display properly alongside with a “delete” button that would actually work. I managed to achieve this by creating an Adapter class that took data and adapted it a listview in the screen activity. This helped create a bridge between what was in the database and my custom code for deletion to flow smoothly on the Android screen activity. 

# In what specific component from your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?
•	Overall, I believe I was successful with implementing the DRY principle and having my code be more modular so that it can be maintained easier. 


# App Screenshots

<img width="385" alt="image(6)" src="https://user-images.githubusercontent.com/40308970/164894676-33adbed6-492e-4beb-b35d-0d29550a88b6.png">

<img width="376" alt="image(5)" src="https://user-images.githubusercontent.com/40308970/164894684-68ba61c8-fd56-4a0b-8db7-f7d6b0f7ade2.png">

<img width="337" alt="image(3)" src="https://user-images.githubusercontent.com/40308970/164894692-bc67448f-90cd-49dc-b702-6bd16f09ad41.png">

<img width="338" alt="image(4)" src="https://user-images.githubusercontent.com/40308970/164894702-71ddf688-3c1e-416b-b4f6-8cee56e92046.png">

<img width="336" alt="image(2)" src="https://user-images.githubusercontent.com/40308970/164894708-aa1dacc6-9dd1-44f5-8d9f-e3651390c21a.png">

<img width="337" alt="image(1)" src="https://user-images.githubusercontent.com/40308970/164894711-e01b4368-19fb-4b8b-ba03-5e6e63456cf6.png">

<img width="336" alt="image" src="https://user-images.githubusercontent.com/40308970/164894714-9b326458-c6c7-4351-b7a7-328cf7c07a0c.png">
