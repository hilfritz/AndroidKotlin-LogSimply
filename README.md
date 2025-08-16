# LogSimply – Simple Android Logging Utility

LogSimply is a lightweight **Kotlin/Android logging helper** that wraps Android’s `Log` for clean, consistent, and low-boilerplate logging.  
Perfect for demos, sample apps, and production projects where you want **clear logs** without ceremony.

---

## ✨ Features

- Minimal, **Kotlin-first** API
- Common levels: `d`, `i`, `w`, `e`
- Optional **global TAG** with per-call override
- Zero external dependencies

---

## 📦 Getting It

**Option A — Drop-in file (fastest):**  
Copy `logsimply/LogSimply.kt` into your project.

**Option B — Add as a module:**  
1. Copy the `logsimply/` module into your repo.  
2. In `settings.gradle`:
   ```kotlin
   include(":logsimply")
   ```
3. In your app module `build.gradle`:
   ```kotlin
   dependencies {
       implementation(project(":logsimply"))
   }
   ```

> If you publish to Maven later, add coordinates here.

---

## 🚀 Usage

### 1) (Optional) Set a global tag
```kotlin
LogSimply.setTag("MyApp")
```

### 2) Log away
```kotlin
LogSimply.d("MainActivity started")
LogSimply.i("Fetching data from server…")
LogSimply.w("Response was slower than expected")
LogSimply.e("Failed to load user profile")
```

### 3) With custom tag per call
```kotlin
LogSimply.d(tag = "Auth", msg = "Sign-in clicked")
LogSimply.e(tag = "Network", msg = "Timeout contacting API")
```

> API is intentionally tiny; swap to Android’s `Log` anytime without large refactors.

---

## 🧪 Example Output

```
D/MyApp: MainActivity started
I/MyApp: Fetching data from server…
W/MyApp: Response was slower than expected
E/MyApp: Failed to load user profile
```

---

## 📂 Project Structure

```
AndroidKotlin-LogSimply/
├─ app/            # Sample app demonstrating usage
├─ logsimply/      # Library source (drop-in friendly)
│  └─ src/main/kotlin/.../LogSimply.kt
└─ README.md
```

---

## 🛠️ Development

- **Language:** Kotlin
- **Min SDK:** 21 (adjust as needed)
- **Build:** Gradle / Android Studio

Run sample app:
```bash
./gradlew :app:installDebug
```

---

## 🤝 Contributing

PRs welcome! For features and fixes:
- Keep API surface minimal
- Add small usage snippet to README if needed

---

## 👤 Author

**Hilfritz Pepino Camallere**  
Niagara Falls, Ontario, Canada  
Software Engineer • Data Analyst

- LinkedIn: https://www.linkedin.com/in/hilfritzcamallere/

---

## 📜 License

MIT — see `LICENSE` for details.
