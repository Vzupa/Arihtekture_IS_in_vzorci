# Opis projekta

V duhu obširne zdravstvene reforme razvijamo zaledni sistem in spletno aplikacijo za sistem e-zdravje 💉, ki bo omogočal vodenje zdravstvenih kartotek pacientov in njihovih obiskov pri zdravnikih. Glavna funkcionalnost sistema bo beleženje podatkov o pacientih ter njihovih obiskov pri zdravnikih. Na tej osnovi se bo izvajalo preverjanje upravičenosti prevzema določenih zdravil ob obisku lekarne. 

Sistem bo omogočal beleženje osebnih podatkov pacientov (ime, priimek, naslov, datum rojstva, spol, kontaktni podatki, alergije, kronične bolezni, pretekle bolezni, predpisana zdravila, izbran zdravnik ipd.). Beležili bomo tudi obiske pacientov pri zdravnikih (datum obiska, ime zdravnika, opis diagnoze, predpisana zdravila).


## Naloga 1: Vzpostavitev okolja, priprava in zagon enostavne spletne aplikacije

1. Vzpostavite razvojno okolje, ki vključuje ("out-of-the-box") aplikacijski strežnik WildFly (http://wildfly.org/downloads) in IDE (Eclipse / IntelliJ IDEA).
2. Razvijte in poženite rešitev - kreirate lahko domoroden ali Maven/Gradle projekt v IDE (Eclipse / IntelliJ) ali izhajajte iz pripravljenega Maven/Gradle projekta.
3. Omogočite dodajanje in pregled prej navedenih podatkov (tabelarični seznam, obrazec za dodajanje, pregled podrobnosti).

## Naloga 2: Vzpostavitev ključnih funkcionalnosti aplikacije

1. Možnost urejanja podatkov (uporabniški vmesnik: ponovno uporabite funkcionalnost dodajanja),
2. Možnost brisanja podatkov (dialog »ste prepričani«),
3. Pregled števila opredeljenih pacientov po zdravnikih, paciente brez izbranega zdravnika na ločeni spletni strani.

## Naloga 3: Vzorec edinec

Razred(e) za hranjenje objektov (DAO) preoblikujte tako, da bo(do) skladen(ni) z vzorcem Edinec. Odločite se za ustrezno implementacijo edinca in pazite na to, da delujete v večuporabniškem okolju!

## Naloga 4: Vzorec fasada, vmesni nivo, storitve aplikacijskega strežnika

Pacientu boste dodali funkcionalnost izbire zdravnika:
- V kolikor zdravnik še ne dosega polne kvote pacientov, naj zdravnik in pacient prejmeta e-poštno sporočilo, ki ju obvešča o tem, da je pacient izbral zdravnika.
- Če zdravnik že ima napolnjeno kvoto, pa naj se sporočilo pošlje le pacientu - in sicer da izbira žal trenutno ni možna.

Z namenom implementacije te funkcionalnosti, ki ne spada niti na DAO nivo, niti na nivo uporabniškega vmesnika, uvedite nov, vmesni nivo (razred), namenjen izbiri zdravnika. Preverjanje števila opredeljenih in zdravnikova kvota še vedno spadata na nivo DAO!

V namen pošiljanja e-poštnih sporočil implementirajte poseben razred, skladen z vzorcem fasada.

## Naloga 5: Sejna zrna in odjemalci

Neposredno v spletni projekt uvedite sejna EJB zrna, ki so namenjena trajnemu hranjenju vrednostnih objektov (EJB temeljite na obstoječem DAO razredu).

Pri tem naj bo zrno brez stanja (@Stateless), dosegljivo lokalno (@Local). Povezavo iz uporabniškega vmesnika in eventuelno med zrni vzpostavite s pomočjo oznake @EJB.
Tudi razred, kjer je implementirana funkcionalnost izbire osebnega zdravnika naj postane EJB, pri čemur omogočite izbiro osebnega zdravnika tudi preko (nove) konzolne aplikacije.

## Naloga 6: Vzorec opazovalec

Implementirajte vzorec opazovalec, da bi dosegli naslednje obveščanje pacientov:

- Ko se pacientu dodeli zdravnik, naj pacient prejme e-poštno sporočilo, ki mu sporoči, kateri zdravnik je bil dodeljen.

- V primeru, da je pacent že imel dodaljenega zdravnika, naj se pošlje tudi epoštno sporočilo, ki vsebuje podatek o zdravniku, ki več ni dodaljen pacientu.

