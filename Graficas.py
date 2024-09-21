import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_csv('resultados.csv')

plt.plot(df['Tamaño de Datos'], df['Tiempo Bubble Sort'], label='Bubble Sort')
plt.plot(df['Tamaño de Datos'], df['Tiempo Bucket Sort'], label='Bucket Sort')

plt.xlabel('Tamaño de Datos')
plt.ylabel('Tiempo (nanosegundos)')
plt.title('Comparación de Tiempos de Bubble Sort y Bucket Sort')
plt.legend()

plt.show()
