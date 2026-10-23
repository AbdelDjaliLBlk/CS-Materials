def moore(code):
    sorties = []
    etat = "A"
    #if len(code) != 4 : return []
    for c in code :
        if etat == "A":
            etat = "B" if c == 0 else "A"
        elif etat == "B":
                etat = "C" if c == 9 else "A"
        elif etat == "C":
            etat = "D" if c == 1 else "A"
        elif etat == "D":
            etat = "F" if c == 5 else "A"
        elif etat == "F":
            etat = "A" if c == 0 else "B" 
        sorties.append(1 if etat=="F" else 0)
    return sorties


def mealy(code):
    etat = "A"
    sorties = []
    for c in code:
        s = 0
        if etat == "A":
            etat = "B" if c == 0 else "A"
        elif etat == "B":
            etat = "C" if c == 9 else "A"
        elif etat == "C":
            etat = "D" if c == 1 else "A"
        elif etat == "D":
            if c == 5:
                s = 1     
                etat = "A"
            else:
                etat = "B"
        sorties.append(s)
    return sorties

code = [0, 9, 1, 5]
print("Code = ",*code)
print("Moore = ",*moore(code))
print("Mealy = ",*mealy(code))
                