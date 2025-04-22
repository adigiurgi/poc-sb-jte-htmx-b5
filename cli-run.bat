@echo off
REM Acest script pornește aplicația cu CLI activat și execută comenzile dorite

echo Compilez aplicația...
mvn clean package -Pdev -DskipTests

echo Pornesc aplicația cu CLI activat și execut comanda specificată...
java -jar target/webapp-0.0.1-SNAPSHOT.jar --app.cli.enabled=true %*

echo Aplicația s-a oprit după executarea comenzii.
