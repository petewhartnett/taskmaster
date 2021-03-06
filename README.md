# taskmaster

Welcome to Task Master. This is an android application to help users to organize their tasks. 



## Change Log:

# Day 1 - 
References - Class 26 frontrow video referenced for lab
- Added a home page
- Added Two routes from the home page
- route 1 is to the add a task page
- route 2 is to the all tasks page
- on the add a task page users are able to add tasks by title and body and when clicking submit, "Submitted" pops up
- on three pages were made to the standards of the wireframe 


![Home Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-11%20at%2012.33.49%20PM.png)

![Detail Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-11%20at%2012.33.24%20PM.png)


# Day 2 - 
References - Class 27 frontrow video referenced for lab
- Added Settings Page
- Added Task Details page 
- Updated home page to have 3 hard coded task buttons
- Clicking any of the buttons will bring the user to the detail page carrying the buttons info with it.
- Settings page is set up to save a username
- the saved username will display on the home page

![Home Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-12%20at%2012.56.05%20PM.png)

![Detail Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-12%20at%2012.59.15%20PM.png)


# Day 3 - 
References - Class 28 frontrow video referenced for lab 
- Added a list of tasks that has a scrollable feature. 
- For the scrollable feature a recycled view is used.
- In the recycled view is a fragment with the tasks
- The three hardcoded buttons were removed
![Recycler View ](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-13%20at%2012.51.51%20PM.png)

![Detail Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-13%20at%2012.52.11%20PM.png)

# Day 4 - 
References - Class 02/18/2020 frontrow video referenced for lab 
also used https://developer.android.com/training/data-storage/room
- Added a database using room
- Users can now save tasks
- Users saved tasks will be displayed in the recycled view, feature working correctly
![Home Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-13%20at%2012.51.51%20PM.png)

![Detail Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-13%20at%2012.52.11%20PM.png)



# Day 5 - 

- Added a a recycler view of all tasks to all task page
- replaced the route to detail page with a toast
- the toast displays the body of the task selected 

The Below image has the recycler view with the toast that siplays the body when clicked. 
![Home Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-20%20at%202.33.35%20PM.png)



# Day 6 - 
References - Class 02/24/2020 frontrow video referenced for lab 
also used the AWS Docs - https://aws-amplify.github.io/docs/android/authentication
- Added login feature from AWS Authentication 
- Added logout ability for users
- users are prompted to create an account with email, username, password, and phonenumber
![Home Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-25%20at%2012.44.56%20PM.png)

![Detail Page Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-02-25%20at%2012.57.01%20PM.png
)

APK - https://github.com/petewhartnett/taskmaster/blob/master/app-debug.apk


# Day 7/8 - 
References - Class 2/25/2020 Front Row video referenced for AWS S3 set up. 
also used AWS s3 documentation. 
- Set up S3 with aomplify for use in the taskmaster application
- tested S3 bucket my manually entering information from the app, test works
- Users are still not able to uplead information however
- Fixed the logout issue
- Fixed the username issue

Of Note: No new screen shots as most changes were in the backend old screen shots still apply





# Day 9 - 
References - Class 2/26/2020 Front Row video referenced for AWS S3 set up. 
also used AWS s3 documentation. 
- Set up google firebase account 
- Set up amplify push notifications
- created an amazon pinpoint
- set up a segment in pinpoint
- set up a campaign in pinpoint

Notifcation screen shots below: 

Individual Notification - 
![Notification PinPoint Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-03-03%20at%2010.07.16%20AM.png)

Multiple notifications - 
![Notification FireBase Screen Shot](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-03-03%20at%2010.03.34%20AM.png
)





# Day 10 - 
References 
- Class 3/2/2020 Front Row video referenced for intent filter addition
- Android documentation used for set-up https://developer.android.com/training/basics/intents/filters


- Placed Intent Filter code into the xml manifest document
- Made image sharable, text is also set up to be sharable
- Set up add task to take the Uri of the image selected

![Intent Filter Screen Shot 1](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-03-03%20at%2011.03.18%20AM.png)


![Intent Filter Screen Shot 2](https://github.com/petewhartnett/taskmaster/blob/master/Screen%20Shot%202020-03-03%20at%2011.37.25%20AM.png
)


# Day 11 - 
References 
- Class 3/3/2020 Front Row video referenced for intent filter addition
- Android documentation used for set-up https://developer.android.com/
- reference https://stackoverflow.com/questions/22323974/how-to-get-city-name-by-latitude-longitude-in-android


- Updated Schema to have the location save to database
- Updated the Task constructor
- Updated saving funtionality to include the locaiton
- Updated the recycler view to display the location. 


The location is not displaying, I will update images once the location is displaying properly. 
