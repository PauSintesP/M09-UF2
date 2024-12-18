# Activitat 01: Programació de Fils

### Comportament 1
Execució intercalada entre els fils, amb pauses aleatòries.

![image](https://github.com/user-attachments/assets/1b4da152-8550-4a48-ad0e-8ea3bfca0b6f)


### Comportament 2
Execució predominant d'un fil abans que l'altre ("Pepe" abans que "Juan").

#### Sortida esperada:
```
Termina thread main
Pepe 1
Pepe 2
...
Pepe 9
Juan 1
Juan 2
...
Juan 9
Termina el fil Pepe
Termina el fil Juan
```

### Comportament 3
Execució estrictament alternada entre els fils, sincronitzada amb `wait()` i `notify()`.

#### Sortida esperada:
```
Termina thread main
Juan 1
Pepe 1
Juan 2
Pepe 2
...
Juan 9
Pepe 9
Termina el fil Pepe
Termina el fil Juan
```

## Resultats obtinguts

- **Comportament 1**: S'ha aconseguit una execució intercalada aleatòria, encara que pot variar lleugerament en diferents execucions.
- **Comportament 2**: L'ordre d'execució prioritza "Pepe" abans de "Juan".
- **Comportament 3**: Els fils s'executen de forma estrictament alternada seguint l'ordre esperat.

## Notes addicionals
- La sincronització del comportament 3 pot requerir diverses execucions per verificar-ne el funcionament correcte.
- L'ordre d'execució en els comportaments 1 i 2 pot variar lleugerament segons la planificació del sistema operatiu.

