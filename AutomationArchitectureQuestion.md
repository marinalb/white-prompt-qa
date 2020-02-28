# Automation Architecture

*How you would integrate the scripts into a CI/CD environment. 
These can include integration with Cloud Based services or locally and describe why the choices made.*


### Why Pipeline on Jenkins: ###

- Is well know that Jenkins is the most popular tool for CI/CD and also is highly customizable, this project contains Java and Maven so would perfectly fits on a Jenkins pipeline using a well developed Jenkinsfile that would do a checkout on GitHub, manage both API and UI tests in order to run in different nodes, and also to improve this 
would be add a feature to setup cron time jobs in order to schedule tests. 
 
 Things nice to add:
 
 - Could be add parameters, to escalated the variety of test cases. 
 - There is a lot of incredible report plugins that is valuable (Allure is great)
 - Manage on Jenkinsfile script to send email alerts if any job fails 


### Why Cloud Based: ###

- Considering that we already have our Jenkins - master - up an running, lets face this scenario: if you want to add some tests in the flow, this can become quite a huge infrastructure, and also hard to maintain. To provide a modern, and scalable solution for that, Kubernetes would be my chooise: Jenkins can run tasks on different agent nodes while kube-plugin enable the possibility to create these nodes dynamically. 

- And the awnsome part: an agent node is created only for the task execution and deleted afterwards, so a pod (one or more container) execute a unique task limited in time, which means: the container go up do this job and then get down, without no need to maintain an infrastructure idle.


##### A very simplified diagram with my idea #####



