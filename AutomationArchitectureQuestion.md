# Automation Architecture

*How you would integrate the scripts into a CI/CD environment. 
These can include integration with Cloud Based services or locally and describe why the choices made.*


### Why Pipeline on Jenkins: ###

- Is well know that Jenkins is the most popular tool for CI/CD and also is highly customizable, this project contains Java and Maven so would perfectly fits on a Jenkins pipeline using a well developed Jenkinsfile that would do code checkout on GitHub, manage both API and UI tests in order to run in different nodes, and also to improve this would be add a feature to setup cron time jobs to schedule all this tests. 
 
 Things nice to add:
 
 - Parameters, to escalated the variety of test cases. 
 - There is a lot of incredible report plugins that is valuable (Allure is great)
 - Manage on Jenkinsfile script to send email alerts if any job fails 


### Why Cloud Based: ###

- Considering that we already have our Jenkins (master) up an running, lets face this scenario: if you want to add some tests in the flow, this can become quite a huge infrastructure and also hard to maintain. To provide a modern, and scalable solution for that, Kubernetes would be my choice: Jenkins can run tasks on different agent nodes while kube-plugin enable the possibility to create these nodes dynamically and also run many build plans in parallel.

- And the awesome part: an agent node is created only for the task execution and deleted afterwards, so a pod (one or more container) execute a unique task limited in time. Which means: the container go up do this job and then get down, without no need to maintain an infrastructure idle.

- A nice & smoothly infrastructure draft: first we have our Jenkins Master (with all the plugins needed installed: git, reports, K8S), and this can be easily scalable using slaves (on that Manage Nodes config!).


##### A very simplified diagram draft with my idea #####


<p align="center">
  <img width="400" height="270" src="https://github.com/marinalb/CompGraficaI/blob/master/Image_jenkins.jpg">
</p>

