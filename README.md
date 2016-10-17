To run this project u will need Gradle.


P.S:- At present output file is getting written on path  "/Users/vikasnaiyar/dev/CsvEvaluator/src/main/resources/result.csv"
      Please change this path to ur local drive path in CsvFileProcessor.java

Below command can be used to run the main class.

gradle build bootRun -Pargs="FilePath of input.csv"

gradle build bootRun -Pargs="1+2,http://google.com,5*4+7"


