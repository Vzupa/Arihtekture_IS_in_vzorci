# Opis projekta

V duhu obširne zdravstvene reforme razvijamo zaledni sistem in spletno aplikacijo za sistem e-zdravje 💉, ki bo omogočal vodenje zdravstvenih kartotek pacientov in njihovih obiskov pri zdravnikih. Glavna funkcionalnost sistema bo beleženje podatkov o pacientih ter njihovih obiskov pri zdravnikih. Na tej osnovi se bo izvajalo preverjanje upravičenosti prevzema določenih zdravil ob obisku lekarne. 

Sistem bo omogočal beleženje osebnih podatkov pacientov (ime, priimek, naslov, datum rojstva, spol, kontaktni podatki, alergije, kronične bolezni, pretekle bolezni, predpisana zdravila, izbran zdravnik ipd.). Beležili bomo tudi obiske pacientov pri zdravnikih (datum obiska, ime zdravnika, opis diagnoze, predpisana zdravila).


## Naloga 1: Vzpostavitev okolja, priprava in zagon enostavne spletne aplikacije

1. Vzpostavite razvojno okolje, ki vključuje ("out-of-the-box") aplikacijski strežnik WildFly (http://wildfly.org/downloads) in IDE (Eclipse / IntelliJ IDEA).
2. Razvijte in poženite rešitev - kreirate lahko domoroden ali Maven/Gradle projekt v IDE (Eclipse / IntelliJ) ali izhajajte iz pripravljenega Maven/Gradle projekta.
3. Omogočite dodajanje in pregled prej navedenih podatkov (tabelarični seznam, obrazec za dodajanje, pregled podrobnosti).

## Naloga 2:

1. Možnost urejanja podatkov (uporabniški vmesnik: ponovno uporabite funkcionalnost dodajanja),
2. Možnost brisanja podatkov (dialog »ste prepričani«),
3. Pregled števila opredeljenih pacientov po zdravnikih, paciente brez izbranega zdravnika na ločeni spletni strani.

Vašo rešitev lahko opremite tudi z lepšim izgledom (npr. BootStrap) zunanjo knjižnico gradnikov (npr. PrimeFaces) ipd.

## Naloga 3:

Razred(e) za hranjenje objektov (DAO) preoblikujte tako, da bo(do) skladen(ni) z vzorcem Edinec. Odločite se za ustrezno implementacijo edinca in pazite na to, da delujete v večuporabniškem okolju!

Zakaj so sedaj vsi podatki hkrati vidni vsem uporabnikom vaše rešitve? Bi morali razred DAO morda prilagoditi takšnemu okolju?
