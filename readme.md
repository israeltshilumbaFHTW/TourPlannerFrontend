# Frontend Dokumentation

## Use Case Diagram

## App Architecture

## Klassendiagramm

## App

## Backend Communication

Für die Backendkommunikation werden zwei APIs verwendet.
<br>

### TourApi

Die Tour API kommuniziert mit dem Backend Server und führt CRUD-Operationen.
Sie verwendet Apaches HTTP-Client und Jacksons Object Mapper zum deserialisieren.

Die Tour Api kümmert sich um die Tours und TourLogs und implementiert get/post
und delete Funktionen.

### Mapquest Api

Die Mapquest Api ist für die Route und das Bild der Route zuständig. Sie verwendet ebenfalls
Apaches HTTP-Client. Die API-Responses werden dann manuell mit einer Funktion geparsed und
weitergegeben.

## ViewModel Layer

Die ViewModels sind die Schnittstellen zwischen unserer View/UI und den APIs. Sie führen
sämtliche Arten von Logik aus und kümmern sich auch um die Datenspeicherung. Sie kommunizieren
bei Änderungen mit anderen Komponenten und können so sicherstellen, dass die richtigen Daten
dargestellt werden.

### Kommunikation zwischen den Komponenten

Für die Kommunikation zwischen den einzelnen Views miteinander wurde das Observer/Listener
Pattern verwendet. In diesem Fall sind bestimmte ViewModels Observer und die Views Listener.
Die ViewModels benachrichtigen alle Views, die sich registriert haben und übergeben in manchen Fällen
die neuen Daten. Ein ViewModel kann auch mehrere Datensätze beobachten und eine View kann sich bei mehreren
Observern anmelden.

## Unit Tests

### Lessons learned

### Time Tracking

### VCS link

#### Frontend

#### Backend
