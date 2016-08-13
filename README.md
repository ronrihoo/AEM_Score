# AEM Score
##Brief
Approximates a student's letter grade for an exam or average score in the Advanced Engineering Mathematics course taught by Dr. Deignan at UT Dallas.

##Structure

![alt text](http://i.imgur.com/K78y69M.png)

**Main.java** has only one instance of a class. That one instance is of the **Driver.java** class. 

The only instance that **Driver.java** has is one, and only one, of the **Instances.java** class. 

**Instances.java** handles all instances of any other classes.  

**Instances.java** is always the middleman between all computation and io classes; therefore, instances will never be passed to other instances.

##Quick Use
All data must be provided to the app through the **FakeInterface.java** class.

###Setting the Historical Class Average Distribution
Using the **Driver.java** class, you must invoke the `setHistoricalAvgLetterGradeDistribution(...)` method from the instance of **FakeInterface.java** created by the **Instances.java** class. 

```Java
instances.fakeInterface.setHistoricalAvgLetterGradeDistribution(27, 24, 31, 5, 12);
```

This method takes the letter grade distribution from highest to lowest for its arguments.
```
instances.fakeInterface.setHistoricalAvgLetterGradeDistribution([A], [B], [C], [D], [F]);
```

###Setting the Class Average Numeric Grade Distribution
Using the **Driver.java** class, you must invoke the `setClassAverageNumericGradeDistribution(...)` method from the instance of **FakeInterface.java** created by the **Instances.java** class. 

```Java
instances.fakeInterface.setClassAverageNumericGradeDistribution(0, 0, 2, 3, 5, 13, 8, 10, 3, 3);
```

This method takes the numeric grade distribution from highest to lowest for its arguments.
```
instances.fakeInterface.setClassAverageNumericGradeDistribution([100-90%], [89-80%], [79-70%], [69-60%], [59-50%], [49-40%], [39-30%], [29-20%], [19-10%], [9-0%]);
```

###Setting the Class Score Numeric Grade Distribution
For the sake of keeping data organized, where you want to approximate a student's exam score letter grade (instead of the student's course average letter grade), the `setClassScoreDistribution(...)` method can be used. 

It is practically the `setClassAverageNumericGradeDistribution(...)` method, but has a different name and affects a different part of the dataset.

Using the **Driver.java** class, you must invoke the `setClassScoreDistribution(...)` method from the instance of **FakeInterface.java** created by the **Instances.java** class. 

```Java
instances.fakeInterface.setClassScoreDistribution(0, 0, 2, 3, 5, 13, 8, 10, 3, 3);
```

This method takes the numeric grade distribution from highest to lowest for its arguments.
```
instances.fakeInterface.setClassScoreDistribution([100-90%], [89-80%], [79-70%], [69-60%], [59-50%], [49-40%], [39-30%], [29-20%], [19-10%], [9-0%]);
```

###Setting the Student's Score
Using the **Driver.java** class, you must invoke the `setUserScore(...)` method from the instance of **FakeInterface.java** created by the **Instances.java** class. 

```Java
instances.fakeInterface.setUserScore(50);
```

This method takes the numeric grade in the integer type (no precision).
```
instances.fakeInterface.setUserScore([student's grade with no precision]);
```

##Extended Use
This Java app can be easily doped into a(n) Android and/or JavaFX app. 

###Input
Using the **Driver.java** class, you must provide data from the GUI to the **FakeInterface.java** class with the same methods as described above.

###Output
The **Driver.java** class can directly provide data to the GUI; however, for better practice, the **FakeInterface.java** class will be required to handle more parts of the dataset and be updated by the **Driver.java** class. This way, the **FakeInterface.java** class will be the only middleman between the GUI (or other types of UI) and the rest of the app.

## Contributors
Please join the project by making contributions. The app could specifically use better algorithms for the statistics portion, as it currently does not make the best use of the data provided to it. This is because the original author, Ronald Rihoo, lost interest in the app during the prototype phase.

## Motivation
This project was mostly made out of intrigue and not for actual letter grade approximations; therefore, the use of this Java app for actual approximations is not recommended. 

## Dear Students
Do not allow the approximations of this app to set your expectations, since many variables and aspects of the grading model are not considered here and the students never have all of the data that the professor has (e.g., the grade of every student for every graded part of the course).
