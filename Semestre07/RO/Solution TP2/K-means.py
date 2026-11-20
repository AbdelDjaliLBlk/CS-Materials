import numpy as np
import matplotlib.pyplot as plt
from Normalisation_Descripteur import *
from sklearn.datasets import load_wine
np.set_printoptions(precision= 3,suppress=True, linewidth= 120)

def assign_clusters(X,centroids):
    labels = []
    for x in X:
        d = [np.sum((x-mu)**2) for mu in centroids]
        labels.append(np.argmin(d))
    return np.array(labels)

def assign_printing(X,centroids):
    labels = assign_clusters(X,centroids)
    print("-" * 28)
    for i,l in enumerate(labels):
        print(f"  {i+1}\ {X[i]} ==> {centroids [l]}")
    print("-" * 28)

def update_centroids(X, labels , K):
    centroids = []
    for j in range(K):
        points = X[labels == j]
        centroids.append(points.mean(axis = 0))
    return np.array(centroids)   

def k_means(X, centroids, eps=1e-8, max_iter=100):
    history = [centroids] # Past Centriods
    for t in range(max_iter):
        labels = assign_clusters(X, centroids)
        new_centroids = update_centroids(X, labels, len(centroids))
        delta = ((new_centroids - centroids) ** 2).sum()
        print(f"t={t}  delta={delta:.6f}")
        centroids = new_centroids
        history.append(centroids)
        if delta <= eps:
            break
    return centroids, labels, history


if __name__ == '__main__':

    X_toy = np.array([
    [1.0, 1.0],
    [1.5, 2.0],
    [2.0, 1.5],
    [8.0, 8.0],
    [9.0, 8.5],
    [8.5, 9.0]
    ])

    # 1\ Initialisation manuelle de 2 centroides de depart
    mu_init = np.array([[1.0, 2.0], [9.0, 9.0]])
    
    print("-" * 28 ,"\n"," " * 8 ,"K-Means")
    # 2\ Affectation des points vers les centroides
    assign_printing(X_toy,mu_init)

    # 3\ Mise à Jour
    mu = update_centroids(X_toy,assign_clusters(X_toy,mu_init),len(mu_init))
    print(mu)
    print("-" * 28)

    # 4\ Visualisation Des Centroides
    labels_init = assign_clusters(X_toy , mu_init)
    plt.scatter(X_toy[:,0],X_toy[:,1])
    plt.scatter(mu_init[:,0],mu_init[:,1],marker="x" ,color = 'black', label = "Avant")
    plt.scatter(mu[:,0],mu[:,1],marker="*" ,color = 'red', label = "Aprés")
    plt.legend()
    
    plt.show()
    
    # 5\ Wine
    Xw = load_wine().data
    Xw, _, _ = my_min_max_scaler(Xw)
    np.random.seed(0)
    mu0 = Xw[np.random.choice(len(Xw), 3, replace=False)]
    mu, labels, _ = k_means(Xw, mu0)
    print("Taille des clusters:", np.bincount(labels))

        