Aihe: 3d Tähtikartta. 

3d kartta näyttää kerrallaan kuutioprojektion osasta auringon lähiavaruutta. 

Käyttäjät: Sovellus toimii samalla tavalla kaikkien käyttäjien kanssa. 

I) Toiminnot 

1. Lähtötila

Käyttöliittymäikkuna on auki. 

2. Tähtikartta

2.1 Tähtikartan näyttäminen 

Tapahtuu painamalla Show-nappia, minkä jälkeen tähtikartta avautuu erillisessä ikkunassa kuution sisällä. 

2.2. Tähtikartan alkutila

Alkutilassa tähtikarttaikkunassa näytetään tasasivuinen kuutio avaruutta, jonka keskipiste on Otavan tähtikuvion keskipisteessä, ja jonka etusivu on 65 asteen levyinen kaistale pohjoisen pallonpuoliskon tähtitaivasta. Kaistaleen astemäärä on samankokoinen riippumatta koordinaatimuunnoksista. 

2.3 Tähtien kirkkaus tähtikartassa

Tähdet esitetään valkoisina palloina, joiden halkaisija on riippuvainen visuaalisesta magnitudista tarkkailupaikasta käsin. Näytetään vain tähdet joiden visuaalinen  magnitudi on 8 tai pienempi. 

3. Käyttöliittymä 

Käyttöliittymä aktivoituu uudestaan vain tähtikartan sulkemisen jälkeen. 

Käyttöliittymä on ikkuna jossa on seuraavat komponentit.

3.1. Show-nappi

Avaa 3d tähtikartan alkutilassa. Katso kohta 2.1 ja 2.2. 

3.2. Kuution keskipisteen koordinaatit

Kuution keskipisteen koordinaatit näytetään sekä kartesiolaisessa- että pallokoordinaatistossa. Niitä voi myös editoidä käsin. Editointi lopetetaan painamalla enter. Editoidusta koordinaatista riippuvat koordinaatit päivittyvät heti editoinnin loputtua. 

Mikäli tarkkailupiste on nollapisteessä (aurinkokunnassa), niin tarkkailupiste ei siirry mikäli kuution keskipisteen astelukua muutetaan. Tällöin kuutio vain kiertää aurinkokuntaa. Mikäli tarkkailupiste ei ole nollapisteessä, tarkkailupiste siirtyy aina samaan suuntaan kun kuution keskipiste. 

3.3. Kuution pyörittäminen

Mikäli valintalaatikko "rotate" on valittu, tähtikartta pyörii näytettäessä samanaikaisesti y- ja z-akseleiden ympäri. Käännös on 0.25 
astetta per iteraatioaskel, iteraatioaskeleen nopeus riippuu tietokoneen laskentatehosta ja siitä kuinka monta tähteä kuutioon on jaettu. 

3.3 Tarkkailupisteen koordinaatit

Tarkkailupisteen koordinaatit näytetään sekä kartesiolaisessa- että pallokoordinaatistossa. Niitä voi myös editoida käsin. Editointi lopetetaan painamalla enter. Editoidusta koordinaatista riippuvat koordinaatit päivittyvät heti editoinnin loputtua. 

3.4. Kuution sivun pituus parsekeina

Voi editoida käsin. Mikäli kuution sivun pituutta muutetaan, tarkkailupiste siirtyy niin, että kuutio näyttää yhä saman kokoiselta. Kuution keskipiste ei liku. 

II) Rakenne

1. Package com.joml.Matrix3f

Lainattu Jawa OpenGL Math Library, 3x3 matriiseja, 1 itse lisätty metodi

2. Package com.joml.Vector

Lainattu Jawa OpenGL Math Library, 3 komponentin vektor, itse lisättyjä metodeja mm. koordinaattimuunnoksia

3. package gui

Käyttöliittymä

4. package lwjglwrapper

Enkapsuloitu LWJGL-kirjaston käyttöliittymä

5. package starmap

5.1 Star.java

Yksittäiseen tähteen liittyvät toiminnallisuudet

5.2 StarCube.java

Kuutio, johon tähdet ladataan ja sen muutokset. 

5.3. StarFrame.java

Toteuttaa lwjglwrapper-paketin määrittelemän interfacen

5.4. StarGLoop.java

Star Graphic Loop, olio joka piirtää grafiikat. 

5.5. StarSet.java

Määrittelee tähdet jotka kuuluvat näkymään ts. kuutioon. 

III) Käytetyt komponentit ja tietokannat

Ohjelma käyttää seuraavia vapaan lähdekoodin komponentteja ja tietokantoja

-Lighweight Jawa Game Library 3 (http://www.lwjgl.org/)

-Jawa OpenGL Math Library (https://github.com/RGreenlees/Java-OpenGL-Math-Library) by Richard Greenlees

-HYG Database of stars (http://astronexus.com/node/34) by David Nash 

-LWJGL example code http://www.lwjgl.org/guide





