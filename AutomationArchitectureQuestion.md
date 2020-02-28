# Automation Architecture

Describe in words or diagram how you would integrate the above scripts into a CI/CD environment. 
These can include integration with Cloud Based services or locally and describe why the choices made.


### Why Pipeline on Jenkins: ###

- Is well know that Jenkins is the most popular tool for CI/CD and also is highly customizable, this project would perfectly fits on a Jenkins pipeline using a well developed Jenkinsfile that would manage both API and UI tests, in order to run in different nodes. To improve this, 
would be add a feature to setup cron time jobs in order to schedule tests. 
 
 - If its needed could be add parameters, to escalated the variety of test cases. 


### Why Cloud Based: ###

- Considering that we already have our Jenkins - master - up an running, lets face this scenario: if you want to add some tests in the flow, this can become quite a huge infrastructure, 
and also hard to maintain. To provide a modern, and scalable solution for that, Kubernetes is a pod (one or more container) executing a unique task limited in time, which means: the container go up do this job and then get down.


