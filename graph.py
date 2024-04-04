import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV file
df = pd.read_csv("simulation_results_1.csv", names=["nombre_infected", "nombre_sain", "nombre_exposed", "nombre_recovered"])

# Plot the data
plt.figure(figsize=(10, 6))
plt.plot(df['nombre_infected'], label='Infected')
plt.plot(df['nombre_sain'], label='Healthy')
plt.plot(df['nombre_exposed'], label='Exposed')
plt.plot(df['nombre_recovered'], label='Recovered')
plt.legend(loc='best')
plt.title('Simulation Results')
plt.xlabel('Iteration')
plt.ylabel('Number of Individuals')
plt.show()