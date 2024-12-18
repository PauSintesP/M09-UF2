# Activitat 01: Programació de Fils

### Comportament 1
Execució intercalada entre els fils, amb pauses aleatòries.

![image](https://github.com/user-attachments/assets/1b4da152-8550-4a48-ad0e-8ea3bfca0b6f)


### Comportament 2
Execució predominant d'un fil abans que l'altre ("Pepe" abans que "Juan").

![image](https://github.com/user-attachments/assets/e0c04e11-38d3-4b26-9571-52b914b1bf20)


### Comportament 3
Execució estrictament alternada entre els fils, sincronitzada amb `wait()` i `notify()`.

![image](https://github.com/user-attachments/assets/f6d6c51b-05d5-484a-b322-d15779eb960f)


## Resultats obtinguts

- **Comportament 1**: S'ha aconseguit una execució intercalada aleatòria, encara que pot variar lleugerament en diferents execucions.
- **Comportament 2**: L'ordre d'execució prioritza "Pepe" abans de "Juan".
- **Comportament 3**: Els fils s'executen de forma estrictament alternada seguint l'ordre esperat.

## Notes addicionals
- La sincronització del comportament 3 pot requerir diverses execucions per verificar-ne el funcionament correcte.
- L'ordre d'execució en els comportaments 1 i 2 pot variar lleugerament segons la planificació del sistema operatiu.
