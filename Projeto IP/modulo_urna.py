import time

"""===========================
            ELEITOR
   ==========================="""


def cadastraEleitor(eleitores):
    nome = input("*** INFORME O NOME DO ELEITOR ***\n").upper()
    print("AGUARDE...")
    time.sleep(2)
    matricula = input("*** INFORME A MATRICULA ***\n")
    print("AGUARDE...")
    time.sleep(2)
    voto = "Não"
    existe = 0
    for matriculas in eleitores:
        if matricula == matriculas[1]:
            existe += 1
    if existe == 0:
        informacoes = [nome,matricula,voto]
        eleitores.append(informacoes)
    elif existe > 0:
        print("ESTA MATRÍCULA PERTENCE HÁ UM OUTRO ELEITOR.")
        time.sleep(2)
    return eleitores


def listarEleitor(eleitores):
    for dado in eleitores:
        print(" NOME:",dado[0],"\n","MATRICULA:",dado[1],"\n","VOTOU:",dado[2],"\n")
            

def alterarDadosEleitor(eleitores):
    pesquisa = input("DIGITE A MATRICULA DO ELEITOR:\n")
    print("AGUARDE...")
    time.sleep(2)
    cadastrado = 0
    for dado in eleitores:
        if dado[1] == pesquisa:
            print("NOME ATUAL:",dado[0])
            novoNome = input("INSIRA O NOVO NOME:\n").upper()
            dado[0] = novoNome
            print("AGUARDE...")
            time.sleep(2)
            print("ALTERAÇÃO REALIZADA COM SUCESSO.\n")
            time.sleep(2)
            cadastrado = 1
    if cadastrado == 0:
        print("ELEITOR NÃO ENCONTRADO!")



"""===========================
            CANDIDATO
   ==========================="""


def cadastraCandidato(candidatos):
    nome = input("*** INFORME O NOME DO CANDIDATO ***\n").upper()
    print("AGUARDE...")
    time.sleep(1)
    vice = input("*** INFORME O NOME DO VICE-CANDIDATO ***\n").upper()
    print("AGUARDE...")
    time.sleep(1)
    numero = input("*** INFORME O NÚMERO DO CANDIDATO ***\n")
    print("AGUARDE...")
    time.sleep(1)
    partido = input("*** INFORME O PARTIDO ***\n").upper()
    print("AGUARDE...")
    time.sleep(1)
    votos = "0"
    informacoes = [nome,vice,numero,partido,votos]
    candidatos.append(informacoes)
    return candidatos


def alterarDadosCandidato(candidatos):
    pesquisa = input("DIGITE O NÚMERO DO CANDIDATO:\n")
    print("AGUARDE...")
    time.sleep(1)
    print("[1]ALTERAR CANDIDATO\n[2]ALTERAR VICE-CANDIDATO")
    alterar = input()
    existecand = 0
    existevice = 0
    if alterar == "1":
        for dado in candidatos:
            if dado[2] == pesquisa:
                print("CANDIDATO ATUAL:",dado[0])
                novoNome = input("INSIRA O NOVO NOME:\n").upper()
                dado[0] = novoNome
                print("AGUARDE...")
                time.sleep(2)
                print("ALTERAÇÃO REALIZADA COM SUCESSO.\n")
                time.sleep(2)
                existecand = 1
        if existecand == 0:
            print("CANDIDATO NÃO ENCONTRADO!")
    elif alterar == "2":
        for dado in candidatos:
            if dado[2] == pesquisa:
                print("VICE ATUAL:",dado[1])
                novoNome = input("INSIRA O NOVO NOME:\n").upper()
                dado[1] = novoNome
                print("AGUARDE...")
                time.sleep(2)
                print("ALTERAÇÃO REALIZADA COM SUCESSO.\n")
                time.sleep(2)
                existevice = 1
        if existevice == 0:
            print("CANDIDATO NÃO ENCONTRADO!")
            

    else:
        print("MAIS ATENÇÃO. TENTE NOVAMENTE!!!")
        time.sleep(2)
        alterarDadosCandidato(candidatos)


def listarCandidatos(candidatos):
    for dado in candidatos:
        print(" CANDIDATO:",dado[0],"\n","VICE:",dado[1],"\n","NÚMERO:",dado[2],"\n","PARTIDO:",dado[3],"\n")
    


"""===========================
            VOTO
   ==========================="""



def eleitorCadastrado(tituloEle,eleitores):
    existeEle = 0
    for eleitor in eleitores:
        if eleitor[1] == tituloEle:
            if eleitor[2] == "Sim":
                print("O ELEITOR",eleitor[0],"JÁ VOTOU.")
                existeEle = 1
            elif eleitor[2] == "Não":
                eleitor[2] = "Sim"
                existeEle = 2
    if existeEle == 0:
        print("ELEITOR NÃO ENCONTRADO!")
    return(existeEle)


def mostraCandidato(votou,candidatos):
    existeCand = 0
    for candidato in candidatos:
        if candidato[2] == votou:
            print("CANDIDATO :",candidato[0],"\nVICE :",candidato[1],"\nNÚMERO :",candidato[2],"\nPARTIDO :",candidato[3])
            existeCand = 1
            time.sleep(2)
    if existeCand == 0:
        print("VOTO NULO")
        urna()
    elif existeCand != 0:
        urna()


def votocandidato(candidatos,votou):
    for linha in candidatos:
        if votou == linha[2]:
            a = int(linha[4])
            a += 1
            linha[4] = str(a)
    return candidatos


def votar(eleitores,candidatos):
    
    tituloEle = input("INFORME SUA MATRICULA:\n")
    lupin = eleitorCadastrado(tituloEle,eleitores)
    time.sleep(2)
    while lupin > 1:
        votou = input("VOTO:\n")
        mostraCandidato(votou,candidatos)
        confirma = int(input())
        if confirma <= 3:
            if confirma == 3:
                votocandidato(candidatos,votou)
                print("AGUARDE...")
                time.sleep(2)
                print("FIM")
                time.sleep(2)
                lupin = 0
            elif confirma == 1:
                print("AGUARDE...")
                time.sleep(2)
                print("FIM")
                time.sleep(2)
                lupin = 0
                
        else:
            print("ATENÇÃO, TENTE NOVAMENTE.\n")
            time.sleep(1)
            lupin = 1


def mostraVotos(candidatos):
    for votos in candidatos:
        print("CANDIDADO:",votos[0],"\nVICE:",votos[1],"\nVOTOS:",votos[4],"\n")
        time.sleep(2)

def quantVotos(eleitores):
    votaram = 0
    nvotaram = 0    
    for voto in eleitores:
        if voto[2] == "Sim":
            votaram += 1
        elif voto[2] == "Não":
            nvotaram += 1
    total = votaram + nvotaram
    print("\nELEITORES QUE VOTARAM:",votaram,"\nELEITORES QUE NÃO VOTARAM:",nvotaram,"\nTOTAL DE ELEITORES:",total,"\n")
    time.sleep(2)


"""===========================
            MENUS
   ==========================="""



def menu():
    print("""=====================
====MENU CADASTRO====
=====================\n
[1]CADASTRAR ELEITOR\n[2]LISTAR ELEITORES\n[3]ALTERAR DADOS ELEITOR
[4]CADASTRAR CANDIDATO\n[5]LISTAR CANDIDATO\n[6]ALTERAR DADOS CANDIDATO
[7]VOTAR\n[8]CONSULTAR VOTOS\n[9]ANDAMENTO DOS VOTOS\n[10]SAIR""")


def urna():
    print("""=====================
==== [1]  BRANCO ====
==== [2] CORRIGE ====
==== [3] CONFIMA ====
=====================""")
