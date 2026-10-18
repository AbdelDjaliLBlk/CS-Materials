# ============================================================
# 0. Nuages De Points
# ============================================================
def lire_points(n):
    points_x = [] ; points_y = []
    print("Entrez les points sous-forme (x,y)")
    print("*--------------*")
    for i in range(n):
        x,y = input("(. , .) = ").split(' ')
        points_x.append(x)
        points_y.append(y)
    print("*--------------*")

    return points_x,points_y
def afficher_points(X,Y):
    print()
    for i, (x, y) in enumerate(zip(X, Y)):
        print(f"- Point {i}: ({x},{y}).")


