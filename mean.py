import os
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt


csv_files = [f for f in os.listdir('simulation_results_csv') if f.endswith('.csv')]

dfs = [pd.read_csv(os.path.join('simulation_results_csv', file)) for file in csv_files]

all_data_df = pd.concat(dfs, axis=1)
mean_df = all_data_df.groupby(by=all_data_df.columns, axis=1).mean()
mean_df.to_csv('simulation_results_csv/mean_results.csv', index=False)

df = pd.read_csv("simulation_results_csv/mean_results.csv", names=["nombre_infected", "nombre_sain", "nombre_exposed", "nombre_recovered"])
plt.figure(figsize=(10, 6))
plt.plot(df['nombre_infected'], label='Infected')
plt.plot(df['nombre_sain'], label='Healthy')
plt.plot(df['nombre_exposed'], label='Exposed')
plt.plot(df['nombre_recovered'], label='Recovered')
plt.legend(loc='best')
plt.title('Simulation Results')
plt.xlabel('Iteration')
plt.ylabel('Nombre d''individus')
os.makedirs("simulation_results_png", exist_ok=True)
plt.savefig("/home/jack/Documents/COURS/INFORMATIQUE/Java/L2/S4/projet-simulation-S4-2024/simulation_results_png/mean_results.png")
plt.close()
