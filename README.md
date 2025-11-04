# Task-Tracker-CL

A simple **command-line task tracker** built with Java.  
It supports adding, listing, updating, and deleting tasks using a lightweight local file-based system.

---

## Features
- Add tasks from the terminal  
- Automatically generates unique incremental IDs  
- Persists tasks in `data/data.json`  
- Tracks task IDs in a hidden `.id` file  
- Includes stubs for `list`, `update`, and `delete`

---

## Commands
| Command | Description | Example |
|----------|--------------|----------|
| `add` | Adds a new task | `java TaskTracker add Finish homework` |
| `list` | Lists all tasks (WIP) | `java TaskTracker list` |
| `update` | Updates an existing task (WIP) | `java TaskTracker update 1 "New Task Title"` |
| `delete` | Deletes a task by ID (WIP) | `java TaskTracker delete 2` |

---

## ⚙️ How It Works
1. The program checks for a `data/` folder; if missing, it creates one.
2. When adding a task:
   - It reads the last used ID from `.id`.
   - Increments it and writes the new task to `data.json`.
   - Each task entry is stored in JSON-like format:
     ```json
     { "id": 3, "task": "Finish homework" }
     ```
3. Commands like `delete`, `update`, and `list` are scaffolded for future expansion.

---
## Setup

Clone the repo, Use javac to compile, then execute commands directly using java:
- java TaskTracker add "Finish documentation"
  
You can also test other commands:
- java TaskTracker list
- java TaskTracker delete 2
- java TaskTracker update 3 "Refactor main class"

