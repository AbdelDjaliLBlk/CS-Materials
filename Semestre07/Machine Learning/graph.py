import numpy as np
import matplotlib.pyplot as plt


x = np.linspace(0, 7, 100)
points_x = np.array([1, 2, 3, 4, 5])
points_y = np.array([2, 4, 3.5, 4.5, 6])
# -------------------------
fig , ax = plt.subplots()
ax.set_ylim(0,7)
ax.set_xlim(0,7)
# -------------------------
ax.scatter(points_x,points_y,s=50,c="crimson",marker = "x",edgecolors="black")
# -------------------------
ax.plot(x, 0.6 * x + 0.8 , label = "a.x + b")
ax.plot(x, 0.8 * x + 1.7 , label = "Solution Minimal" ,c ='green')
ax.vlines(points_x,points_y,0.8 * points_x + 1.7,linestyles='--',colors = 'gray',linewidth=1)
# -------------------------
ax.legend()
ax.set_xlabel('x', loc= 'right')
ax.set_ylabel('y')
ax.set_title("Régression")
# -------------------------
plt.show()
fig.savefig("regression.png", dpi=200)