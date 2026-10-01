# IoT Sensor-projekt - Backend

Detta är backend-delen av IoT Sensor-projektet.

Backend är byggd med Java och Spring Boot och ansvarar för att ta emot mätdata från Arduino, lagra mätningarna i MongoDB samt sammanställa statistik som kan hämtas av frontend.

## Exempel på användning av applikationen

**Problem:** En husägare har ett garage eller förråd där temperatur och luftfuktighet kan variera mycket. Det kan vara svårt att veta hur klimatet faktiskt har sett ut över tid.

**Lösning:** Backend tar emot och lagrar mätdata från en Arduino och gör det möjligt för frontend att hämta mätningar och statistik för analys över tid.

## Teknik

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB
- REST API
- Maven

## Dataflöde:

### Arduino

Arduino mäter:

- Temperatur i °C
- Luftfuktighet i %

Mätdata skickas som JSON till backend via HTTP POST.

### Spring Boot Backend

Backend:

- Tar emot mätdata från Arduino.
- Sparar mätningarna i MongoDB.
- Hämtar sparade mätningar.
- Hämtar mätningar för en vald dag.
- Sammanställer statistik för en vald dag.

### MongoDB

Mätningarna lagras i en lokal MongoDB-databas.

Varje mätning innehåller:

- ID
- Temperatur
- Luftfuktighet
- Tidsstämpel

### Frontend

Frontend hämtar data från backend via REST API och visar mätningar, statistik och diagram för användaren.

## Endpoints

- GET: Hämta alla mätningar:  
```text
/api/humidity-temperature
```
- GET: Hämta Mätning för specifik dag:
 ```text
/api/humidity-temperature/day?date=2026-09-30
```
- GET: Hämta Statistik för specifik dag:
```text
 /api/humidity-temperature/statistics?date=2026-09-30
 ```
 - POST: Skapa en ny mätning
```text
 /api/humidity-temperature
 ```

## Installation

- Klona repot.
- Installera och starta MongoDB lokalt.
- Backend använder Spring Boots standardinställningar för MongoDB.
- Använd exempelvis MongoDB Compass för att se den lokala databasen.
- Kompilera och starta projektet.
- Testa gärna någon endpoint i exempelvis Postman för att kontrollera att backend fungerar.
- Gå vidare till Frontend-repot.