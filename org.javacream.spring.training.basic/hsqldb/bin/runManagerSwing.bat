cd ..\data
@java -classpath ..\lib\hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost %1 %2 %3 %4 %5 %6 %7 %8 %9
