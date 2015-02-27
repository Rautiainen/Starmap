Käyttöhjeet 24.2.2015

Jar-tiedosto löytyy jar-kansiosta. Se on rakennettu ilmaisen JarSplice-ohjelman avulla, ja lwjgl native library on pakattu mukaan. 

Ohjelman toimiminen edellyttää että tiedosto hygdata_v3.csv jossa on tiedot tähdistä on samassa kansiossa ohjelman kanssa. 

Ohjelman pitäisi tällöin toimia normaalisti.

java -jar Starmapfat.jar

Tällöin avautuu käyttöliittymä, jolla voi hallita tähtinäkymää. "Show"-nappainta painamalla saa esiin tähtinäkymän, siinä on 65 askeleen levynen kappale pohjoista tähtitaivasta jossa on Otava. Näkymä pyörii jos valintalaatikko "rotate" on valittu. 

Ylimmällä rivillä voi editoida kuution keskipisteen koordinaattia avaruudessa, siinä on sekä kartesiolaiset että pallokoordinaatit. Nämä riippuvat toisistaan, ja siksi muutkin koordinaatit voivat muuttua yhtä koordinaattia muuttaessa (editoinnin lisäksi pitää painaa "Enter").

Koordinaatit ovat tähtitieteellisissä yksiköissä - x y z ja etäisyys ovat parsekeissa (noin 3.26 valovuotta), deklinaatio (declination) eli korkeus tähtitaivaalla pystysuunnassa on välillä -90, 90 ja rektaskensio (right ascension) eli tähtitaivaan sivusuuntainen mittayksikkö on välillä 0, 24. Rektaskension mittayksikkö on tunnit, eli tunnissa tähtitaivas pyörähtää yhden yksikön verran. 

Demoja: 

1) Seulaset (avoin tähtijoukko Härän tähtikuviossa). Aseta ensin declination =24, paina enter. sitten right ascension = 3.750, paina enter. Sitten distance = 123 (parsekia), paina enter. Sitten valitse checkbox "rotate" ja paina "show". 

2) Aurinkokunnan ympäristö lähiavaruudessa. Käynnistä uudestaan. Aseta edgelength = 70 (parsekia), valitse checbox rotate ja paina "show". Nyt aurinko osuu laatikon sisään, Otava tuskin erottuu koska aurinkokunnasta ollaan matkattu 74 parsekia vastakkaiseen suuntaan. 

3) Linnunrata. Käynnistä uudestaan. Aseta edgelength = 2000 (parsekia), valitse checkbox = rotate ja valitse "show". Olemme matkustaneet etäälle ja vain tietokannan kaikista kirkkaimmat tähdet näkyvät. Ne ovat kuitenkin selvästi kiekkomaisessa muodostelmassa. Linnunradan halkaisia pystysuunnassa on n. 600 parsekia. 


