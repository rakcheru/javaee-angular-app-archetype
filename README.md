This is a maven archetype that sets up a JavaEE web project that uses Angular (and AngularJS). 
This is meant to be used as a startup when working with Angular frontend backed by JavaEE backend.

Angular provides Angular CLI for build purposes. While its a great build tool, it turns out to be
heavy with Maven modules. It is this scenario where this archetype provides a JavaEE web app that
uses Webpack for building Angular code.

Do note that the provided web app is very basic in the sense that it does not showcase the production
required things like linting, tree shaking, minification etc. They can be added as recommended by
Webpack.

Also, do note that the module doesnt try to integrate Angular functionality with Java web code. 

Technologies used
 - Servlet
 - EJB
 - CDI
 - JPA
 - Hibernate
 - Angular
 - AngularJS

Build Tools:
 - Maven (for Java)
 - Webpack