import numpy as np
# 248 * 86400 * 1000
threshold = np.sum(np.array([2142720000], dtype=np.intc))

def is_optimal(days):
    # days * 86400 * 1000
    a = np.array([days, 8640000], dtype=np.intc)
    res = np.multiply(a[0], a[1])
    if(res >= threshold):
        return True
    else:
        return False