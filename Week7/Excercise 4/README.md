# Git Hands-On Lab: Conflict Resolution

This repository was created for the hands-on lab assignment on Git Conflict Resolution. The main goal was to simulate and resolve a merge conflict when two different changes are made to the same part of the same file (`hello.xml`) on the `main`/`master` branch and a feature branch (`GitWork`).

---

### What is a Merge Conflict?

A **merge conflict** occurs when Git is unable to automatically resolve differences in code between two commits. This typically happens when:
*   Two developers modify the same line(s) of the same file in different branches.
*   One developer deletes a file while another developer is editing it.

When this happens, Git pauses the merge process and highlights the conflicted areas using conflict markers. The developer must manually review, edit, choose the correct changes, and commit the resolved files to finalize the merge.

---

### Step-by-Step Conflict Resolution Guide

#### 1. Verify Status & Create the Branch
Verify that your workspace is clean, then create and switch to the `GitWork` branch:
```bash
git status
git checkout -b GitWork
```

#### 2. Create the File in the Branch
Create `hello.xml` inside `GitWork` with specific XML elements:
```bash
# Create hello.xml
cat <<EOF > hello.xml
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from GitWork branch!</message>
</greeting>
EOF

# Stage and commit the file
git add hello.xml
git commit -m "Create hello.xml with GitWork content"
```

#### 3. Create the Conflicting File in Main
Switch back to the primary branch (`main` or `master`) and create `hello.xml` with different contents:
```bash
git checkout main

# Create hello.xml with conflicting content
cat <<EOF > hello.xml
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from the stable Main branch!</message>
</greeting>
EOF

# Stage and commit
git add hello.xml
git commit -m "Create hello.xml with Main content"
```

#### 4. Compare Differences
1. Observe the divergent history:
   ```bash
   git log --oneline --graph --decorate --all
   ```
2. Inspect the differences between the branches:
   ```bash
   git diff main..GitWork
   # Or using P4Merge or another visual tool:
   git difftool main..GitWork
   ```

#### 5. Trigger the Conflict
Merge the `GitWork` branch into `main`:
```bash
git merge GitWork
```
**Output:**
```text
Auto-merging hello.xml
CONFLICT (content): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.
```

#### 6. Inspect conflict markups in the file
Open `hello.xml`. You will see the standard Git markup markers showing the conflicting blocks:
```xml
<<<<<<< HEAD
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from the stable Main branch!</message>
</greeting>
=======
<?xml version="1.0" encoding="UTF-8"?>
<greeting>
    <message>Hello from GitWork branch!</message>
</greeting>
>>>>>>> GitWork
```

#### 7. Resolve the Conflict
1. Edit `hello.xml` to merge the changes. For example, keep both messages or choose the main branch message:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <greeting>
       <message>Hello from the stable Main branch!</message>
       <message>Hello from GitWork branch!</message>
   </greeting>
   ```
2. Remove all conflict markers (`<<<<<<<`, `=======`, and `>>>>>>>`).
3. Save the file.

#### 8. Commit and Cleanup
1. Stage the resolved file:
   ```bash
   git add hello.xml
   ```
2. Add backup files left by merge tools (e.g. `*.orig`) to your `.gitignore` to avoid tracking them:
   ```bash
   echo "*.orig" >> .gitignore
   git add .gitignore
   ```
3. Commit the conflict resolution to finalize the merge:
   ```bash
   git commit -m "Merge branch 'GitWork' and resolve conflicts in hello.xml"
   ```
4. Delete the branch `GitWork`:
   ```bash
   git branch -d GitWork
   ```
5. View the final git log:
   ```bash
   git log --oneline --graph --decorate
   ```
