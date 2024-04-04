import pandas as pd
import IPython.display as display

import nbformat as nbf




for i in range(1,101):
    #création d'un nouveau notebook
    notebook = nbf.v4.new_notebook()

    # lecture du fichier csv
    df = pd.read_csv("simulation_results_"+str(i)+".csv", names=["nombre_infected", "nombre_sain", "nombre_exposed", "nombre_recovered"])

    for index, row in df.iterrows():
        cell = nbf.v4.new_markdown_cell(source="## Simulation results")
        notebook.cells.append(cell)
        cell.source = str(row)

    with open("simulation_results_"+str(i)+".ipynb", "w") as f:
        nbf.write(notebook, f)
        f.close()