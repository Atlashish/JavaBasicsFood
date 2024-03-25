Questo progetto Java è un semplice sistema di gestione di prodotti, utenti e vendite. Consiste in diverse classi e servizi che consentono di eseguire operazioni come caricare prodotti, aggiungere utenti, effettuare vendite e esportare dati su file CSV.

## Struttura del progetto 🛠️

Il progetto è organizzato nelle seguenti directory:

- '**src/main/java/com/atlashish/progettojava**': Contiene il codice sorgente Java.
- '**src/main/resources**': Contiene i file CSV per i prodotti, gli utenti e le vendite.

## Come Compilare ed Eseguire 🚀

Per generare il file .jar del progetto, è possibile utilizzare Apache Maven. Assicurati di avere Maven installato nel tuo sistema e poi esegui i seguenti comandi dalla root del progetto:

```bash
mvn clean package
```

Questo comando compila il codice sorgente, esegue i test e genera il file .jar all'interno della directory target.

Per eseguire il programma, utilizza il seguente comando:

```bash
java -jar target\nome-del-file.jar
```

## Utilizzo del Programma 🕹️

Il programma avvia un'interfaccia da riga di comando che consente di interagire con le seguenti funzionalità:

- 1: Caricare i prodotti disponibili.
- 2: Comprare un prodotto esistente.
- 3: Restituire un prodotto.
- 4: Aggiungere un nuovo utente.
- 5: Esportare un file CSV con i prodotti disponibili.
- 0: Uscire dal programma.

Segui le istruzioni visualizzate a schermo per utilizzare le varie funzionalità.

## Autore ✍🏼

- [@Atlashish](https://github.com/Atlashish/)



