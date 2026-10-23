def step(s, e):
    if e == "push":
        if s == 3: return 3, "erreur"
        s += 1
    elif e == "pop":
        if s == 0: return 0, "erreur"
        s -= 1
    elif e == "top":
        if s == 0: return 0, "erreur"

    if s == 0: return s, "vide"
    if s == 3: return s, "pleine"
    return s, "ok"


print("État     | push   |       pop   |    top")
for s in range(4):
    print(s, "|", *[step(s, e) for e in ("push", "pop", "top")], sep="  ")
print()
# test
s = 0
for e in ["push", "push", "push", "push", "pop"]:
    s2, out = step(s, e)
    print(f"état {s} --{e}--> état {s2}, sortie: {out}")
    s = s2