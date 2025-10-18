# Crafting Interpreters — My Journey

Following [Crafting Interpreters](https://craftinginterpreters.com/) by Bob Nystrom.  
This repo is a fork of [munificent/craftinginterpreters](https://github.com/munificent/craftinginterpreters)  
and contains my notes, challenge solutions, and experiments.

---

## Progress

| Chapter | Topic                  | Status         |
| ------- | ---------------------- | -------------- |
| 1       | Introduction               | ✅ done         |
| 2       | A map of the territory                | ✅ done |
| 3       | The Lox Language                | 🟡 in progress |
| 4       | Scanning | ⏳ next up      |

---

## 🧠 Structure

| Folder | Description |
| ------- | ------------ |
| `jlox/` | The original Java tree-walk interpreter (book’s first half). |
| `clox/` | The original C bytecode VM (book’s second half). |
| `challenges/` | My Lox scripts and solutions to the book’s “Challenges”. |
| `experiments/` | My own extensions to the interpreters (new syntax, features, etc.). |
| `notes/` | Markdown notes summarizing each chapter’s key concepts and what I learned. |

---

## 🚀 Running Lox

### Java (jlox)
```bash
cd jlox
javac com/craftinginterpreters/lox/*.java
java com.craftinginterpreters.lox.Lox ../challenges/chapter04_scanning/hello.lox
```

### C (clox)
```bash
cd clox
make
./clox ../challenges/chapter04_scanning/hello.lox
```

---