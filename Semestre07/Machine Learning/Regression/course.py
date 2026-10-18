"""
GUIDE COMPLET MATPLOTLIB : points, droites, courbes, personnalisation
=====================================================================
Lance le fichier :  python graphes_matplotlib.py
Chaque section est une fonction qui sauvegarde une image dans le dossier "figures/".
Dans un notebook / en local, remplace fig.savefig(...) par plt.show() pour voir le graphe.

Installation :  pip install matplotlib numpy
"""
import os
import numpy as np
import matplotlib
matplotlib.use("Agg")            # enlève cette ligne pour afficher les fenêtres avec plt.show()
import matplotlib.pyplot as plt

os.makedirs("figures", exist_ok=True)

# ============================================================
# 0. LES BASES : Dérivés.
# ============================================================
def dy():
    p = np.poly1d([3, 2, 1])      # 3x² + 2x + 1
    dp = p.deriv()                # 6x + 2
    print(dp)                     # 6 x + 2
    print(dp(2))                  # 14

def save(fig, name):
    fig.savefig(f"figures/{name}.png", dpi=200, bbox_inches="tight")
    plt.close(fig)


# ============================================================
# 0. LES BASES : Figure et Axes
# ============================================================
# fig = la "feuille", ax = le "repère" (le graphe). On travaille TOUJOURS avec ax.
#   fig, ax = plt.subplots(figsize=(largeur, hauteur))
#   ax.plot(...), ax.scatter(...), ax.set_xlabel(...), ...
#   fig.savefig("nom.png", dpi=200)   ou   plt.show()


# ============================================================
# 1. POINTS
# ============================================================
def section_points():
    # --- 1.1 Points simples ---
    x = np.array([1, 2, 3, 4, 5])
    y = np.array([2, 4, 3, 7, 6])
    fig, ax = plt.subplots()
    ax.scatter(x, y)
    ax.set_title("Nuage de points simple")
    save(fig, "01_points_simples")

    # --- 1.2 Personnaliser les points ---
    fig, ax = plt.subplots()
    ax.scatter(
        x, y,
        s=150,                 # taille
        c="crimson",           # couleur
        marker="D",            # forme : o s ^ v D * + x p h
        edgecolors="black",    # couleur du contour
        linewidths=1.5,        # épaisseur du contour
        alpha=0.8,             # transparence (0 à 1)
        label="Mesures",
        zorder=3,              # ordre d'affichage (plus grand = devant)
    )
    ax.legend()
    save(fig, "02_points_personnalises")

    # --- 1.3 Couleur et taille selon les données (colormap) ---
    rng = np.random.default_rng(0)
    X, Y = rng.normal(size=(2, 100))
    valeur = X**2 + Y**2
    fig, ax = plt.subplots()
    sc = ax.scatter(X, Y, c=valeur, s=20 + 40 * valeur, cmap="viridis", alpha=0.8)
    fig.colorbar(sc, ax=ax, label="distance²")      # barre de couleurs
    save(fig, "03_points_colormap")

    # --- 1.4 Nommer des points (annotations) ---
    pts = {"A": (1, 2), "B": (4, 5), "C": (6, 1)}
    fig, ax = plt.subplots()
    for nom, (px, py) in pts.items():
        ax.plot(px, py, "ro")                       # "ro" = rond rouge
        ax.annotate(nom, (px, py), xytext=(6, 6), textcoords="offset points", fontsize=12)
    ax.set_xlim(0, 7); ax.set_ylim(0, 6)
    ax.grid(True, ls=":")
    save(fig, "04_points_nommes")

    # --- 1.5 Relier les points + polygone ---
    P = np.array([(1, 1), (5, 1), (4, 4), (2, 5)])
    P_ferme = np.vstack([P, P[0]])                  # on revient au 1er point
    fig, ax = plt.subplots()
    ax.plot(P_ferme[:, 0], P_ferme[:, 1], "o-", color="teal")
    ax.fill(P[:, 0], P[:, 1], alpha=0.2, color="teal")
    ax.set_aspect("equal")
    save(fig, "05_polygone")


# ============================================================
# 2. DROITES
# ============================================================
def section_droites():
    fig, ax = plt.subplots(figsize=(7, 5))

    # --- 2.1 Segment entre deux points A(1,1) et B(5,4) ---
    ax.plot([1, 5], [1, 4], "o-", color="navy", label="Segment AB")

    # --- 2.2 Droite d'équation y = a x + b ---
    a, b = 0.5, 1
    x = np.linspace(-1, 8, 100)
    ax.plot(x, a * x + b, color="green", label=f"y = {a}x + {b}")

    # --- 2.3 Droites horizontale et verticale ---
    ax.axhline(y=3, color="red", ls="--", label="y = 3")     # horizontale
    ax.axvline(x=4, color="purple", ls="-.", label="x = 4")  # verticale

    # --- 2.4 Droite infinie passant par un point avec une pente ---
    ax.axline((0, 6), slope=-0.8, color="orange", label="pente -0.8 par (0,6)")

    # --- 2.5 Droite passant par 2 points (infinie) ---
    ax.axline((1, 0), (3, 2), color="gray", ls=":", label="par (1,0) et (3,2)")

    ax.set_xlim(-1, 8); ax.set_ylim(-1, 8)
    ax.grid(alpha=0.3)
    ax.legend()
    ax.set_title("Différents types de droites")
    save(fig, "06_droites")

    # --- 2.6 Droite de régression (moindres carrés) ---
    rng = np.random.default_rng(1)
    X = np.linspace(0, 10, 30)
    Y = 2 * X + 1 + rng.normal(0, 2, X.size)
    pente, ordonnee = np.polyfit(X, Y, 1)           # degré 1 = droite
    fig, ax = plt.subplots()
    ax.scatter(X, Y, label="données")
    ax.plot(X, pente * X + ordonnee, "r-", lw=2, label=f"y = {pente:.2f}x + {ordonnee:.2f}")
    ax.legend()
    save(fig, "07_regression")

    # --- 2.7 Intersection de deux droites (calcul + affichage) ---
    # y = a1 x + b1  et  y = a2 x + b2   ->  x = (b2 - b1) / (a1 - a2)
    a1, b1, a2, b2 = 2, -1, -1, 5
    xi = (b2 - b1) / (a1 - a2)
    yi = a1 * xi + b1
    x = np.linspace(-1, 5, 100)
    fig, ax = plt.subplots()
    ax.plot(x, a1 * x + b1, label="D1")
    ax.plot(x, a2 * x + b2, label="D2")
    ax.plot(xi, yi, "ko")
    ax.annotate(f"I({xi:.1f}, {yi:.1f})", (xi, yi), xytext=(10, -15), textcoords="offset points")
    ax.legend(); ax.grid(alpha=0.3)
    save(fig, "08_intersection")


# ============================================================
# 3. COURBES
# ============================================================
def section_courbes():
    # --- 3.1 Fonction f(x) : toujours utiliser np.linspace + fonctions numpy ---
    x = np.linspace(-2 * np.pi, 2 * np.pi, 500)     # 500 points = courbe lisse
    fig, ax = plt.subplots(figsize=(8, 4))
    ax.plot(x, np.sin(x), label="sin(x)")
    ax.plot(x, np.cos(x), label="cos(x)", ls="--")
    ax.plot(x, np.sin(x) * np.exp(-0.1 * np.abs(x)), label="sin(x)·e^(-|x|/10)")
    ax.legend(); ax.grid(alpha=0.3)
    save(fig, "09_courbes_trigo")

    # --- 3.2 Polynôme, fraction, racine (attention aux valeurs interdites) ---
    x = np.linspace(-3, 3, 600)
    fig, ax = plt.subplots(figsize=(7, 5))
    ax.plot(x, x**3 - 3 * x, label="x³ - 3x")
    with np.errstate(divide="ignore", invalid="ignore"):
        y = 1 / x
    y[np.abs(y) > 10] = np.nan                      # coupe l'asymptote verticale
    ax.plot(x, y, label="1/x")
    ax.set_ylim(-6, 6)
    ax.legend(); ax.grid(alpha=0.3)
    save(fig, "10_polynome_et_fraction")

    # --- 3.3 Fonction définie par morceaux ---
    x = np.linspace(-3, 3, 600)
    y = np.where(x < 0, -x, x**2)                   # -x si x<0, x² sinon
    fig, ax = plt.subplots()
    ax.plot(x, y)
    save(fig, "11_par_morceaux")

    # --- 3.4 Aire sous la courbe / entre deux courbes ---
    x = np.linspace(0, 2, 300)
    f, g = x, x**2
    fig, ax = plt.subplots()
    ax.plot(x, f, label="f(x)=x"); ax.plot(x, g, label="g(x)=x²")
    ax.fill_between(x, f, g, where=(f >= g), alpha=0.3, color="gold", label="aire entre f et g")
    ax.legend()
    save(fig, "12_aire_entre_courbes")

    # --- 3.5 Courbe paramétrée (cercle, spirale) ---
    t = np.linspace(0, 4 * np.pi, 800)
    fig, ax = plt.subplots()
    ax.plot(t * np.cos(t), t * np.sin(t))           # x(t), y(t)
    ax.set_aspect("equal")                          # repère orthonormé
    ax.set_title("Spirale")
    save(fig, "13_parametrique")

    # --- 3.6 Coordonnées polaires ---
    theta = np.linspace(0, 2 * np.pi, 500)
    fig = plt.figure()
    axp = fig.add_subplot(projection="polar")
    axp.plot(theta, 1 + np.cos(theta))              # cardioïde r = 1 + cos(θ)
    save(fig, "14_polaire")

    # --- 3.7 Échelles logarithmiques ---
    x = np.linspace(0.1, 100, 500)
    fig, axs = plt.subplots(1, 3, figsize=(12, 3.5), constrained_layout=True)
    axs[0].plot(x, x**2);  axs[0].set_title("linéaire")
    axs[1].plot(x, x**2);  axs[1].set_yscale("log"); axs[1].set_title("log en y")
    axs[2].plot(x, x**2);  axs[2].set_xscale("log"); axs[2].set_yscale("log"); axs[2].set_title("log-log")
    save(fig, "15_echelles_log")

    # --- 3.8 Courbe lisse passant par quelques points (interpolation) ---
    xp = np.array([0, 1, 2, 3, 4, 5])
    yp = np.array([0, 2, 1, 4, 3, 5])
    xs = np.linspace(0, 5, 300)
    coef = np.polyfit(xp, yp, 3)                    # polynôme de degré 3
    fig, ax = plt.subplots()
    ax.plot(xp, yp, "ro", label="points")
    ax.plot(xs, np.polyval(coef, xs), label="ajustement degré 3")
    ax.legend()
    save(fig, "16_ajustement_polynomial")


# ============================================================
# 4. PERSONNALISATION (le plus important)
# ============================================================
def section_personnalisation():
    x = np.linspace(0, 10, 200)

    # --- 4.1 Tout sur une ligne : couleur, style, épaisseur, marqueurs ---
    fig, ax = plt.subplots(figsize=(8, 5))
    ax.plot(x, np.sin(x), color="#1f77b4", ls="-",  lw=2,   label="trait plein")
    ax.plot(x, np.sin(x) + 1, color="red",   ls="--", lw=2, label="tirets")
    ax.plot(x, np.sin(x) + 2, color="green", ls=":",  lw=3, label="pointillés")
    ax.plot(x, np.sin(x) + 3, color="black", ls="-.", lw=1.5, label="tiret-point")
    ax.plot(x[::10], np.sin(x[::10]) + 4, color="purple", marker="o", ms=6,
            mfc="white", mec="purple", label="avec marqueurs")
    # Raccourci "format string" : 'r--' = rouge + tirets, 'go' = vert + ronds, 'k^-' = noir + triangles + trait

    # --- 4.2 Titres, labels, LaTeX (mathtext) ---
    ax.set_title(r"Courbes $y = \sin(x) + k$", fontsize=16, fontweight="bold", pad=12)
    ax.set_xlabel(r"temps $t$ (s)", fontsize=12)
    ax.set_ylabel(r"amplitude $\alpha$", fontsize=12)

    # --- 4.3 Limites, graduations (ticks), grille ---
    ax.set_xlim(0, 10)
    ax.set_ylim(-1.5, 5.5)
    ax.set_xticks(np.arange(0, 11, 2))
    ax.set_yticks(np.arange(-1, 6, 1))
    ax.minorticks_on()
    ax.grid(which="major", ls="-", alpha=0.4)
    ax.grid(which="minor", ls=":", alpha=0.2)
    ax.tick_params(axis="both", labelsize=10, direction="in")

    # --- 4.4 Légende ---
    ax.legend(loc="upper right", ncol=2, fontsize=9, frameon=True, shadow=True, title="Légende")
    # loc : "best", "upper left", "lower right", "center", ...
    # Légende hors du graphe : ax.legend(loc="upper left", bbox_to_anchor=(1.02, 1))

    # --- 4.5 Texte, flèche, lignes de repère ---
    ax.text(5, -1.2, "du texte libre", fontsize=11, color="gray", ha="center")
    ax.annotate("maximum", xy=(np.pi / 2, 1), xytext=(2.5, 5),
                arrowprops=dict(arrowstyle="->", color="black"), fontsize=11)
    save(fig, "17_personnalisation_complete")

    # --- 4.6 Repère mathématique : axes qui passent par l'origine ---
    xx = np.linspace(-5, 5, 400)
    fig, ax = plt.subplots(figsize=(6, 6))
    ax.plot(xx, xx**2 - 4, lw=2)
    ax.spines["left"].set_position("zero")
    ax.spines["bottom"].set_position("zero")
    ax.spines["top"].set_visible(False)
    ax.spines["right"].set_visible(False)
    ax.set_xlim(-5, 5); ax.set_ylim(-6, 6)
    ax.set_aspect("equal")
    ax.grid(alpha=0.3)
    ax.set_title("Repère centré sur l'origine", pad=20)
    save(fig, "18_repere_mathematique")

    # --- 4.7 Styles prêts à l'emploi ---
    # print(plt.style.available)  -> liste des styles
    # plt.style.use("ggplot")  /  "bmh"  /  "dark_background"  /  "seaborn-v0_8-whitegrid"
    with plt.style.context("dark_background"):
        fig, ax = plt.subplots()
        ax.plot(x, np.sin(x), lw=2)
        ax.set_title("Style dark_background")
        save(fig, "19_style_sombre")

    # --- 4.8 Palette de couleurs, cycle de couleurs ---
    # Noms : "red", "tab:blue", "darkorange" ; hexa : "#FF5733" ; RGB : (0.2, 0.4, 0.6)
    # Colormaps : "viridis", "plasma", "coolwarm", "Blues", "RdYlGn", "tab10"
    cmap = plt.get_cmap("plasma")
    fig, ax = plt.subplots()
    for i in range(8):
        ax.plot(x, np.sin(x + i / 2), color=cmap(i / 7), label=f"i={i}")
    ax.legend(ncol=4, fontsize=8)
    save(fig, "20_palette_colormap")

    # --- 4.9 Réglages globaux (rcParams) : s'appliquent à tous les graphes ---
    # plt.rcParams.update({
    #     "figure.figsize": (8, 5),
    #     "font.size": 12,
    #     "axes.grid": True,
    #     "axes.spines.top": False,
    #     "axes.spines.right": False,
    #     "lines.linewidth": 2,
    #     "savefig.dpi": 200,
    # })


# ============================================================
# 5. PLUSIEURS GRAPHES DANS UNE FIGURE
# ============================================================
def section_multi():
    x = np.linspace(0, 2 * np.pi, 300)

    # --- 5.1 Grille de sous-graphes ---
    fig, axs = plt.subplots(2, 2, figsize=(9, 6), sharex=True, constrained_layout=True)
    axs[0, 0].plot(x, np.sin(x));   axs[0, 0].set_title("sin")
    axs[0, 1].plot(x, np.cos(x));   axs[0, 1].set_title("cos")
    axs[1, 0].plot(x, np.tan(x));   axs[1, 0].set_title("tan"); axs[1, 0].set_ylim(-5, 5)
    axs[1, 1].plot(x, np.sinh(x));  axs[1, 1].set_title("sinh")
    fig.suptitle("Plusieurs graphes", fontsize=15)
    save(fig, "21_subplots")

    # --- 5.2 Deux axes Y différents ---
    fig, ax1 = plt.subplots()
    ax1.plot(x, np.sin(x), color="tab:blue");  ax1.set_ylabel("sin", color="tab:blue")
    ax2 = ax1.twinx()
    ax2.plot(x, np.exp(x / 2), color="tab:red"); ax2.set_ylabel("exp", color="tab:red")
    save(fig, "22_double_axe_y")

    # --- 5.3 Mise en page libre (mosaic) ---
    fig, axd = plt.subplot_mosaic("AAB;CDB", figsize=(9, 5), constrained_layout=True)
    axd["A"].plot(x, np.sin(x))
    axd["B"].scatter(np.random.rand(30), np.random.rand(30))
    axd["C"].bar(["a", "b", "c"], [3, 5, 2])
    axd["D"].hist(np.random.randn(500), bins=20)
    save(fig, "23_mosaic")

    # --- 5.4 Zoom : graphe dans le graphe (inset) ---
    fig, ax = plt.subplots()
    ax.plot(x, np.sin(x * 3) * np.exp(-x / 3))
    ins = ax.inset_axes([0.55, 0.55, 0.4, 0.35])
    ins.plot(x, np.sin(x * 3) * np.exp(-x / 3)); ins.set_xlim(0, 1); ins.set_ylim(0, 1)
    ax.indicate_inset_zoom(ins)
    save(fig, "24_zoom_inset")


# ============================================================
# 6. AUTRES TYPES UTILES
# ============================================================
def section_autres():
    rng = np.random.default_rng(2)

    # --- 6.1 Barres, histogramme, camembert, boîte à moustaches ---
    fig, axs = plt.subplots(1, 4, figsize=(15, 3.5), constrained_layout=True)
    axs[0].bar(["A", "B", "C"], [5, 7, 3], color=["tab:blue", "tab:orange", "tab:green"])
    axs[0].set_title("bar")
    axs[1].hist(rng.normal(size=1000), bins=25, edgecolor="white")
    axs[1].set_title("hist")
    axs[2].pie([40, 30, 20, 10], labels=["a", "b", "c", "d"], autopct="%1.0f%%")
    axs[2].set_title("pie")
    axs[3].boxplot([rng.normal(0, s, 100) for s in (1, 2, 3)])
    axs[3].set_title("boxplot")
    save(fig, "25_types_divers")

    # --- 6.2 Barres d'erreur ---
    x = np.arange(1, 6)
    fig, ax = plt.subplots()
    ax.errorbar(x, x**2, yerr=x, fmt="o-", capsize=4)
    save(fig, "26_barres_erreur")

    # --- 6.3 Image / heatmap / courbes de niveau ---
    X, Y = np.meshgrid(np.linspace(-3, 3, 200), np.linspace(-3, 3, 200))
    Z = np.sin(X) * np.cos(Y)
    fig, axs = plt.subplots(1, 2, figsize=(10, 4), constrained_layout=True)
    im = axs[0].imshow(Z, extent=(-3, 3, -3, 3), origin="lower", cmap="coolwarm")
    fig.colorbar(im, ax=axs[0])
    cs = axs[1].contourf(X, Y, Z, levels=15, cmap="viridis")
    axs[1].contour(X, Y, Z, levels=15, colors="k", linewidths=0.3)
    fig.colorbar(cs, ax=axs[1])
    save(fig, "27_heatmap_contours")

    # --- 6.4 Surface et courbe 3D ---
    fig = plt.figure(figsize=(10, 4))
    a1 = fig.add_subplot(1, 2, 1, projection="3d")
    a1.plot_surface(X, Y, Z, cmap="viridis")
    a2 = fig.add_subplot(1, 2, 2, projection="3d")
    t = np.linspace(0, 6 * np.pi, 300)
    a2.plot(np.cos(t), np.sin(t), t)
    save(fig, "28_3d")


# ============================================================
# 7. ANIMATION (optionnel)
# ============================================================
def section_animation():
    from matplotlib.animation import FuncAnimation, PillowWriter
    x = np.linspace(0, 2 * np.pi, 200)
    fig, ax = plt.subplots()
    (ligne,) = ax.plot(x, np.sin(x))
    ax.set_ylim(-1.2, 1.2)

    def maj(frame):
        ligne.set_ydata(np.sin(x + frame / 10))
        return (ligne,)

    anim = FuncAnimation(fig, maj, frames=60, interval=50)
    anim.save("figures/29_animation.gif", writer=PillowWriter(fps=20))
    plt.close(fig)


# ============================================================
# 8. EXPORT & BONNES PRATIQUES
# ============================================================
# fig.savefig("graphe.png", dpi=300, bbox_inches="tight")   # image (rapports, web)
# fig.savefig("graphe.pdf")                                  # vectoriel (LaTeX, articles)
# fig.savefig("graphe.svg")                                  # vectoriel (web, Inkscape)
# fig.savefig("graphe.png", transparent=True)                # fond transparent
#
# Checklist d'un bon graphe :
#   1. un titre ou une légende explicite       4. une grille discrète (alpha ~0.3)
#   2. des labels d'axes avec unités            5. des couleurs lisibles (daltonisme : viridis)
#   3. une taille de police lisible (>= 10)     6. np.linspace avec assez de points (200+)
#
# Erreurs fréquentes :
#   - oublier plt.show() (hors notebook)         - utiliser des listes pour des calculs (utiliser numpy)
#   - math.sin au lieu de np.sin sur un tableau  - diviser par zéro : masquer avec np.nan
#   - courbe "en escalier" : pas assez de points - repère déformé : ax.set_aspect("equal")


# ============================================================
# 9. FONCTION PRÊTE À RÉUTILISER
# ============================================================
def tracer(fonctions, xmin=-5, xmax=5, points=None, titre="", fichier="mon_graphe"):
    """
    Trace des courbes et des points rapidement.
      fonctions : dict {"label": lambda x: ...}
      points    : liste de tuples [(x, y, "nom"), ...]
    Exemple :
      tracer({"x²": lambda x: x**2, "2x+1": lambda x: 2*x+1},
             points=[(1, 1, "A"), (-0.4, 0.2, "B")], titre="Test")
    """
    x = np.linspace(xmin, xmax, 600)
    fig, ax = plt.subplots(figsize=(7, 5))
    for nom, f in fonctions.items():
        ax.plot(x, f(x), lw=2, label=nom)
    for px, py, nom in (points or []):
        ax.plot(px, py, "ko")
        ax.annotate(nom, (px, py), xytext=(6, 6), textcoords="offset points")
    ax.spines["left"].set_position("zero")
    ax.spines["bottom"].set_position("zero")
    ax.spines["top"].set_visible(False)
    ax.spines["right"].set_visible(False)
    ax.grid(alpha=0.3)
    ax.legend()
    ax.set_title(titre, pad=15)
    save(fig, fichier)


if __name__ == "__main__":
    section_points()
    section_droites()
    section_courbes()
    section_personnalisation()
    section_multi()
    section_autres()
    section_animation()
    tracer({"x²": lambda x: x**2, "2x+1": lambda x: 2 * x + 1},
           points=[(1, 1, "A"), (-0.4, 0.2, "B")], titre="Exemple de la fonction tracer()", fichier="30_exemple_tracer")
    print("Terminé : voir le dossier figures/")