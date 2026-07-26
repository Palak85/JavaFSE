# Git Hands-On Lab: Branching and Merging

This repository was created for the hands-on lab assignment on Git Branching and Merging. The main goal was to practice creating a new branch, making changes in that branch, checking differences, merging the branch back into the trunk (`main`/`master`), and cleaning up.

---

### Understanding Branching and Merging

*   **Branching:** A branch in Git represents an independent line of development. It serves as a sandbox where you can add features or fix bugs without affecting the stable `main` or `master` codebase.
*   **Merging:** Merging is the process of integrating the independent lines of development from a source branch back into the main trunk.
*   **Merge Requests (GitLab) / Pull Requests (GitHub):** In a team environment, instead of merging branches directly on your local machine, developers push their feature branches to a remote server and create a *Merge Request* (GitLab) or *Pull Request* (GitHub). This enables other team members to review the code modifications, comment, run automated checks, and approve the merge.

---

### Step-by-Step Execution Guide

#### Part 1: Branching
1. Initialize/Navigate to the directory and create a new branch named `GitNewBranch`:
   ```bash
   git branch GitNewBranch
   ```
2. List all available local branches (the `*` indicates the active branch you are currently pointing to):
   ```bash
   git branch
   ```
3. Switch to the newly created branch:
   ```bash
   git checkout GitNewBranch
   # OR using modern Git:
   git switch GitNewBranch
   ```
4. Create a new file `branchfile.txt` with some content:
   ```bash
   echo "This content is created in GitNewBranch." > branchfile.txt
   ```
5. Stage and commit the changes:
   ```bash
   git add branchfile.txt
   git commit -m "Add branchfile.txt inside GitNewBranch"
   ```
6. Check status:
   ```bash
   git status
   ```

#### Part 2: Merging
1. Switch back to the primary branch (`main` or `master`):
   ```bash
   git checkout main
   # OR
   git switch main
   ```
2. Compare the differences between the main branch and the feature branch via command line:
   ```bash
   git diff main..GitNewBranch
   ```
3. View visual differences using a configured merge tool (e.g., P4Merge):
   ```bash
   git difftool main..GitNewBranch
   ```
4. Merge `GitNewBranch` into the primary branch:
   ```bash
   git merge GitNewBranch
   ```
5. Observe the merge commit graph and logs:
   ```bash
   git log --oneline --graph --decorate
   ```
6. Delete the feature branch locally now that it has been safely merged:
   ```bash
   git branch -d GitNewBranch
   ```
7. Verify clean repository status:
   ```bash
   git status
   ```

---

### Terminal Logs Output Example

```bash
$ git branch GitNewBranch

$ git branch
  GitNewBranch
* main

$ git checkout GitNewBranch
Switched to branch 'GitNewBranch'

$ echo "This content is created in GitNewBranch." > branchfile.txt

$ git add branchfile.txt

$ git commit -m "Add branchfile.txt inside GitNewBranch"
[GitNewBranch a8b2e1a] Add branchfile.txt inside GitNewBranch
 1 file changed, 1 insertion(+)
 create mode 100644 branchfile.txt

$ git checkout main
Switched to branch 'main'

$ git diff main..GitNewBranch
diff --git a/Week7/Excercise 3/branchfile.txt b/Week7/Excercise 3/branchfile.txt
new file mode 100644
index 0000000..f968962
--- /dev/null
+++ b/Week7/Excercise 3/branchfile.txt
@@ -0,0 +1 @@
+This content is created in GitNewBranch.

$ git merge GitNewBranch
Updating 0401910..a8b2e1a
Fast-forward
 Week7/Excercise 3/branchfile.txt | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 Week7/Excercise 3/branchfile.txt

$ git log --oneline --graph --decorate
* a8b2e1a (HEAD -> main) Add branchfile.txt inside GitNewBranch
* 0401910 Excercise 2
* dd831f4 ...

$ git branch -d GitNewBranch
Deleted branch GitNewBranch (was a8b2e1a).

$ git status
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
```
