Käyttöhjeet 24.2.2015

Jar-tiedosto löytyy jar-kansiosta. Se on rakennettu ilmaisen JarSplice-ohjelman avulla, ja lwjgl native library on pakattu mukaan. 

Ohjelman toimiminen edellyttää että tiedosto hygdata_v3.csv jossa on tiedot tähdistä on samassa kansiossa ohjelman kanssa. 

Ohjelman pitäisi tällöin toimia normaalisti.

java -jar Starmapfat.jar

Tällöin avautuu käyttöliittymä, jolla voi hallita tähtinäkymää. "Show"-nappainta painamalla saa esiin tähtinäkymän, siinä on 66 askeleen levynen kappale pohjoista tähtitaivasta jossa on Otava. Näkymä pyörii jos valintalaatikko "rotate" on valittu. 

Tähtinäkymää avaessa ohjelma tulostaa kuution sisään osuneiden tähtien perinteiset nimet stdoutputiin, tämä toiminto on debuggausta varten ja se poistetaan palautusversiosta. Vain harvoilla tähdillä on perinteisiä nimiä. 

Ylimmällä rivillä voi editoida kuution keskipisteen koordinaattia avaruudessa, siinä on sekä kartesiolaiset että pallokoordinaatit. Nämä riippuvat toisistaan, ja siksi muutkin koordinaatit voivat muuttua yhtä koordinaattia muuttaessa (editoinnin lisäksi pitää painaa "Enter").

Koordinaatit ovat tähtitieteellisissä yksiköissä - x y z ja etäisyys ovat parsekeissa (noin 3.26 valovuotta), deklinaatio (declination) eli korkeus tähtitaivaalla pystysuunnassa on välillä -90, 90 ja rektaskensio (right ascension) eli tähtitaivaan sivusuuntainen mittayksikkö on välillä 0, 24. Rektaskension mittayksikkö on tunnit, eli tunnissa tähtitaivas pyörähtää yhden yksikön verran. 

24.2.2015 tilanne: 

Kuutiota ei voi kääntää ja vain keskipisteen koordinaattia voi muuttaa. Tämän vuoksi mikäli kuutiota siirtää, se ei enää näytä tähtitaivasta sellaisena kun se näkyy maapallolta. Tarkkailupiste on maapallolla ainoastaan alkutilassa. 

Tarkkailupistettä ei voi editoida, kuution reunan pituus ei näy ollenkaan. 


