"""===========================
            ELEITOR
   ==========================="""

def gravaEleitor(eleitores):
    arqEleitores = open("arquivoEleitores.txt","w")
    for dado in eleitores:
        arqEleitores.write(dado[0]+",")
        arqEleitores.write(dado[1]+",")
        arqEleitores.write(dado[2]+"\n")
    arqEleitores.close()


def recuperaEleitores():
    dadosAntigos = []
    arquivo = open("arquivoEleitores.txt","r")
    for linha in arquivo:
        eleitor = linha.strip().split(",")
        dadosAntigos.append(eleitor)
    arquivo.close()
    return dadosAntigos



"""===========================
            CANDIDATO
   ==========================="""

def gravaCandidato(candidatos):
    arqCandidatos = open("arquivoCandidatos.txt","w")
    for dado in candidatos:
        arqCandidatos.write(dado[0]+",")
        arqCandidatos.write(dado[1]+",")
        arqCandidatos.write(dado[2]+",")
        arqCandidatos.write(dado[3]+",")
        arqCandidatos.write(dado[4]+"\n")
    arqCandidatos.close()


def recuperaCandidatos():
    dadosAntigos1 = []
    arquivo1 = open("arquivoCandidatos.txt","r")
    for linha in arquivo1:
        cand = linha.strip().split(",")
        dadosAntigos1.append(cand)
    arquivo1.close()
    return dadosAntigos1
