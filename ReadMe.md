# Ide för ett gui att skriva en interaktiv story i json

Jag tänker mig ett gui med fälten story, hur många nästa alternativ och vad de alternativen ska vara. 
Användaren fyller i dessa och programmet räknar ut de två variabler som saknas, id och nextId, genom att kolla vilka som är redan tagna. 
Då när allt i en scen är skapat så klickar man på en spara-knapp och allt skrivs det ner i en jsonfil på något sätt, BufferedWriter kanske funkar för json annars vet jag inte. 
Gui för att visa titeln till nästa scen känns enkelt men att programmet ska vissa alla nästa scener låter onödigt. 

Att redigera är att användaren väljer rätt del (på något sätt i gui) och får upp typ samma sida som att skapa en scen men att fälten är redan ifyllda från datan från jsonfilen. 
Användaren sparar på samma sätt och det skrivs in i filen. 