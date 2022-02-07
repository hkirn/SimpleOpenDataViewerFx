# SimpleOpenDataViewerFx
A Simple Viewer for Dataset "bfrk-barrierefreiheit-an-bw-bahnhoefen" from MobiDataBW/NVBW

Bei der Software "SimpleOpenDataViewerFx" handelt es sich um eine Software, die den Datensatz "Barrierefreiheit an BW-Bahnhöfen" 
(https://www.mobidata-bw.de/dataset/bfrk-barrierefreiheit-an-bw-bahnhoefen) von "MobiData BW" herunter lädt und diesen visualisiert.

Die Daten werden bei jedem Start der Software neu synchronisiert und die Bilder werden bei Bedarf nachgeladen, die Software ist also 
auf eine dauerhafte Onlineverbindung angewiesen. Die Daten werden direkt von "MobiDataBW" heruntergeladen, es werden keine zusätzlichen
Server oder Clouddienste eingesetzt.

Für Windows wird ein ZIP-File mit allen erforderlichen Librarys zur Verfügung gestellt, auf anderen Betriebssystemen sollte die
bereitgestellte jar-Datei ebenfalls einsetzbar sein. Das ist aber im Moment noch nicht getestet. Es wird Java in der Version 17 benötigt.

Nach dem Start den benötigten Bahnhof auswählen, in der Suchfunktion können Sie nach Ortsnamen filtern. Bitte hierbei beachten, dass
die Suchfunktion wirklich nur Ortsnamen berücksichtigt, statt z.B. "Österfeld" müssen Sie "Stuttgart" suchen.
Nach der Auswahl des ersten Orts führt "OpenDataViewerFx" eine komplette Synchronisation der Dateh durch, es werden ca. 2MB heruntergeladen
und in eine nutzbare Datenstruktur umgewandelt. Dieser Vorgang kann je nach Bandbreite und Rechenleistung ca. 5-20 Sekunden dauern.

Nach erfolgreicher Synchronisation können Sie mit den Buttons auf der linken Seite die benötigten Informationen auswählen. Auf der rechten
Seite werden die Daten dargestellt. Je nach Auswahl sind mehrere Bilder und GPS-Positionen verfügbar.

Bitte beachten Sie, dass der Datensatz im Moment nicht zu jedem Bahnhof Bilder enthält. Die Software zeigt Ihnen dann eine Karte von
OpenStreetMaps mit der Position des gewählten Objekts an.

Diese Software und der genutzte Datensatz können Fehler enthalten. Ich möchte darauf hinweisen, dass ich keinerlei Haftung übernehme.
Diese Software ist noch in einem sehr frühen Stadium, es können noch Fehler vorhanden sein!

Bei Fragen können Sie mich unter sodw@kirn-net.de erreichen.
