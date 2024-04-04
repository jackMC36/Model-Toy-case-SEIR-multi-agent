import pandas as pd
import IPython.display as display

import nbformat as nbf

# Create a new Jupyter notebook
notebook = nbf.v4.new_notebook()

# Read the CSV file
for i in range(1,101):
    df = pd.read_csv("simulation_results_"+str(i)+".csv", names=["nombre_infected", "nombre_sain", "nombre_exposed", "nombre_recovered"])

    # For each row in the DataFrame
    for index, row in df.iterrows():
        # Create a new cell in the notebook
        cell = nbf.v4.new_markdown_cell(source="## Simulation results")
        notebook.cells.append(cell)

        # Write the row to the cell
        cell.source = str(row)

    with open("simulation_results_"+str(i)+".ipynb", "w") as f:
        nbf.write(notebook, f)