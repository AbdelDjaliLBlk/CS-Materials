from Sac_Dos import *

class BranchAndBound:
    def __init__(self, items, capacity, initial_lb=18):
        # Tri obligatoire par densite decroissante
        self.items = sorted(items, key=lambda x: x["v"]/x["w"], reverse=True)
        self.W = capacity
        self.best_val = initial_lb # Borne inferieure courante (Binf)
        self.best_sol = []
        self.nodes = 0

    def solve(self):
        self._dfs(idx=0, current_val=0, rem_cap=self.W, taken=[])
        return self.best_val, self.best_sol, self.nodes

    def _dfs(self, idx, current_val, rem_cap, taken):
        self.nodes += 1

        # 1. Mise a jour si une meilleure solution entiere admissible est trouvee
        if current_val > self.best_val:
            self.best_val = current_val
            self.best_sol = list(taken)

        # Condition d’arret : toutes les variables ont ete decidees
        if idx >= len(self.items):
            return
        
        bsup = compute_upper_bound(idx,current_val,rem_cap,self.items,False)
        
        # Si bsup <= self.best_val, interrompre l’exploration de cette branche.
        if bsup <= self.best_val:
            return
        
        item = self.items[idx]
        if rem_cap >= item["w"]: 
            taken.append(item["id"])
            self._dfs(idx + 1, current_val + item["v"], rem_cap - item["w"], taken)
            taken.pop()

        self._dfs(idx + 1, current_val, rem_cap, taken)


if __name__ == "__main__":
    #   === Partie 03 ===
    print("\n=== Part III : Branch & Bound ===")
    print("Binf = 18 ->\n", BranchAndBound(items, W, 18).solve())
    print("Binf = 0  ->\n", BranchAndBound(items, W, 0).solve())

