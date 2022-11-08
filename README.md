# Steps
1. [Initialise](#initalise)
2. Start with [RDBMS project](rdbms)
3. Move on to [Guice project](guiceapp)
4. Finish with [Dropwizard project](dropwizardapp)

# Initalise
```shell
$ mkdir kotlin-monorepo && cd kotlin-monorepo

$ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 4

Split functionality across multiple subprojects?:
  1: no - only one application project
  2: yes - application and library projects
Enter selection (default: no - only one application project) [1..2] 2

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Kotlin) [1..2] 2

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no] 

Project name (default: kotlin-monorepo): 

Source package (default: kotlin.monorepo): com.kotlinmonorepo

> Task :init
Get more help with your project: https://docs.gradle.org/7.4.2/samples/sample_building_kotlin_applications_multi_project.html

BUILD SUCCESSFUL in 22s
2 actionable tasks: 2 executed
```
