# 1. Uso de Monorepo para Unificação do Projeto

## Status
Aprovado

## Contexto
Precisamos gerenciar o ciclo de vida do frontend e do backend de forma síncrona, garantindo que as alterações de contrato de API e entregas de valor de negócio sejam testadas, revisadas e versionadas sob o mesmo histórico.

## Decisão
Adotaremos a estratégia de Monorepo utilizando uma única raiz Git hospedada no GitHub. As aplicações serão isoladas nas pastas `/frontend` e `/backend`.

## Consequências
- **Positivas:** Versionamento unificado em um único Pull Request; facilidade de rastreabilidade de bugs de integração; simplificação da esteira de CI global.
- **Negativas:** O pipeline de CI é acionado para o repositório como um todo (pode ser otimizado no futuro para rodar apenas na pasta alterada).
