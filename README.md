# Learning Spark with Scala
## Initial setup
Before we can start learning, we have to install all the stuff we need to get going.
### Prerequisites
#### Java 8
You can get it from Oracle or, if you don't want to deal with their signup process, from [AdoptOpenJDK](https://adoptopenjdk.net).

Confirm the installation was successful by running the `java -version` command in your shell.
```
$ java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.232-b09, mixed mode)
```

#### Scala
Get it from Homebrew:
> `brew install scala`

Confirm the installation was successful by running the `scala -version` command in your shell:
```
$ scala -version
Scala code runner version 2.13.1 -- Copyright 2002-2019, LAMP/EPFL and Lightbend, Inc.
```
### Setting up a build environment
The two prerequisite steps are all that you technically need to work with scala, but having a proper build tool and an IDE make life easier. I'm going to go with SBT and Visual Studio Code for my build tool and IDE.
#### Install sbt
Again, get it from Homebrew:
> `brew install sbt`

#### Set up VSCode to work with Scala
I assume you have VSCode installed. If you don't you can get it [here](https://code.visualstudio.com).

VSCode has a few scala plugins available, but the best one I've found is [Metals](https://github.com/scalameta/metals-vscode). It's got a few rough edges, but it's good enough to be useful and certainly better than nothing.

#### Configure gitignore
Metals creates two directories when it's running: `.metals` and `.bloop`. We want to add both of these to our `.gitignore`. Additionally since we're running on the JVM we need to add `target/`. Our `.gitignore` file should look like this now:
```
.metals
.bloop
target/
```

## My first program
Time to write out first app. We'll go with the typical Hello, World example. At the root of the git repo, create the following folders: `src/main/scala/com/my_first_app`. In this folder, create a file called `Application.scala`.

Now, open a new terminal and navigate to the root of your repo. Type `sbt` to enter the sbt shell environment. It's going to create a bunch of folders for you, so just wait until it gives you a command prompt. Once it does that, type `~compile`. This tells sbt to continually compile your project as you make changes to your code. As a bonus, Metals uses this to provide syntax highlighting directly in VSCode.

Type the following into `Application.scala` to create your first program:

```scala
package com.my_first_app

object Application extends App {
  override def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}
```

Sbt should compile this code when you save it and there should be no compile errors. When you're ready, press `enter` to exit the compile watcher and return to the sbt shell. From there, type `run` to run your program. Sbt should run the program and the output should look something like this:

```
sbt:learning-scala> run
[info] running com.my_first_app.Application 
Hello, World!
[success] Total time: 0 s, completed Nov 16, 2019 12:59:21 PM
```

Now modify the program to do something with the command line arguments it gets:

```scala
package com.my_first_app

object Application extends App {
  override def main(args: Array[String]): Unit = {
    for (i <- 0 until args.length) {
      println(s"arg$i: ${args(i)}")
    }
  }
}
```

Type `compile` in the sbt shell and then `run one two three`. You should get output that's similar to the following:

```
sbt:learning-scala> run one two three
[info] running com.my_first_app.Application one two three
arg0: one
arg1: two
arg2: three
```

## Doing stuff with Spark
### Install Spark
The easiest way is again from Homebrew: 
> `brew install apache-spark`

### Add Spark to our dependencies:
To use Spark we need to add it to our dependencies. We do this by adding a line to `build.sbt`: 
> `libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"`  

### Write our first Spark program:
Change your scala application to look like this:
```scala
object Application {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder
      .appName("Spark-Test")
      .config("spark.master", "local")
      .getOrCreate();

    println(s"Spark version: ${spark.version}")
  }
}
```

Type `sbt clean compile package` to compile the program and package it into a jar. Take note of where the jar is placed. You _could_ run the program now with `sbt run`, but you may get some errors in your output. The better way to run spark programs is to submit them as spark jobs. You do this by passing the jar and class to run, along with any arguments, to spark on the command line: `spark-submit --class "class name here" --master "spark url" /path/to/jar [arguments]`. In our example this would be `spark-submit --class "com.daniel_wl.Application" --master "local[4]" ./spark/target/scala-2.11/learning-spark-with-scala_2.11-0.1.jar`. Note that we quoted `"local[4]"`. This is because I'm using zsh as my shell. You might not have to do this if you're using bash or some other shell.
