# AC1 – Simulador d'objectes

## Simulació, entrada per teclat i persistència en fitxer

Durant les darreres sessions hem començat a desenvolupar un petit simulador format per boles que es mouen dins d'una àrea rectangular.

Fins ara, les boles s'han creat directament des del codi Java. En aquesta activitat ampliarem el programa perquè l'estat inicial de la simulació es pugui **carregar des d'un fitxer**, l'usuari pugui **controlar la simulació des del teclat** i l'estat resultant es pugui **guardar novament en un fitxer**.

L'objectiu és continuar treballant els conceptes de classe, objecte, atribut, mètode, encapsulació i constructors, incorporant ara **entrada/sortida per consola i fitxers**.

---

## 1. Classe `Ball`

Cada objecte de la simulació tindrà, com a mínim, la informació següent:

- `id (int)`: identificador de la bola.
- `x (int)`: posició horitzontal.
- `y (int)`: posició vertical.
- `vx (int)`: velocitat horitzontal.
- `vy (int)`: velocitat vertical.
- `force (int)`: força de la bola.

Els atributs que representen l'estat intern de la bola han d'estar **encapsulats**.

### Constructors

La classe haurà de permetre, com a mínim:

- crear un objecte proporcionant els seus valors;
- crear un objecte a partir de les dades llegides del fitxer.

Per exemple, una línia:

```text
2,9,7,-1,1,9
```

representa:

```text
id = 2
x = 9
y = 7
vx = -1
vy = 1
force = 9
```

### Comportament

Cada objecte haurà de poder:

- indicar si ocupa una coordenada determinada;
- avançar segons la seva velocitat;
- modificar la seva direcció quan arriba als límits de l'àrea.

En cada unitat de temps:

```text
x = x + vx
y = y + vy
```

Una bola **no pot sortir de l'àrea de joc**. Quan arribi a una paret haurà de rebotar modificant el signe de la velocitat corresponent.

Per exemple:

```text
vx = 1
```

passarà a:

```text
vx = -1
```

si la bola rebota contra una paret vertical.

---

## 2. Classe `GameArea`

`GameArea` representa l'espai on es desenvolupa la simulació.

Com a mínim, ha de conèixer:

- l'amplada de l'àrea;
- l'alçada de l'àrea;
- l'instant actual de la simulació;
- els objectes que hi ha dins de l'àrea.

La simulació podrà contenir entre **1 i 9 objectes**.

Per emmagatzemar-los s'utilitzarà un array de `Ball`:

```java
Ball[] balls;
```

La mida de l'array dependrà del nombre d'objectes indicat al fitxer.

### Comportament mínim

`GameArea` haurà de permetre:

- carregar l'estat inicial;
- mostrar l'àrea per consola;
- simular **un instant de temps**;
- simular fins a un instant determinat;
- guardar l'estat actual en un fitxer.

Cada vegada que s'avança un pas de simulació:

1. totes les boles es mouen;
2. es comproven els rebots contra les parets;
3. l'instant actual augmenta en una unitat.

---

## 3. Fitxer d'estat

L'estat inicial es carregarà des d'un fitxer de text amb format CSV.

Per exemple, `simulation.csv`:

```text
# width,height,time,numberOfObjects
20,10,0,3

# id,x,y,vx,vy,force
1,3,3,1,1,10
2,9,7,-1,1,9
3,15,2,-1,0,7
```

La primera línia de dades indica:

```text
width,height,time,numberOfObjects
```

En l'exemple:

```text
20,10,0,3
```

indica una àrea de:

- amplada: `20`;
- alçada: `10`;
- instant inicial: `0`;
- nombre de boles: `3`.

Les línies següents descriuen un objecte cadascuna:

```text
id,x,y,vx,vy,force
```

Les línies buides i les línies que comencin per `#` s'han d'ignorar.

### Condicions mínimes de les dades

S'ha de comprovar, com a mínim, que:

- `width` i `height` siguin positius;
- hi hagi entre 1 i 9 objectes;
- l'identificador de cada objecte sigui únic;
- la posició inicial de cada objecte estigui dins de l'àrea;
- `vx` i `vy` tinguin valors entre `-1` i `1`;
- `force` sigui positiva.

Si el fitxer no es pot llegir o conté dades incorrectes, el programa ha de mostrar un missatge adequat i no finalitzar de manera inesperada.

---

## 4. Representació de l'àrea

L'estat actual de la simulació s'ha de poder representar per consola.

Per exemple:

```text
■■■ Simulation t=0 ■■■

--------------------
---1----------------
--------------------
---------2----------
--------------------
---------------3----
--------------------
--------------------
--------------------
--------------------
```

Una posició buida es pot representar amb:

```text
-
```

i cada objecte amb el seu identificador.

La representació exacta pot variar sempre que permeti identificar clarament la posició dels objectes.

---

## 5. Aplicació de consola

En iniciar el programa es carregarà l'estat de la simulació des del fitxer.

Després es mostrarà un menú similar al següent:

```text
■■■ Object Simulator ■■■

Time: 0
Objects: 3

1. Show simulation
2. Simulate one step
3. Simulate until...
4. Save simulation
5. Reload initial state
Q. Quit

Select an option:
```

### Opció 1 – Show simulation

Mostra l'estat actual de l'àrea i la posició de tots els objectes.

### Opció 2 – Simulate one step

Avança la simulació una unitat de temps.

Per exemple:

```text
Time: 3
```

passarà a:

```text
Time: 4
```

Tots els objectes s'hauran d'haver mogut una vegada.

Després de simular el pas es mostrarà el nou estat.

### Opció 3 – Simulate until...

Demana per teclat l'instant fins al qual es vol executar la simulació.

Per exemple:

```text
Current time: 4
Simulate until: 20
```

El programa executarà automàticament els passos necessaris fins arribar a:

```text
Time: 20
```

No es permet indicar un instant anterior a l'instant actual.

### Opció 4 – Save simulation

Guarda l'estat actual de la simulació en un fitxer.

El fitxer generat haurà d'utilitzar el mateix format que el fitxer d'entrada.

Per exemple, després de diversos passos:

```text
# width,height,time,numberOfObjects
20,10,12,3

# id,x,y,vx,vy,force
1,15,5,-1,1,10
2,7,3,1,-1,9
3,3,2,-1,0,7
```

Aquest fitxer ha de poder tornar-se a utilitzar posteriorment com a fitxer d'entrada de l'aplicació.

### Opció 5 – Reload initial state

Torna a carregar el fitxer inicial i reinicia la simulació amb les dades que conté.

### Opció Q – Quit

Finalitza l'aplicació.

---

## 6. Organització del programa

Com a mínim, el projecte haurà de contenir les classes:

```text
Ball
GameArea
Main
```

Les responsabilitats han d'estar repartides entre les classes.

Com a orientació:

- `Ball` representa l'estat i el comportament de l'objecte;
- `GameArea` representa i controla la simulació;
- `Main` gestiona principalment la interacció amb l'usuari.

No es considerarà una solució adequada implementar tota la funcionalitat directament dins de `main()`.

---

## 7. Col·lisions

Si després d'un moviment dos objectes ocupen la mateixa posició:

- l'objecte amb més `force` elimina la bola amb menys `force`;
- si les dues tenen la mateixa força, cap de les dues desapareix.

Exemple:

```text
Ball 1 -> force = 10
Ball 2 -> force = 7
```

Si col·lisionen:

```text
Ball 1 survives
Ball 2 disappears
```

A partir d'aquell moment l'objecte eliminat ja no participa en la simulació ni apareix a l'àrea.

> Nota: Primer assegura't que la càrrega, el moviment, els rebots, la simulació i el guardat funcionen correctament abans de treballar les col·lisions.

---

## 8. Lliurament

**Data límit:** 1 d'Octubre de 2026.

Entrega un ZIP amb el projecte IntelliJ que contingui, com a mínim:

1. `Ball.java`, `GameArea.java` i `Main.java`.
2. El fitxer `simulation.csv` utilitzat com a estat inicial.
3. Un exemple de fitxer generat per l'aplicació després d'una simulació.
4. El diagrama **UML** de les classes implementades.
5. Un `README.md` que inclogui:
   - una breu explicació de l'estructura del programa;
   - les principals decisions preses;
   - les validacions implementades;
   - les ampliacions realitzades, si n'hi ha;
   - si s'han utilitzat eines d'IA, per a què s'han utilitzat i quines indicacions o prompts s'han fet servir.

El programa s'ha de poder executar carregant el fitxer d'exemple entregat.
