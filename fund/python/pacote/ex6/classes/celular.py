import config.param as c

class Celular:
  def __init__(self, modelo="", memoria=4, dono=None):
    self.modelo = modelo
    self.memoria = memoria # em gigabytes
    self.proprietario = dono
  def __str__(self):
    return f'''Modelo: {self.modelo}, 
memoria: {self.memoria} GB, 
dono: {str(self.proprietario)}''' # aqui deve-se usar o comando str