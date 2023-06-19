# Dokumentation

## Use Case Diagram
![Use Case Diagram](images/tourplanner-usecase.png)

## App Architecture
![App Architecture](images/app-architecture.png)

## Class Diagram
![Class Diagram](images/class-diagram.png)

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
Da es sehr schwer ist die Views direkt zu testen, wurden vor allem die ViewModels und andere Komponente,
die Logik besitzen getestet. So wird zum Beispiel die User Input Validation rigoros getestet, damit es
nicht zu unerwarteten crashes kommt. Ebenfalls wurde die Api zum Frontend getestet, damit wir eine verlässliche
Schnittstelle zwischen Frontend und Backend haben.

## Unique Feature
Als Unique Feature haben wir uns dazu entschieden eine Help-Page zu erstellen, die dem User einen Überblick bietet, um
die Funktionen der App kennenzulernen. Besonders für neue Benutzer ist so eine Funktion in einer "echten" Applikation
sehr hilfreich. 

### Lessons learned

- Die Verwendung von Code Patterns haben die Qualität und Übersichtlichkeit dieses Projekts deutlich verbessert.
  Sie haben dem Code eine gute Struktur gegeben, sodass man sich sehr schnell auskennt und weniger Spaghetti Code
  programmiert.
- Die Integration eines Protokollierungsframeworks (log4j) hat enorm dabei geholfen, Laufzeitinformationen zu erfassen
  und Fehler effektiv zu diagnostizieren. Nächstes Mal werden wir so ein Framework früher einsetzen um von Anfang Bugs
  erkennen zu können.
- Umfassendes Unit-Testing hat die Korrektheit unseres Codes gewährleistet und hat stark dazu beigetragen, mit
  Sicherheit sagen zu können, dass der Code funktioniert.
- Rechtzeitig beginnen und gegen Ende einer Abgabe Stress ersparen
- Git-Conflicts sind aufwendig, aber können mit geeigneten Vorbeugemaßnahmen weitgehend verhindert werden:
  - Commits klein und fokussiert halten
  - In separaten Branches arbeiten
  - Regelmäßig lokalen Branch aktualisieren
### Time Tracking

| Date               | Time | Comment                                |
|--------------------|------|----------------------------------------|
| 30.03              | 1    | Create GitHub-Repository               |
| 31.03              | 1    | Set up database                        |
| 31.03              | 1    | Docker Setup                           |
| 31.03              | 3    | Set up Springboot                      |
| 31.03              | 2    | Setting up OR-Mapping Library          |
| 04.05              | 5    | Create tour-logs                       |
| 22.05              | 1    | Validate user-input                    |
| 04.05 - 02.06      | 6    | Create tour                            |
| 03.06              | 3    | Setting up MapQuest/Static Map API     |
| 15.06              | 1    | log4j                                  |
| 16.06              | 1.5  | Delete tour                            |
| 17.06              | 4    | Report-generation                      |
| 17.06 - 18.06      | 6    | Import/Export JSON Files               |
| 18.06              | 2    | Delete tour-logs                       |
| 18.06              | 2.5  | Unique feature                         |
| 18.06              | 2    | Finish Unit Tests                      |
| throughout Project | 10   | Frontend-Design                        |
| throughout Project | 43   | Bugfixing, small adjustments, Protocol |
| <b>Overall</b>     | 95   |                                        |


### VCS link

#### Frontend
https://github.com/israeltshilumbaFHTW/TourPlannerFrontend
#### Backend
https://github.com/israeltshilumbaFHTW/TourPlannerBackend