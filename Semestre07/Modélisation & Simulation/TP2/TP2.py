OMEGA = float("inf")  # ω : "autant de jetons qu'on veut"


def fmt(m):
    """Affiche un marquage, ex: (1,0,ω)"""
    return "(" + ",".join("ω" if x == OMEGA else str(x) for x in m) + ")"


# ============================================================
# EXERCICE 1 : structure de données
# ============================================================
class ReseauPetri:
    def __init__(self, places, transitions):
        self.places = places
        self.transitions = transitions
        self.pre = {}   # pre[(p, t)]  = poids de la flèche p -> t
        self.post = {}  # post[(p, t)] = poids de la flèche t -> p

    def ajouter_arc(self, source, cible, poids=1):
        if source in self.places:           # place -> transition : Pré
            self.pre[(source, cible)] = poids
        else:                               # transition -> place : Post
            self.post[(cible, source)] = poids

    # a) transitions de sortie d'une place
    def transitions_sortie_place(self, p):
        return [t for t in self.transitions if (p, t) in self.pre]

    # b) transitions d'entrée d'une place
    def transitions_entree_place(self, p):
        return [t for t in self.transitions if (p, t) in self.post]

    # c) places de sortie d'une transition
    def places_sortie_transition(self, t):
        return [p for p in self.places if (p, t) in self.post]

    # d) places d'entrée d'une transition
    def places_entree_transition(self, t):
        return [p for p in self.places if (p, t) in self.pre]

    # --------------------------------------------------------
    # Outils pour l'exercice 2
    # --------------------------------------------------------
    def franchissable(self, m, t):
        """t peut être tirée si chaque place a assez de jetons"""
        return all(m[i] >= self.pre.get((p, t), 0) for i, p in enumerate(self.places))

    def franchir(self, m, t):
        """Nouveau marquage après avoir tiré t"""
        return tuple(m[i] - self.pre.get((p, t), 0) + self.post.get((p, t), 0)
                     for i, p in enumerate(self.places))


# ============================================================
# EXERCICE 2.1 : arborescence des marquages atteignables
# (marche pour les réseaux bornés ET non bornés)
# ============================================================
def arborescence(reseau, m0):
    # chaque noeud : marquage, parent, transition utilisée, état
    noeuds = [{"m": m0, "parent": None, "t": None, "etat": ""}]
    vus = {m0: 0}   # marquages déjà explorés
    file = [0]      # noeuds à traiter

    while file:
        i = file.pop(0)
        m = noeuds[i]["m"]

        # marquages des ancêtres (et de lui-même), pour détecter ω
        chemin, j = [], i
        while j is not None:
            chemin.append(noeuds[j]["m"])
            j = noeuds[j]["parent"]

        actives = [t for t in reseau.transitions if reseau.franchissable(m, t)]
        if not actives:
            noeuds[i]["etat"] = "bloqué"

        for t in actives:
            m2 = reseau.franchir(m, t)

            # si m2 > un ancêtre, les places qui ont grandi passent à ω
            for a in chemin:
                if m2 != a and all(x >= y for x, y in zip(m2, a)):
                    m2 = tuple(OMEGA if x > y else x for x, y in zip(m2, a))

            noeuds.append({"m": m2, "parent": i, "t": t, "etat": ""})
            k = len(noeuds) - 1
            if m2 in vus:
                noeuds[k]["etat"] = "déjà vu"   # on n'explore pas plus loin
            else:
                vus[m2] = k
                file.append(k)
    return noeuds


def afficher_arbre(noeuds, i=0, niveau=0):
    n = noeuds[i]
    debut = "    " * niveau + (f"--{n['t']}--> " if n["t"] else "")
    print(debut + fmt(n["m"]) + (f"  [{n['etat']}]" if n["etat"] else ""))
    for j, f in enumerate(noeuds):
        if f["parent"] == i:
            afficher_arbre(noeuds, j, niveau + 1)


# ============================================================
# EXERCICE 2.2 : graphe des marquages (sans répétitions)
# ============================================================
def graphe(noeuds):
    etats = list(dict.fromkeys(n["m"] for n in noeuds))
    arcs = []
    for n in noeuds[1:]:
        arc = (noeuds[n["parent"]]["m"], n["t"], n["m"])
        if arc not in arcs:
            arcs.append(arc)
    return etats, arcs


def analyser(nom, reseau, m0):
    print("=" * 50)
    print("Réseau", nom, "- marquage initial :", fmt(m0))
    print("Places :", reseau.places)

    noeuds = arborescence(reseau, m0)
    print("\n--- Arborescence ---")
    afficher_arbre(noeuds)

    etats, arcs = graphe(noeuds)
    print("\n--- Graphe ---")
    print("États :", [fmt(e) for e in etats])
    for a, t, b in arcs:
        print(f"  {fmt(a)} --{t}--> {fmt(b)}")

    borne = all(OMEGA not in e for e in etats)
    print("\nRéseau borné ?", "OUI" if borne else "NON (présence de ω)")


# ============================================================
# EXERCICE 3 : les deux réseaux
# ============================================================
def reseau_a():
    r = ReseauPetri(["P1", "P2", "P3"], ["T1", "T2", "T3", "T4"])
    r.ajouter_arc("P1", "T1"); r.ajouter_arc("T1", "P2")
    r.ajouter_arc("P2", "T2"); r.ajouter_arc("T2", "P1")
    r.ajouter_arc("P1", "T3"); r.ajouter_arc("P2", "T3")
    r.ajouter_arc("T3", "P3", 2)   # poids 2 (à vérifier sur ta feuille)
    r.ajouter_arc("P3", "T4"); r.ajouter_arc("T4", "P1")
    return r, (1, 1, 0)


def reseau_b():
    r = ReseauPetri(["p1", "p2", "p3", "p4", "p5"], ["t1", "t2", "t3", "t4"])
    r.ajouter_arc("p2", "t2"); r.ajouter_arc("t2", "p1")
    r.ajouter_arc("p1", "t1"); r.ajouter_arc("p3", "t1"); r.ajouter_arc("p4", "t1")
    r.ajouter_arc("t1", "p2")
    r.ajouter_arc("p5", "t3")
    r.ajouter_arc("t3", "p3"); r.ajouter_arc("t3", "p4")
    r.ajouter_arc("p4", "t4"); r.ajouter_arc("t4", "p5")
    return r, (0, 1, 0, 1, 0)


if __name__ == "__main__":
    # --- Test de l'exercice 1 sur le réseau (b) ---
    rb, mb = reseau_b()
    print("Ex1 - réseau (b)")
    print("a) sorties de p4 (transitions) :", rb.transitions_sortie_place("p4"))
    print("b) entrées de p4 (transitions) :", rb.transitions_entree_place("p4"))
    print("c) sorties de t3 (places)      :", rb.places_sortie_transition("t3"))
    print("d) entrées de t1 (places)      :", rb.places_entree_transition("t1"))
    print()

    # --- Exercices 2 et 3 ---
    ra, ma = reseau_a()
    analyser("(a)", ra, ma)
    print()
    analyser("(b)", rb, mb)