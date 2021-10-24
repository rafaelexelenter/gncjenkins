### 1. Prerequisites 
1. IntelliJ Community edition
2. JAVA SDK 8
3. GIT Bash
4. Chrome version 90
### 2. Importing project to IntelliJ
 1. Open Git bash 
 2. Clone repository locally by running hte following command
      
      `` https://github.com/rafaelexelenter/gncjenkins.git `` 
 
 3. Open IntelliJ 
 4. Click on File > Open 
 5. Select the cloned repository 
 
> #### Note
> Once project is load to IntelliJ, it could take a couple of minutes for Intellij to download all Maven dependencies, you can go for a coffee :) 

### 3. Executing test 

1. In IntelliJ open the Project Tool window
2. Navigate to src -> test -> resources -> features 
3. right click and run feature file

![src -> test -> resources -> features!](assets/images/FeatureFiles.jpg "image")

> Note: Alternatively test can also be execute from windows terminal. 
> 1. In IntelliJ open the Terminal window 
> 2. execute the command ``mvnw clean verify``  
> 3. Execute on local environment by updating the property runOnLocal to true in src -> test -> resources -> config.properties file 
> ![src -> test -> resources -> features!](assets/images/runLocal.JPG "image")






                                                                     
