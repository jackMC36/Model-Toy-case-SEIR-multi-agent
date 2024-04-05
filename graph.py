import pandas as pd
import os
import matplotlib.pyplot as plt

for i in range(1,101):
    df = pd.read_csv("simulation_results_csv/simulation_results_"+str(i)+".csv", names=["nombre_infected", "nombre_sain", "nombre_exposed", "nombre_recovered"])
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
    plt.savefig("/home/jack/Documents/COURS/INFORMATIQUE/Java/L2/S4/projet-simulation-S4-2024/simulation_results_png/simulation_results_"+str(i)+".png")
    plt.close()