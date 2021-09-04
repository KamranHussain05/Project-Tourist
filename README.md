# Project Tourist
# Inspiration
Mercury News article about passports taking a lot of time because people want to travel. This sudden and massive growth in the travel industry is a perfect reason to help people experience different places through travel. We want to encourage travel of all kinds as it opens up the mind to new things, especially after being cooped up at home for over a year! So we decided to address the stress of planning a vacation with an AI program that does that for you!

# What it does
Project Tourist is an Artificial Intelligence vacation planner that uses natural language processing to choose a destination and activities for an amazing adventure.

# How we built it
We used the Stanford CORE NLP plus Maven as our backend with Processing and G4P processing as our front end. We connected the two using locally stored files and switched screens to show the final data. We used Maven to compile the project.

# Challenges we ran into
Using the Core NLP library was the most difficult part. Initially, we had trouble starting the Core NLP server which would constantly crash prior to starting. After troubleshooting that issue to no avail, we researched some solutions and found that we had to build the project to Maven instead of a regular Java project. This was an extremely valuable learning experience. A learning opportunity at the front end was configuring user inputs such as buttons and making a custom search bar when that was not built into the Processing library. It was a useful hurdle to overcome as it can be used time and time again in the future!

# Accomplishments that we're proud of
We are proud that we were able to make a Maven build for the first time. It was a struggle to build the project with the Core NLP library, and part of that struggle was trying a new type of build configuration. We are also proud that our NLP algorithm can associate words with activities, people, and places. It is really cool to see something we have worked so hard on come together so nicely.

# What we learned
We learned how to do many functions in programming. One of the things that blew us away was our use of natural language processing via Core NLP to process user inputs and make meaningful use of the words processed by the NLP algorithm. Another thing we learned was using the Google Maps API to search for activities nearby to the user. Using a location limiter, we are able to find activities within a set radius to the general location where the algorithm suggests the user goes. Finally, we learned some new techniques in Java's Processing library such as making a custom search bar. Some of our team members learned how development in a hackathon works and are excited to continue doing more!

# What's next for Project Tourist
Next, we will take Project Tourist to the masses. To do this, we will be optimizing the natural language processing to be faster and more efficient. With a more efficient and faster algorithm, we can improve the user experience and increase compatibility for a wider range of devices. The optimized version can then live on the web creating adventures on the fly.
