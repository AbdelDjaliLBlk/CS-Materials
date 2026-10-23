W = 10
items = [{"id": 1, "v": 5, "w": 2},
        {"id": 4, "v": 6, "w": 3},
        {"id": 3, "v": 7, "w": 4},
        {"id": 2, "v": 8, "w": 5}
        ]

def heuristic_max_value(items, capacity):
    sorted_items = sorted(items, key=lambda x: x["v"], reverse=True)
    total_val, rem_w, selected = 0, capacity, []
    for item in sorted_items:
        if item["w"] <= rem_w:
            selected.append(item["id"])
            total_val += item["v"]
            rem_w-= item["w"]
    return total_val, capacity- rem_w, selected

def heuristic_min_weight(items, capacity):
    sorted_items = sorted(items, key=lambda x: x["w"])
    total_val, rem_w, selected = 0, capacity, []
    for item in sorted_items:
        if item["w"] <= rem_w:
            selected.append(item["id"])
            total_val += item["v"]
            rem_w-= item["w"]
    return total_val, capacity- rem_w, selected

def heuristic_ratio(items, capacity):
    sorted_items = sorted(items, key=lambda x: x["v"] / x["w"], reverse=True)
    total_val, rem_w, selected = 0, capacity, []
    for item in sorted_items:
        if item["w"] <= rem_w:
            selected.append(item["id"])
            total_val += item["v"]
            rem_w-= item["w"]
    return total_val, capacity- rem_w, selected

def compute_upper_bound(idx, current_val, remaining_cap, sorted_items, msg = True):
    if remaining_cap < 0: 
        return-1.0 # Noeud inadmissible
    bsup = float(current_val)
    cap = remaining_cap
    # TODO 1 :
    for item in sorted_items[idx:]:
        if item["w"] <= cap:
            bsup += item["v"]
            cap -= item["w"] 
        else:
            fraction = cap * (item["v"]/item["w"])
            bsup += fraction
            if msg : print(f"* Objet Critique:[ Obj{item["id"]}, Fraction: {fraction:.2f} ]")
            break
    return bsup


if __name__ == "__main__":
#   === Partie01 ===
    # Question 01 :
    print("=== Part I : heuristics (W=10) ===")
    print("* Heuristique Poids: ",heuristic_min_weight(items,W))
    print("** Heuristique Valeurs :",heuristic_max_value(items,W))
    print("*** Heuristique Ratio:",heuristic_ratio(items,W))

    # Question 02 :
    # L'heuristique basée sur le ration fournit la meilleure borne infèrieur car
    # il prend en compte le poids et la valeurs en meme temps , donc en maximise 'Binf'
    
#   === Partie 02 ===
    s = sorted(items, key=lambda x: x["v"] / x["w"], reverse=True)
    
    print("\n=== Part II : Upper Bounds ===")
    print("** Bsup = ",compute_upper_bound(0,0,W,s))
    print(f"*** Bsup(x1 = 0) = ",compute_upper_bound(1,0,W,s))
    
