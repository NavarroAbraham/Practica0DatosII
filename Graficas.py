import matplotlib.pyplot as plt
import numpy as np

Palabras = [10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 110000, 120000, 130000, 140000, 150000, 160000, 170000, 180000, 190000, 200000, 210000, 220000, 230000, 240000, 247047]
Tiempo = [0.4652489, 2.1471206, 4.2654803, 8.167294, 11.7506811, 17.2151194, 24.3763492, 31.1422708, 39.9927833, 49.6414073, 60.1087232, 71.7731312, 84.0215275, 97.523025, 111.9962277, 127.2922301, 143.661036, 170.854425, 208.995786, 245.114575, 278.174104, 300.192404, 331.169475, 383.7702427, 392.383643]

plt.plot(Palabras, Tiempo, label='Tiempo(Segundos) vs numero de datos', color='r', marker='o', markerfacecolor='b', markersize=5)

plt.xlabel('Numero de datos')
plt.ylabel('Tiempo en segundos')
plt.title('Tiempo de ejecucion')
plt.legend()

plt.show()
