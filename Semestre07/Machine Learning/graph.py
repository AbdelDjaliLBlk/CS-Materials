import numpy as np
import matplotlib.pyplot as plt

np.random.seed(42)
x = np.linspace(0, 10, 50)
# points_x = np.array([1, 2, 3, 4, 5])
# points_y = np.array([2, 4, 3.5, 4.5, 6])
y = 2 * x + 1 + np.random.randn(50) * 1.5  
plt.scatter(x, y, edgecolor="k")

# -------------------------
fig , ax = plt.subplots()
ax.set_ylim(0,20)
ax.set_xlim(0,10)
# -------------------------
ax.scatter(x,y,edgecolor = 'k')
# -------------------------
ax.plot(x, 0.6 * x + 0.8 , label = "a.x + b")
ax.plot(x, 0.8 * x + 1.7 , label = "Solution Minimal" ,c ='green')
#ax.vlines(x,y,0.8 * x + 1.7,linestyles='--',colors = 'gray',linewidth=1)
# -------------------------
ax.legend()
ax.set_xlabel('x', loc= 'right')
ax.set_ylabel('y')
ax.set_title("Régression")
# -------------------------
plt.show()

