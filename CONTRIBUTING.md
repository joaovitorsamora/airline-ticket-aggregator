# Contributing to Airline Ticket Aggregator

Welcome! Follow these strict conventions to keep our monorepo clean and structured.

## 🌿 Branch Naming Convention
Branches must be created using the following patterns based on the issue type:
- **Features:** `feature/FLT-XXX-short-description`
- **Bug Fixes:** `bugfix/FLT-XXX-short-description`
- **Chore/Docs:** `chore/FLT-XXX-short-description`

*Example:* `feature/FLT-01-setup-monorepo-base`

## 💬 Commit Message Convention
We follow the **Conventional Commits** specification. Messages must be in English and lowercase:

```bash
<type>(<scope>): <short description in imperative mood>
```

### Allowed Types:
- `feat`: A new feature or project setup.
- `fix`: A bug fix.
- `docs`: Documentation changes only.
- `chore`: Maintenance tasks, dependencies, or tool configurations.

### Scope:
Use `backend`, `frontend`, or `setup`.

*Example:* `feat(backend): add initial flight search controller`

## 🏁 Checklist Before Submitting a PR
1. Run linting and formatting locally.
2. Ensure both layers compile cleanly without errors.
3. Fill out the PR template entirely, including the Mock Data Notice.
