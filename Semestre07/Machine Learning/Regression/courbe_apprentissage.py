import numpy as np
import matplotlib.pyplot as plt

def gradient_descent(x, y, a, b, alpha, iterations):
    m = len(x)
    couts = []
    for _ in range(iterations):
        erreur = a * x + b - y
        couts.append(np.sum(erreur ** 2) / (2 * m))   # coût avant la mise à jour
        grad_a = np.sum(erreur * x) / m
        grad_b = np.sum(erreur) / m
        a = a - alpha * grad_a
        b = b - alpha * grad_b
    return a, b, couts

x = np.linspace(0,10,50)
y = 2 * x + 1 + np.random.randn(50) * 1.2

a, b, couts = gradient_descent(x, y, 0.5, 0.4, 0.01, 1000)

fig, ax = plt.subplots(figsize=(10, 6))
ax.plot(range(len(couts)), couts, label="Coût J")
ax.set_xlabel("Itérations")
ax.set_ylabel("Coût J")
ax.set_title("Courbe d'apprentissage")
ax.set_yscale("log")        # optionnel : utile si le coût de départ est très grand
ax.grid(alpha=0.3)
ax.legend()
plt.show()
