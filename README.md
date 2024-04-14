# dti-canil
Teste Prático - dti digital  
Arthur Gonçalves de Moraes
  
**O problema**  
Senhor Eduardo é proprietário de um canil em Belo Horizonte, ele trabalha com
diversas raças, pequenas e grandes. Eduardo gosta que seus cães estejam sempre
arrumados, felizes e cheirosos.
No bairro do canil, para realizar o banho nos animais, existem três petshops: Meu
Canino Feliz, Vai Rex, e ChowChawgas. Cada um deles cobra preços diferentes para
banho em cães pequenos e grandes e o preço pode variar de acordo com o dia da
semana.  

-Meu Canino Feliz: Está distante 2km do canil. Em dias de semana o banho para
cães pequenos custa R$20,00 e o banho em cães grandes custa R$40,00.
Durante os finais de semana o preço dos banhos é aumentado em 20%.  

-Vai Rex: Está localizado na mesma avenida do canil, a 1,7km. O preço do banho
para dias úteis em cães pequenos é R$15,00 e em cães grandes é R$50,00.
Durante os finais de semana o preço para cães pequenos é R$ 20,00 e para os
grandes é R$ 55,00.   
     
-ChowChawgas: Fica a 800m do canil. O preço do banho é o mesmo em todos os
dias da semana. Para cães pequenos custa R$30 e para cães grandes R$45,00.    
      
- Como executar:  
  - Clonar o repositório  
  - Executar arquivo Aplicacao.java em um ambiente que permita a execução do projeto como um todo (Run Java da Language Support for Java(TM) by Red Hat no VSCode por exemplo) (project/src/main/java/app/Aplicacao.java)  
  - acessar a aplicação em localhost:1234/home  

- Premissas
  - O usuário não fará alterações nos dados dos petshops
  - O usuário não adicionará novos petshops  
  - O canil se chama "Canil Sadonana"

- Decisões
  - Não foi utilizado nenhum tipo de Banco de Dados devido à pequena escala do projeto
  - Criação de uma classe PetShop melhorando a clareza e a manutenção do código, além da modularidade e escalabilidade do projeto
  - A escolha da quantidade de cachorros tem um valor máximo de 100 cachorros para cada tamanho. Por ser tratar de um canil, é esperado que possuam muitos cães e por isso um valor máximo alto, mesmo que na perspectiva do petshop talvez não seja possível atender essa demanda.

- Comentários  
A escalabilidade do projeto foi um ponto parcialmente implementado, sendo que a adição de um novo petshop poderia ser feita a pedido do usuário e demandaria pouquíssima mudança no código. 

  
  


