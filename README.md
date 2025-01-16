# Data Entry System 📋  
**Version:** 3.0 (MVC Model)  

Welcome to the **Data Entry System** project! This is a Java-based application designed to efficiently manage student data for UG and PG students using the **MVC model** for better interactions and maintainability.  

---

## 🌟 Features  
- **User-Friendly Interface:** Built using Java Swing for seamless interactions.  
- **Modular Design:** Implements the MVC architecture for organized code and scalability.  
- **Data Storage:** Utilizes file-based storage for robust data management.  
- **Future-Ready:** Planned transition to MySQL database for enhanced functionality in future versions.  
- **Collaborative Development:** Open for contributions and enhancements.  

---

## 🛠️ Project Structure  
- `src/`
  - `applications/`  
    * Main application logic
  - `architecture/`  
    * Core MVC architecture
    * `controller/` – Handles business logic
    * `model/` – Represents data
    * `view/` – Swing UI for user interaction
  - `entry/`  
    * Handles record classes
  - `exception/`  
    * Custom exception handling
  - `storage/`  
    * Storage mechanisms
    * `filehandling/` – File-based data storage
  - `student/`  
    * Base classes for student data
    * `ug/` – UG-specific logic
    * `pg/` – PG-specific logic
      
---

## 📂 How to Run  
1. Clone the repository:  
   ```bash
   git clone https://github.com/<your-username>/Data-Entry-System.git
2. Compile and run the project using your Java IDE or terminal.

  ### Compiling and running in terminal
  1. Go to the `src` directory and run the following
      ```bash
      javac -d ../bin applications/*.java
  2. Go to the `bin` directory in the `Data-Entry-System` and run the following
      ```bash
      java applications/App3
  3. The application will launch, and you can interact with it as desired.

**NOTE**: Launching the application (Version 3.0) will display the storage files path on the terminal/console.

---

## 🚀 Upcoming Features
- Integration with MySQL database for advanced data handling.
- Enhanced GUI with modern design patterns.
- Export and import functionality for data management.

---

## 🤝 Contributions
We welcome all contributions to enhance the Data Entry System! Whether it's improving the current codebase, fixing bugs, or adding new features, your efforts are highly appreciated.

🔧 Looking for contributions for **Version 4.0**: Integration with a MySQL database to replace the current file-based storage system.

Feel free to fork the repository, make your changes, and submit a pull request. Let's build something amazing together! 🚀
You can connect with me on LinkedIn to discuss contributions!

---
## 🛡️ License
This project is licensed under the MIT License – feel free to use it responsibly.

---
## ✨ Acknowledgments
Special thanks to everyone contributing to the development of this project. Let's create something amazing together! 🎉
