Aihe: 3d Tähtikartta. 

3d kartta näyttää kerrallaan kuutioprojektion osasta auringon lähiavaruutta. 

Käyttäjät: Sovellus toimii samalla tavalla kaikkien käyttäjien kanssa. 

Toiminnot 

//-kommentoituja toimintoja ei vielä ole toteutettu

1. Lähtötila

Käyttöliittymäikkuna on auki. 

2. Tähtikartta

2.1 Tähtikartan näyttäminen 

Tapahtuu painamalla Show-nappia, minkä jälkeen tähtikartta avautuu erillisessä ikkunassa kuution sisällä. 

2.2. Tähtikartan alkutila

Alkutilassa tähtikarttaikkunassa näytetään tasasivuinen kuutio avaruutta, jonka keskipiste on Otavan tähtikuvion keskipisteessä, ja jonka etusivu on 50 asteen levyinen kaistale pohjoisen pallonpuoliskon tähtitaivasta. 

2.3 Tähtien kirkkaus tähtikartassa

Tähdet esitetään valkoisina palloina, joiden halkaisija on riippuvainen visuaalisesta magnitudista tarkkailupaikasta käsin. Näytetään vain tähdet joiden visuaalinen  magnitudi on 8 tai pienempi. 

//2.4 Tähtien nimet

Tulostuvat kuutioon

//2.5 Tähtien värit

//2.6. Kuution kääntäminen

Tapahtuu hiirtä liikuttamalla. Ei muuta kuution keskipisteen eikä tarkkailupisteen koordinaatteja, eikä kuution sivun pituutta.

//2.7. Tarkkailupisteen siirtäminen x, y tasossa nuolinäppäimillä

Kuution keskipiste ja kuution sivun pituus eivät muutu. 

//2.8. Kuution sivun pituuden muuttaminen plus ja miinus-napista. 

Tarkkailupiste ja kuution keskipiste eivät muutu. 

3. Käyttöliittymä 

Käyttöliittymä aktivoituu vain tähtikartan sulkemisen jälkeen. 

Käyttöliittymä on ikkuna jossa on seuraavat komponentit.

3.1. Show-nappi

Avaa 3d tähtikartan alkutilassa. Katso kohta 2.1 ja 2.2. 

3.2. Kuution keskipisteen koordinaatit

Kuution keskipisteen koordinaatit näytetään sekä kartesiolaisessa- että pallokoordinaatistossa. Niitä voi myös editoidä käsin. Editointi lopetetaan painamalla enter. Editoidusta koordinaatista riippuvat koordinaatit päivittyvät heti editoinnin loputtua. 

//3.3 Tarkkailupisteen koordinaatit

Tarkkailupisteen koordinaatit näytetään sekä kartesiolaisessa- että pallokoordinaatistossa. Niitä voi myös editoida käsin. Editointi lopetetaan painamalla enter. Editoidusta koordinaatista riippuvat koordinaatit päivittyvät heti editoinnin loputtua. 

//3.4. Kuution sivun pituus parsekeina

Voi editoida käsin, tai painamalla + ja - nappeja. 

//3.5. Mittakaava-palkki

Verrannollinen lähimmän tahkon pituuden kuution ollessa perusasennossa kyljellään. 

//4. Sammakkoprojektio
	
Ohjelma käyttää seuraavia vapaan lähdekoodin komponentteja ja tietokantoja

-Lighweight Jawa Game Library 3 (http://www.lwjgl.org/)

-Jawa OpenGL Math Library (https://github.com/RGreenlees/Java-OpenGL-Math-Library) by Richard Greenlees

-HYG Database of stars (http://astronexus.com/node/34) by David Nash 

-LWJGL example code http://www.lwjgl.org/guide





