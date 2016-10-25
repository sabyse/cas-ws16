# Spezifikation
Spezifikation der Einzelnen Predikate und wo sie jewails importiert bzw. exportiert werden.

## akteur(ID,double-Kontostand)
Ein akteur wird erstellt.
 - Level     : 1
 - Parser    : AkteurParser.java
 - Generator : AkteurGenerator

## ort(ID)
Ein Neuer ort wird angelegt
 - Level     : 1
 - Parser    : OrtParser.java
 - Generator : NetGenerator

## strasse(ID-Start,ID-Ende,int-kosten)
Erstellt eine Neue Straße zwischen Start und ende,
Diese wird unter der ID (STRT_'start.ID'_to_'ende.ID') im prepository eingetragen.
 - Level     : 2 (abhängig von ort)
 - Parser    : StrasseParser.java
 - Generator : NetGenerator

## ereignis(ID-ort,ID-ort,int-neukosten,long-timestemp).
Ein ereignis mit einer Zufälligen ID wird erstellt.
Die ID der Straße kann erechnet werden.
 - Level     : 3 (abhängig von strasse)
 - Parser    : EreignisParser.java
 - Generator : NetGenerator

## ereignisgen(ID,aktivitaetsrate) 
Local Service ereignis gen wird erstellt
 - Level     : 1
 - Parser    : EreignisGenParser.java
 - Generator : GenGenerator

## auftragsgen(ID,aktivitätsrate).
erstellt einen auftrags generator.
 - Level     : 1
 - Parser    : AuftragsGenParser.java
 - Generator : GenGenerator

## zustaendig(ID-Ergen,ID-Ort).
Ordnet einen ereignis gen einem ort zu, bzw. einen Auftrags gen einem ort
 - Level     : 2 (abhängig von ort,Ergen/auftragsGen)
 - Parser    : ZustaendigParser.java
 - Generator : GenGenerator


## tankstelle(ID, double kosten, int tankdauer)
Eine tankstelle wird erstellt
 - Level     : 1
 - Parser    : TankstelleParser.java
 - Generator : LocalServiceGenerator

## belegt(ID-Tankstelle,ID-LKW) 
belegt eine tankstelle durch einen LKW
 - level     : 3 (abhängig von lkw(2), tankstelle(1))
 - Parser    : BelegtParser.java 
 - Generator : LocalServiceGenerator.java

## handelregister(ID)
Ein handelsregister wird erstellt
 - Level     : 1
 - Parser    : HandelsregisterParser.java
 - Generator : LocalServiceGenerator.java

 ## eingetragen(ID-konsortium,ID-handelregister).
Trägt einen akteur in einem konsortium ein.
 - Level     : 3 (abhängig von konsortium(2), handelregister(1))
 - Parser    : EingetragenParser.java
 - Generator : LocalServiceGenerator.java

## schwarzesbrett(ID)
Ein schwarzes Brett wird erstellt
 - Level     : 1
 - Parser    : SchwarzesBrettParser.java
 - Generator : LocalServiceGenerator.java

## sbnachricht(ID-schwarzesbrett,text-content,ID-ersteller,long-timestemp)
Eine nachricht wird auf einem vorher definierten SB erstellt.
 - Level     : 2 (abhängig von akteur, schwarzes brett) 
 - Parser    : NachrichtParser.java
 - Generator : LocalServiceGenerator.java

## umladebucht(ID)
Erstellt eine Umlade Bucht
 - Level     : 1
 - Parser    : UmladebuchtParser.java
 - Generator : LocalServiceGenerator.java

## boerse(ID)
erstellt eine Börse
 - Level     : 1
 - Parser    : BoerseParser.java
 - Generator : LocalServiceGenerator.java

## funk(ID)
Erstellt einen Funk service
 - Level     : 1
 - Parser    : FunkParser.java
 - Generator : LocalServiceGenerator.java

## linkLocal(ID-ort,ID-localService)
ortnet einen Local Service einem ort zu
 - Level     : 2 (abhängig Lokalservice, ort)
 - Parser    : LinkLocalServiceParser .java
 - Generator : NetGenerator.java

## lkw(ID,ID-akteur,ID-ort-POS,int-KapazitÃ¤t)
ordnet einen LKW einem Akteur und einem Ort zu
 - Level     : 2 (anhängig von ort, akteur)
 - Parser    : LKWParser.java
 - Generator : LKWGenerator.java

## auftrag(ID,ID-ort-Start,ID-ort-Ende,double-Gewinn,int-menge)
Erstellt einen nicht zugeordneten auftrag
 - Level     : 2 (abhängig von ort)
 - Parser    : AuftragParser.java
 - Generator : AuftragsGenerator.java

## sub(ID-child,ID-parent)
Ortnet einen Auftrag einem anden Als sub auftrag zu
 - Level     : 2 (abhängig von ort)
 - Parser    : SubParser.java
 - Generator : AuftragsGenerator.java


## storedIn(ID-auftrag,ID-auftragHalter)
Ordnet einen auftrag einem LKW, einer Umladebuct oder einer Börse zu
 - Level     : 3 (abhängig von Auftrag(1),LKW(2),boerse(1))
 - Parser    : .java
 - Generator : LocalServiceGenerator.java | LKWGenerator.java

## konsortium(ID,ID-akteur-besitzer).
Erstellt ein Konsortium für einen Akteur
 - Level     : 2 (abhängig von akteur(1) )
 - Parser    : KonsortiumParser.java
 - Generator : KonsortiumGenerator.java

## teilnehmer(ID-Akteur,ID-Konsortium)
Trägt einen Akteur als teilnehmer in einem Konsortium ein
 - Level     : 3 (abhängig von Konsortium(2),akteur(1) )
 - Parser    : teilnehmerParser.java
 - Generator : KonsortiumGenerator.java
