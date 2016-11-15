# Product: Kiddo
# Team: Team_5

## Iteration 02 - Review & Retrospect

 * When: November 14th, 2016, 2:00pm
 * Where: BA2270

## Process - Reflection

Decisions that turned out well:

 * Deciding on the user enrollment process (dividing responsibilities between administrator, parent, and teacher users)
 * Also, choosing to include an administrator role with specific, limited responsibilities
   * this was something that we had a lot of difficulty figuring out because so many possible arrangements exist with different benefits and drawbacks
   * we had a number of factors to consider, including privacy, usability, time spent by users
   * *see* user workflow diagram: https://www.gliffy.com/go/publish/11406769
 * Adding an administrator web interface
   * this is something that we considered in our product design in iteration 01, in order to simplify the administrator's job, but initially decided not to do because we thought it would be too much to tackle in a single iteration
   * we ended up having enough team resources to re-add this to our list of tasks
 * Division of goals/tasks
   * the fact that we were able to produce a working prototype suggests that we divided the work into tasks well, and that we divided those tasks well between team members
   * *see* to-do list: https://docs.google.com/spreadsheets/d/15uk3JXhZX96OlqHsnvBWTcIhikaVs2HP3gFrKqHTBb0/pubhtml

Decisions that did not turn out as well as you hoped:

 * *none*

We are planning to make the following changes to our process:

 * *none*


## Product - Review

Goals/tasks that were met/completed:

* (1) Create workflow
  * User workflow diagram: https://www.gliffy.com/go/publish/11406769
  * User workflow diagram (detailed): https://www.gliffy.com/go/publish/11386683
* (2) Create wireframe
  * Wireframe diagram for teacher user: https://www.gliffy.com/go/publish/11404469
  * Wireframe diagram for parent user: https://www.gliffy.com/go/publish/11409309
  * Wireframe diagram for administrator user: https://www.gliffy.com/go/share/sxaaegccvguge0dflxu6
* (3) Create teacher interface
  * [video](videoFile)
* (4) Create parent interface
  * [video](videoFile)
* (5) Create administrator interface
  * [video](videoFile)
* (7) Create database
  * Data model for database: [kiddodbModel.pdf](kiddodbModel.pdf)
* (8) Create web interface for administrator users to create batches of teacher accounts/classes
  * Web interface site: url
* (9) UML for Java code
    https://www.gliffy.com/go/share/sgfb68agy568wj2fyo1a

Goals/tasks that were planned but not met/completed:

* (3) Create teacher interface: display class events on a calendar
    * currently only displayed as list of events
* (4) Create parent interface: display class events on a calendar
    * currently only displayed as list of events
* (6) Create app class structure: create database queries as part of methods
* (7) Create database: connect database to front-end
    * currently, database query results are mocked-up

Going into the next iteration, our main insights are:

 * Implement as much functionality as possible
   * Having this goal worked well in this iteration: we ended up implementing almost all of the functionality we had planned, and adding more functionality than initially planned
 * Implement calendar functionality
   * This was attempted but unsuccessful so far
   * Examine more examples of app code that implements Android built-in calendar functionality, and model our app on this
 * Fully connect app back-end to front-end (incl. web interface)
   * Replace mocked-up data with real functionality
   * Populate database with fake data
   * Developers of different app layers will collaborate to make the process easier
