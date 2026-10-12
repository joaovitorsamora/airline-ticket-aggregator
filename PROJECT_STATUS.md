# Status do Projeto & Fluxo de Trabalho

## 🚀 Fase Atual: Inicialização do Repositório

### 📋 Check-list de Governança
- [x] Criação da árvore de diretórios (`backend/`, `frontend/`, `docs/decisions/`)
- [x] Configuração global de ferramentas (`.gitignore`, `.editorconfig`)
- [x] Definição de documentação mínima e aviso de segurança
- [ ] Configuração do repositório remoto (GitHub)
- [ ] Ativação de regras de proteção da branch `main`

## 🔄 Fluxo de Trabalho Git (Git Flow simplificado)
1. **Branch Principal:** A branch `main` representa o código estável. **É proibido realizar commits diretos na `main`**.
2. **Desenvolvimento de Recursos:** Toda e qualquer alteração de código ou documentação deve ocorrer em branches auxiliares (ex: `feature/nome-da-funcionalidade` ou `fix/correcao-bug`).
3. **Integração:** O envio do código para a `main` deve obrigatoriamente acontecer através de um **Pull Request (PR)** revisado e aprovado no GitHub.
