Student-Staff Research Connection
===============

![ViewCount](https://views.whatilearened.today/views/github/hugonzb/Student-Staff-Research-Connection.svg)

## Overview
When applying for postgraduate studies (i.e., masters or PhD), several students contact our lecturers for opportunities. In many cases, the students contact lecturers that are not interested in the research work being proposed by the students. In such cases, the lecturer ends up contacting his/her colleagues to check whether they would be interested in the research proposed by the student. Sometimes however, this situation leads students to (i) receive delayed replies regarding postgraduate opportunities or (ii) simply being forgotten due to contacting the wrong lecturers. On the other hand, lecturers may disregard potential students because she or he doesn't know of other lecturers that can interested in the student's proposal. Our task was to come up with a software system that can manage the matching between the interests of students and lecturers.

## Demo Screen Captures
![Home](Demo_Images/Home.png)
![Login](Demo_Images/Login.png)
![Stafflookup](Demo_Images/Stafflookup.png)
![Contactrequest](Demo_Images/Contactrequest.png)
![Notifications](Demo_Images/Notifications.png)
![Approvedrequest](Demo_Images/Approvedrequest.png)

## Setup Instructions

<h3>Download NetBeans</h3>
Download Apache NetBeans 11.3 here: https://netbeans.apache.org/download/nb113/nb113.html
<br><br>
- Choose the Windows ".exe" installer if you are on Windows OS.
<br>
- Choose the Linux ".sh" installer if you are on Linux OS.
<br>
- Choose the MacOS ".dmg" installer if you are on MacOSX.
<br>

Then install it on your device accordingly by running the installer or package. For additional instructions, navigate to the "Get Help" tab at the top right. 
<br>
<h3> Clone the project into NetBeans</h3>
Copy this cloning link into your clipboard: https://github.com/hugonzb/Student-Staff-Research-Connection.git
<br><br>
Open to NetBeans and click on 'Team' in the top menu bar, then 'Remote' -> 'Clone' then follow the steps to successfully import the repository. Use your GitBucket account with the correct username and password which has authorized access to the repository, otherwise you will not be allowed to clone it.
<br>
The next step is to build the project. Click the hammer on the top menu bar of NetBeans which will import all dependencies and build the project so it is ready to be run.
<br>
<h3>Downloading and Configuring H2</h3>
Download the H2 Database here: https://www.h2database.com/html/main.html
<br>
- Choose the "Windows Installer" if you are on the Windows OS.
<br>
- Choose the "All platforms" zip if you are on MacOSX or Linux OS.
<br><br>
Start H2 by running the appropriate start-up script:
<br>
- For Linux, use the H2 Database file. 
<br>
- Windows users should be able to use the h2-windows.bat file.
<br>
- Mac users should be able to double click the h2.jar file to launch it depending on how your computer is configured. If that doesn’t work you will need to use Terminal to navigate to h2/bin and run "java -jar h2*.jar"
<br>

Next follow the H2 configuration steps for either MacOSX or Windows OS accordingly.
<br>
<h3> MacOS H2 Instructions </h3>
Once you have launched H2, you should notice a system tray (yellow 3D cylinder in your top task bar). If you see this icon it means the H2 server is up and running. Click on this icon and press “Create a new database.” This will open up a dialog box. Next:
<br>
- Set the database path to “./test”.
<br>
- Set the username to “sa”.
<br>
- Set the password to “sa”.
<br>
- Press “Create”.
<br>

You should now see a prompt in the bottom part of the console that says “Database was created successfully.”
<br>
Next click on the H2 icon again in your task bar and this time press the “H2 console” which should be the first line from the dropdown menu. This will open a new tab in your browser. Here change the JDBC URL ending so that it matches our local H2 database connection of “./test”, alternatively you can also just copy the connection here: “jdbc:h2:tcp://localhost/./test”. Now for the username and password enter “sa” and click connect. 
<br>
Now go into NetBeans again and using the navigational panel, click on INFO310_group_project -> Source Packages -> dao -> DbConnection. Ensure the URI for Windows users is commented out and the Mac URI is uncommented. 
<br>

<h3> Windows OS H2 Instructions</h3>
Once you have launched H2, you should notice a system tray (yellow 3D cylinder) in your task bar. If you see this icon then the H2 server is running. Right click this cylinder and press "Create new database connection", this will open up dialog box. Next:
<br>
- Set the Database path to "~/test".
<br>
- Set the username to "sa".
<br>
- Set the password to "sa".
<br>
- Press "Create".
<br>
This creates an account which has the credentials that the DAO uses to communicate with the H2 database.
<br>

Next left-click on the yellow cylinder - this will open up a H2 console in your web browser. Enter the username and password "sa" and click 'Connect', which will sign you in. 
<br>

Now go into NetBeans again and using the navigational panel, click on INFO310_group_project -> Source Packages -> dao -> DbConnection
<br>
Ensure the URI for Mac users is commented out and the Windows URI is uncommented. 
<br>
<h3> Importing Default Data into H2 </h3>
In NetBeans use the navigational panel, click on INFO310_group_project -> Resources -> <default package> -> schema.sql, and copy the entire contents of this file. Return to the H2 console in your browser, paste the contents in the box, and click 'Run'.  
<br>
<h3> Run the Service </h3>
Finally, go back into NetBeans, click the project and press the green arrow button on the top menu bar or simply right click the project and press 'Run'.
This will start the Jooby server. The program will output a link in the Netbeans console that looks like this: http://localhost:8080/. Copy and paste this link into a web browser and it will display the welcome page for Student-Staff Research Connection.
<br><br>
If you are having any problems or confusion regarding these setup instructions, please email Hugo Baird at hugonzb@gmail.com
He will provide further technical assistance needed.
<br><br>
