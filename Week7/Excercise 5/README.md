# Git Hands-On Lab: Clean Up and Push to Remote Git

This repository was created for the hands-on lab assignment on Git Clean Up and Push. The main goal was to practice reviewing repository status, updating local state by pulling from the remote repository, and pushing local modifications back to the remote server safely.

---

### Key Git Operations

#### 1. Why Pull Before Push?
It is a best practice in Git to always execute `git pull` before launching `git push`. If other developers have pushed changes to the remote repository, your local branch will be out-of-sync. 
*   If you push without pulling, Git will reject the push with a `non-fast-forward` error.
*   Running `git pull` fetches the remote commits and integrates them into your local work, resolving any conflicts locally.

#### 2. Cleaning Up Your Local Repository
"Cleaning up" means deleting local branch references that have already been merged into the trunk (e.g. `git branch -d branch_name`) and removing untracked or configuration residue files so your working tree stays clean.

---

### Step-by-Step Execution Guide

#### Step 1: Verify Repository Status
Check that your working tree is clean and that you don't have unstaged edits:
```bash
git status
```

#### Step 2: List Local Branches
Confirm which branches are present and verify that you are currently on the primary branch (`main` or `master`):
```bash
git branch
```

#### Step 3: Pull Remote Updates
Synchronize your local repository with any new commits pushed to the remote repository by other users:
```bash
git pull origin main
# Note: Use 'master' if your primary branch is named master
```

#### Step 4: Push Local Commits
Deploy your local commits to the remote tracking server:
```bash
git push origin main
```

---

### Terminal Logs Output Example

```bash
$ git status
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean

$ git branch
* main

$ git pull origin main
From https://github.com/Palak85/JavaFSE
 * branch            main       -> FETCH_HEAD
Already up to date.

$ git push origin main
Everything up-to-date
```
