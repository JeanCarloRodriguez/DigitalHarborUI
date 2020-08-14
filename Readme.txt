Before start please Download an unzip chromedriver.exe: https://chromedriver.storage.googleapis.com/index.html?path=83.0.4103.39/
into src/main/resources/

Run the project commands:
mvn clean
mvn compile
mvn install
mvn test

to run a specific feature use:
mvn test -Dcucumber.filter.tags="@Buy"