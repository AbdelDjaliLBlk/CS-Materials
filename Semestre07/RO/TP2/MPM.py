tasks = { 
    "A": {"duree": 3, "anterieurs": []}, 
    "B": {"duree": 7, "anterieurs": ["A"]}, 
    "C": {"duree": 6, "anterieurs": ["B"]}, 
    "D": {"duree": 4, "anterieurs": ["C"]}, 
    "E": {"duree": 5, "anterieurs": ["C"]}, 
    "F": {"duree": 3, "anterieurs": ["C"]}, 
    "G": {"duree": 4, "anterieurs": ["D", "E", "F"]}, 
} 

def calcul_PT(tasks): 
    PT = {} 
    for task, info in tasks.items(): 
        preds = info["anterieurs"] 
        if preds == []: 
            PT[task] = 0 
        else: 
            # calculer le max des (PT du prédécesseur + durée) 
            # PT[task] = max(PT[p] + tasks[p]["duree"] for p in preds) 
            PT[task] = 1   
    return PT 

def calcul_PTd(tasks, PT): 
    PTd = {} 
 
    # trouver la tâche de fin (celle avec PT + durée max) 
    # et initialiser son PTd avec PT[task] 
    # Exemple : end_task = max(PT, key=lambda t: PT[t] + tasks[t]["duree"]) 
 
    end_task = 1   
    project_duree = PT[end_task] + tasks[end_task]["duree"] 
    PTd[end_task] = PT[end_task] 
 
    # construire la liste des successeurs de chaque tâche 
    successors = {} 
    for t in tasks: 
        successors[t] = [x for x in tasks if t in tasks[x]["anterieurs"]] 
    # propager les calculs en arrière 
    # PTd[i] = min(PTd[j] - duree[i]) pour tous les successeurs j 
    for task in reversed(list(tasks.keys())): 
        if task == end_task: 
            continue 
        if successors[task]: 
            PTd[task] = min(0) 
        else: 
            PTd[task] = PT[task] 
    return PTd, project_duree 

def compute_margins(PT, PTd): 
    MT = {} 
    for t in tasks: 
        MT[t] = PTd[t] - PT[t] 
    return MT

def main(): 
    PT = calcul_PT(tasks) 
    PTd, total = calcul_PTd(tasks, PT) 
    MT = compute_margins(PT, PTd) 
 
    print(f"Durée totale du projet : {total} jours\n") 
    print("Tâche | PT | PTd | Marge") 
    for t in tasks: 
        print(f"{t:<5} | {PT[t]:<3} | {PTd[t]:<3} | {MT[t]}") 
    critical_path = [t for t in tasks if MT[t] == 0] 
    print("\nChemin Critique :", " → ".join(critical_path)) 


if __name__ == "__main__": 
    main() 