import numpy as np
np.set_printoptions(precision= 3,suppress=True, linewidth= 120)

def my_min_max_scaler(X):
    x_min = X.min(axis=0)
    x_max = X.max(axis=0)
    X_scaled = (X - x_min) / (x_max - x_min)
    return X_scaled, x_min, x_max


if __name__ == '__main__':
    X = np.array([
    [25,2200],
    [26,2400],
    [45,2200]
    ]
    )
    print("-" * 21)
    scaled , min , max = my_min_max_scaler(X)
    print(f" * Scaled =\n {scaled}\n ** Min = {min}\n *** Max = {max} ")
    print("-" * 21)