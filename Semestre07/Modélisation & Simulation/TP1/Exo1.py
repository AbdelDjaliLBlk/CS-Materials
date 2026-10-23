def moore(E):
    etat = "A"
    sorties = []
    for e in E:
        if etat == "A":
            etat = "B" if e == 0 else "A"
        elif etat == "B":
            etat = "B" if e == 0 else "C"
        elif etat == "C":
            etat = "B" if e == 0 else "D"
        elif etat == "D":
            etat = "F" if e == 0 else "A"
        elif etat == "F":
            etat = "B" if e == 0 else "C"

        sorties.append(1 if etat == "F" else 0)
    return sorties


def mealy(E):
    etat = "A"
    sorties = []
    for e in E:
        s = 0
        if etat == "A":
            etat = "B" if e == 0 else "A"
        elif etat == "B":
            etat = "B" if e == 0 else "C"
        elif etat == "C":
            etat = "B" if e == 0 else "D"
        elif etat == "D":
            if e == 0:
                s = 1     
                etat = "B"
            else:
                etat = "A"
        sorties.append(s)
    return sorties


E = [0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0]
print("E     =", *E)
print("Moore =", *moore(E))
print("Mealy =", *mealy(E))
