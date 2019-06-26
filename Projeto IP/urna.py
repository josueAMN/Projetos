import modulo_urna,modulo_urnatxt,time


laco = True
eleitores = []
eleitores = modulo_urnatxt.recuperaEleitores()
candidatos = []
candidatos  = modulo_urnatxt.recuperaCandidatos()

while laco == True:
    
    modulo_urna.menu()
    entrada = input()
    
    if entrada == "1":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(1)
        modulo_urna.cadastraEleitor(eleitores)
        
    elif entrada == "2":
        eleitores.sort()
        modulo_urna.listarEleitor(eleitores)
            
    elif entrada == "3":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(2)
        modulo_urna.alterarDadosEleitor(eleitores)
        
    elif entrada == "4":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(1)
        modulo_urna.cadastraCandidato(candidatos)
        
    elif entrada == "5":
        candidatos.sort()
        modulo_urna.listarCandidatos(candidatos)
        
    elif entrada == "6":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(2)
        modulo_urna.alterarDadosCandidato(candidatos)
        
    elif entrada == "7":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(2)
        modulo_urna.votar(eleitores,candidatos)

    elif entrada == "8":
        print("AGUARDANDO SERVIDOR...\n")
        time.sleep(2)
        modulo_urna.mostraVotos(candidatos)

    elif entrada == "9":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(2)
        modulo_urna.quantVotos(eleitores)
        
    elif entrada == "10":
        print("AGUARDANDO SERVIDOR...")
        time.sleep(2)
        modulo_urnatxt.gravaEleitor(eleitores)
        modulo_urnatxt.gravaCandidato(candidatos)
        print("SALVANDO...")
        time.sleep(2)
        laco = False
        
    else:
        print("     ATENÇÃO.\nTENTE NOVAMENTE!!!\n")
        time.sleep(2)
