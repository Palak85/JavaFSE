# Git Hands-On Lab: Git Ignore

This repository was created for the hands-on lab assignment on Git Ignore. The main goal was to configure a `.gitignore` file to prevent unwanted log files and log folders from being tracked by Git.

### What I did in this assignment:

*   **Created Log Files & Folders:** Added a `.log` file (`debug.log`) and a log directory (`log/app.log`) in the project root.
*   **Created `.gitignore`:** Configured rules to ignore any files with a `.log` extension (`*.log`) and the `log` folder (`log/`).
*   **Verified via `git status`:** Ran verification to check that untracked log files do not appear in the staging area status output.

---

### Understanding Git Ignore

The `.gitignore` file is a special text file placed in a Git repository that specifies patterns of files and folders that Git should ignore and not track. This is highly useful for ignoring:
*   Temporary files (caches, logs, system metadata files like `.DS_Store`).
*   Local configuration secrets (`.env`, database credentials).
*   Build dependency directories (`node_modules/`, `target/`).

---

### Step-by-Step Configuration

1. Create a `.gitignore` file:
   ```bash
   touch .gitignore
   ```
2. Add the ignore rules for log files and log folders:
   ```gitignore
   # Ignore all log files
   *.log

   # Ignore the log folder
   log/
   logs/
   ```
3. Verify that only `.gitignore` and tracked files are shown as untracked, while `.log` files and the `log/` folder are hidden:
   ```bash
   git status
   ```

---

### Verification and Output logs

When you execute `git status` inside this directory:

```bash
$ git status
On branch main

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	.gitignore
	welcome.txt

nothing added to commit but untracked files present (use "git add" to track)
```

**Observation:**
Even though `debug.log` and the `log/app.log` folder exist inside the directory, they **do not** show up under the `Untracked files` section. This verifies that our `.gitignore` rules are working correctly and preventing these unwanted log files from being staged or committed.
