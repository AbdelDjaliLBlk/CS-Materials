from BranchAndBound import *
import matplotlib.pyplot as plt
import time
import random

def generate_instance(n, seed=42):
    random.seed(seed)
    items = [{"id": i, "v": random.randint(10, 100), "w": random.randint(5, 50)}
             for i in range(n)]
    W = int(0.5 * sum(x["w"] for x in items))
    return items, W


if __name__ == "__main__":
    print(f"{'N':>3} {'Arbre Exhaustive':>12} {'Binf(0)':>8} {'Binf(glouton':>12} {'Time(s)':>9} {'Gap(%)':>6}")
    sizes, nodes0, gaps = [10, 15, 20, 25], [], []
    for n in sizes:
        its, cap = generate_instance(n)
        z_glouton = heuristic_ratio(its, cap)[0]

        z_opt, _, n0 = BranchAndBound(its, cap, 0).solve()

        t = time.time()
        _, _, ng = BranchAndBound(its, cap, z_glouton).solve()
        t = time.time() - t

        gap = (z_opt - z_glouton) / z_opt * 100
        nodes0.append(n0)
        gaps.append(gap)
        print(f"{n:>3} {2**(n+1)-1:>12} {n0:>8} {ng:>11} {t:>9.4f} {gap:>6.2f}")

    print(f"\nAverage optimality gap: {sum(gaps)/len(gaps):.2f} %")

    plt.semilogy(sizes, [2**(n+1)-1 for n in sizes], "o-", label="Exhaustive")
    plt.semilogy(sizes, nodes0, "s-", label="Binf=0")
    plt.xlabel("N"); plt.ylabel("Nodes "); plt.legend() ; plt.grid(True)
    plt.savefig("scalability.png")

