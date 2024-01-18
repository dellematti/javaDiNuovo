se aggiungo qualcosa senza fare test, il commit è un verde diretto



test iterable, facciamo contains exactly e vedo che abbia gli elementi giusti



parto con player e faccio per prima cosa il test dell iteratore (non fondamentale ma lo faccio)













killall -9 java





# SECONDO PARZIALE

Il reference esccaping è probabilmente l errore PIÙ GRAVE da fare nel corso, controllare sempre perché boccia (e occhio sempre alle shallow copy)

NON fare che l interfaccia Presenter implementa ( o estende, non ricordo) l Observer.
Fare sempre interface segregation e tenerle separate, sarà il presenterConcreto (che implementa sempre l interfaccia Presenter) a implementare anche l interfaccia Observer in caso serva

***IMPORTANTE***
Per i parametri dei metodi, se non devono essere null, ha senso mettere  @NotNull nel intestazione del metodo (il prof lo preferisce)
Se un metodo viene chiamato da un altro metodo, se nel primo metodo ho già messo i notNull, è comunque meglio metterli anche nel secondo, per maggiore chiarezza.
E ancora meglio (sempre se serve) metterlo anche nel parametro della classe.
private @NotNull final Object nomeOggetto


Se lo stato è una tupla (come nell esame dei bagnini) meglio fare una classe che rappresenta lo stato, piuttosto che come avevo fatto io, fare due liste separate. (invece che fare lista bagnini e lista bandiere, meglio fare una classe Postazione che avrà al suo interno entrambe le cose)
In pratica pensare sempre bene a come rappresentare lo stato


Nell interfaccia Observable si possono mettere due getState diversi  getState1 e getState2, sia se i due state sono dello stesso tipo T, sia se sono di due tipi differenti



test di integrazione?


Sarebbe meglio evitare di fare un feature Model con dentro tutto ciò che riguarda il modello, troppo ampia. Meglio dividere di più, e fare feature più atomiche


Nelle classi che implementano l interfaccia, quando faccio l override dei metodi, i parametri devono chiaramente essere del tipo dichiarato nell interfaccia, ma POSSO cambiare i nomi rispetto a quelli dell interfaccia. Non deve essere per forza identico al 100% al metodo dell interfaccia


Può essere utile usare isBlank() invece di isEmpty() per controllare le stringhe vuote



Se devo fare dei controlli su un qualcosa in particolare, ad esempio In sapore di sale dovevo fare i controlli sul nome del bagnino, ha senso fare una classe/record Bagnino, che farà poi parte del Model





IMPORTANTE
Sono a 1.51.00 e
Per adesso i test del prof non controllano che quando arriva un bagnino o viene segnalata una bandiera, venga chiamato il corrispettivo metodo di Model, ( ha messo come commento la chiamata al metodo) perchè non esiste ancora Model.
Per ora controlla solo che ci sia showSuccess, o showError (o qualunque altra cosa)
Vedere se dopo, quando aggiunge i metodi di Model, va a modificare anche questi vecchi test (dato che ora in teoria i test non controllano mai che venga chiamato il metodo arriva/segnala)

A 2.06: ora ha cominciato a pensare al modello, e farà dei nuovi test per arriva e segnala. Anche se si verificano con le stesse condizioni di quando viene chiamato l action di presenter, faccio un test separato, dal "punto di vista" del Model.
Ovviamente stavolta controllerò direttamente il caso in cui l input sia valido, gli altri casi li ho controllati prima nei test del presenter.
(tra l altro questo è il senso della classe Bagnino, il presenter dovrà fare i test dato che riceve delle stringhe, Model invece riceverà un istanza di Bagnino, quindi per forza valida)

E invece no, per ora non copre mai la riga in cui chiama arriva(), nel test sta controllando che arriva() faccia la cosa giusta (ossia inserire il bagnino in Model)
Nel test sta poi chiamando arriva direttamente, fa subito SUT.arriva()
Testando arriva() testa anche il getter che usa per controllare





Se il test è verde posso chiudere una feature, se ho la feature controlliNome e ho fatto un controllo del nome, che ha un test verde, posso chiudere la feature (e magari poi aprirne un altra altriControlliNome in caso voglia aggiungere controlli in più?)






esempio di controllo di un add (e get)

``` java
@Test
void checkModelloArrivaBagnino () {
Model SUT = new Model();
final var bagnino = mock(Bagnino.class);
final var area = mock(Area.class);
SUT.arriva(bagnino, area);
// dove arriva crea una Postazione con bagnino e area
assertThat(SUT.getListPostazioni()).containsExactly(new Postazione(bagnino,                                                     area, BANDIERA.NONE));
// avrei potuto anche fare dei veri record Bagnino e Area invece del mock
}
// e occhio sempre agli equals e ricordarsi che nei record sono già fatti

```

2.24.22 ki


shallow copy di List ( per magari restituire una lista di oggetti immutabili):
return new ArrayList<> (postazioni.values());   // dove postazioni è la lista



2.42.20 arrivato
2.46












# lezione pre parziale...

I test di integrazione NON sono da fare alla fine. 
Appena iniziato a scrivere codice chiaramente non funzioneranno, ma appena si comincia ad avere una struttura sensata e con già alcune cose funzionanti, allora ha senso cominciare a provare i test d integrazione. Da quel punto in poi si può procedere di pari passo tra controllare i test d integrazione e sviluppare codice.

Può essere una buona partenza, cercare qualche funzionalità utile che però coinvolge meno elementi possibile. Ad esempio gestire un errore di input da parte dell utente permette rapidamente di fare un test di integrazione funzionante.

git push
git -- tags


CORREZIONE LISTA DELLA SPESA PROF

Prima cosa che fa parte dall inputView, fa inputPresenter e testa un caso di errore.
Testa ad esempio la chiamata di     SUT.action ( "" ,  "2" ) ;  con come parametro una stringa vuota.
Testiamo mockando la view, che venga chiamato showError.





Una volta fatti tutti i controlli, (nel presenter), è uno spreco dover ripetere tutti i controlli nel Model ( perchè il Model ha il metodo addItem() che può essere chiamato anche da altri Presenter fatti male , o con intenzioni negative )

Quindi nel test di showCorrectInput di presenter (cioé action), potrei controllare che venga chiamato il showSuccess() della view mockata, e il addItem() del Model mockato

Fatto così però il modello dovrebbe appunto ricontrollare la validità dei parametri che riceve in addItem( ).
Quindi invece di passargli le due stringhe, posso creare un record ItemQuantity, a quel punto so che se l oggetto esiste, allora rispetta per forza l invariante che abbiamo deciso

Nel test verificherò quindi:
```

verify(model.addItem(new ItemQuantity(text,num)))

```

e il Presenter non dovrà fare lui i controlli, proverà in un try solo a costruire l oggetto, se la cosa non funziona allora riporta su showError il messaggio dell eccezione

``` java
try{
	model.addItem(new ItemQuantity(text, Integer.parseInt(text1)));
	view.showSuccess():
}catch (NumberFormatException e) {
	view.showError("not a number);
} catch (IllegalArgumentException e) {
	view.showError(e.getMessage());
}

```
Devo fare due catch diversi perchè un eccezione potrebbe essere sollevata anche da Integer.parseInt() in caso li venga passato qualcosa diverso da un numero.
Questo perchè questo try è dentro il metodo action che riceve due Stringhe, ma il costruttore di ItemQuantity riceve una Stringa e un int







(se cambio ad esempio aggiungo un parametro al costruttore, se i vecchi test non passano più perchè si basavano sul costruttore con un parametro in meno, devo sistemare ovunque il codice per risolvere. Se sono in stato di rosso lo posso fare liberamente, se sono in stato verde lo considero come refactor)







***ULTIMO RIPASSO PRE PARZIALE***
Quando parto , posso magari partire dal Model, e scelgo la struttura dati, se la popolo usando dei record è comodo perchè tutto quel codice posso non testarlo, posso inoltre direttamente andare avanti per quanto riguarda la parte di Observable del Modello.

In un unica feature (e anche in poco tempo) faccio in Modello: una struttura dati fatta da record non da testare, e implemento i pochi metodi di Observable con pochi test.
Devo decidere con attenzione però su che stato rendere Model osservabile. Se lo stato è un insieme di Oggetti (Stringhe Treni Bagnini...) è pericoloso passare solo quello modificato, passeremo l intera struttura. ( in pratica   Model implements Observable < List< Qualcosa>>  )
Se lo stato è rappresentato con una Mappa, posso renderlo osservabile su quello ma forse conviene comunque renderlo osservabile su una lista

L interfaccia Observable posso metterla che fa parte del Modello, l interfaccia Observer che fa parte del Presenter

E METTERE NOTNULL, anche sulle intestazioni dei metodi dell interfaccia:
@NotNull T getState( );


Possiamo quindi partire con i test del Modello, il primo semplice
```java
Model SUT = new Model;
assertThat(SUT.getState()).isEmpty();
```
questo test serve giusto per vedere che Model abbia unno stato, anche se non ancora usato. L importante è quindi che non restituisca null

Se ho una mappa e nel getState restituisco una Lista dei valori, se uso mappa.values( ) quella NON è una copia, ma sono direttamenti gli oggetti della mappa.
Devo restituire comunque una nuova lista   return new ArrayList(mappa.values( ) );
(questo comunque sempre se i values sono immutabili, altrimenti non va bene)


sono arrivato a 46












